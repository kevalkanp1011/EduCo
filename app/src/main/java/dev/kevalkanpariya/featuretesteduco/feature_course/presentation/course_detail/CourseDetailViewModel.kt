package dev.kevalkanpariya.featuretesteduco.feature_course.presentation.course_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.domain.states.StandardTextFieldState
import dev.kevalkanpariya.featuretesteduco.core.domain.use_case.GetOwnUserIdUseCase
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.UiEvent
import dev.kevalkanpariya.featuretesteduco.core.util.ParentType
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.core.util.UiText
import dev.kevalkanpariya.featuretesteduco.feature_auth.domain.use_case.AuthenticateUseCase
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case.*
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.saved.BookmarkState
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.util.CommentError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import java.net.URLConnection
import javax.inject.Inject


@HiltViewModel
class CourseDetailViewModel @Inject constructor(
    private val authenticate: AuthenticateUseCase,
    private val getOwnUserId: GetOwnUserIdUseCase,
    private val getCourseDetails: GetCourseDetailsUseCase,
    private val getCommentsForCourse: GetCommentsForCourseUseCase,
    private val createCommentUseCase: CreateCommentUseCase,
    private val getLessonsForCourse: GetLessonsForCourse,
    private val getResourcesForCourse: GetResourcesForCourse,
    private val toggleLikeForParentUseCase: ToggleLikeForParentUseCase,
    private val savedStateHandle: SavedStateHandle,
    private val addToBookmarkedCourses: AddToBookmarkedCoursesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CourseDetailState())
    val state: StateFlow<CourseDetailState> = _state.asStateFlow()

    private val _courseOverviewState = MutableStateFlow(CourseOverviewState())
    val courseOverviewState: StateFlow<CourseOverviewState> = _courseOverviewState.asStateFlow()

    private val _isBookmarked = mutableStateOf(false)
    val isBookmarked: State<Boolean> = _isBookmarked

    /*private val _lessonsState = MutableStateFlow(LessonDetailState())
    val lessonsState: StateFlow<LessonDetailState> = _lessonsState.asStateFlow()

    private val _commentsState = MutableStateFlow(CommentDetailState())
    val commentsState: StateFlow<CommentDetailState> = _commentsState.asStateFlow()

    private val _projectsState = MutableStateFlow(ProjectDetailState())
    val projectsState: StateFlow<ProjectDetailState> = _projectsState.asStateFlow()

    private val _resourcesState = MutableStateFlow(ResourceDetailState())
    val resourcesState: StateFlow<ResourceDetailState> = _resourcesState.asStateFlow()
*/

    private val _userState = mutableStateOf(UserDetailState())
    val userState: State<UserDetailState> = _userState

    private val _commentTextFieldState = mutableStateOf(StandardTextFieldState(error = CommentError.FieldEmpty))
    val commentTextFieldState: State<StandardTextFieldState> = _commentTextFieldState

    private val _commentState = mutableStateOf(CommentState())
    val commentState: State<CommentState> = _commentState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var isUserLoggedIn = false

    init {
        savedStateHandle.get<String>("courseId")?.let { courseId ->
            loadCourseDetails(courseId)
            loadCommentsForCourse(courseId)
            loadLessonsForCourse(courseId)
            loadResourcesForCourse(courseId)
        }
    }

    fun onEvent(event: CourseDetailEvent) {
        when(event) {
            is CourseDetailEvent.Comment -> {
                createComment(
                    courseId = savedStateHandle.get<String>("courseId") ?: "",
                    comment = commentTextFieldState.value.text
                )
            }
            is CourseDetailEvent.LikeComment -> {
                val isLiked = state.value.comments.find {
                    it.id == event.commentId
                }?.isLiked == true
                toggleLikeForParent(
                    parentId = event.commentId,
                    parentType = ParentType.Comment.type,
                    isLiked = isLiked
                )
            }
            is CourseDetailEvent.EnteredComment -> {
                _commentTextFieldState.value = commentTextFieldState.value.copy(
                    text = event.comment,
                    error = if(event.comment.isBlank()) CommentError.FieldEmpty else null
                )
            }
        }
    }

    fun addCourseToBookmark() {
        viewModelScope.launch {
            val courseId = savedStateHandle.get<String>("courseId")?: ""
            val result = addToBookmarkedCourses(
                userId = getOwnUserId(),
                courseId = courseId
            )

            when (result) {
                is Resource.Success -> {
                    _isBookmarked.value = true
                }
                is Resource.Error -> {
                    _eventFlow.emit(UiEvent.ShowSnackBar(
                        uiText = result.uiText ?: UiText.unknownError()
                    ))
                }
            }
        }
    }

    private fun toggleLikeForParent(
        parentId: String,
        parentType: Int,
        isLiked: Boolean
    ) {
        viewModelScope.launch {
            isUserLoggedIn = authenticate() is Resource.Success
            if(!isUserLoggedIn) {
                _eventFlow.emit(UiEvent.ShowSnackBar(UiText.StringResource(R.string.error_not_logged_in)))
                return@launch
            }
            when(parentType) {
                ParentType.Comment.type -> {
                    _state.value = state.value.copy(
                        comments = state.value.comments.map { comment ->
                            if(comment.id == parentId) {
                                comment.copy(
                                    isLiked = !isLiked,
                                    likeCount = if (isLiked) {
                                        comment.likeCount - 1
                                    } else comment.likeCount + 1
                                )
                            } else comment
                        }
                    )
                }
            }
            val result = toggleLikeForParentUseCase(
                parentId = parentId,
                parentType = parentType,
                isLiked = isLiked
            )
            when(result) {
                is Resource.Success -> Unit
                is Resource.Error -> {
                    when(parentType) {
                        ParentType.Comment.type -> {
                            _state.value = state.value.copy(
                                comments = state.value.comments.map { comment ->
                                    if(comment.id == parentId) {
                                        comment.copy(
                                            isLiked = isLiked,
                                            likeCount = if(comment.isLiked) {
                                                comment.likeCount - 1
                                            } else comment.likeCount + 1
                                        )
                                    } else comment
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    private fun createComment(courseId: String, comment: String) {
        viewModelScope.launch {
            isUserLoggedIn = authenticate() is Resource.Success
            if(!isUserLoggedIn) {
                _eventFlow.emit(UiEvent.ShowSnackBar(UiText.StringResource(R.string.error_not_logged_in)))
                return@launch
            }

            _commentState.value = commentState.value.copy(
                isLoading = true
            )
            val result = createCommentUseCase(
                courseId = courseId,
                comment = comment
            )
            when(result) {
                is Resource.Success -> {
                    _eventFlow.emit(UiEvent.ShowSnackBar(
                        uiText = UiText.StringResource(R.string.comment_posted)
                    ))
                    _commentState.value = commentState.value.copy(
                        isLoading = false
                    )
                    _commentTextFieldState.value = commentTextFieldState.value.copy(
                        text = "",
                        error = CommentError.FieldEmpty
                    )
                    loadCommentsForCourse(courseId)
                }
                is Resource.Error -> {
                    _eventFlow.emit(UiEvent.ShowSnackBar(
                        uiText = result.uiText ?: UiText.unknownError()
                    ))
                    _commentState.value = commentState.value.copy(
                        isLoading = false
                    )
                }
            }
        }
    }

    private fun loadCourseDetails(courseId: String) {
        viewModelScope.launch {
            _state.value = state.value.copy(
                isLoadingCourse = true
            )
            _courseOverviewState.value = courseOverviewState.value.copy(
                isLoadingOverview = true
            )
            val result = getCourseDetails(courseId)
            when(result) {
                is Resource.Success -> {
                    _state.value = state.value.copy(
                        course = result.data,
                        isLoadingCourse = false
                    )
                    _courseOverviewState.value = courseOverviewState.value.copy(
                        rating = result.data?.avgRating,
                        description = result.data?.description,
                        noOfStudentEnrolled = result.data?.noOfStudentEnrolled,
                        commentCount = result.data?.commentCount
                    )
                }
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        isLoadingCourse = false
                    )
                    _courseOverviewState.value = courseOverviewState.value.copy(
                        isLoadingOverview = false
                    )
                    _eventFlow.emit(
                        UiEvent.ShowSnackBar(
                            result.uiText ?: UiText.unknownError()
                        )
                    )
                }
            }
        }
    }

    private fun loadCommentsForCourse(courseId: String) {
        viewModelScope.launch {
            _state.value = state.value.copy(
                isLoadingComments = true
            )
            val result = getCommentsForCourse(courseId)
            when(result) {
                is Resource.Success -> {
                    _state.value = state.value.copy(
                        comments = result.data ?: emptyList(),
                        isLoadingComments = false
                    )
                }
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        isLoadingComments = false
                    )
                }
            }
        }
    }



    private fun loadResourcesForCourse(courseId: String) {
        viewModelScope.launch {
            _state.value = state.value.copy(
                isLoadingResources = true
            )
            val result = getResourcesForCourse(courseId)
            when(result) {
                is Resource.Success -> {
                    _state.value = state.value.copy(
                        resources = result.data ?: emptyList(),
                        isLoadingResources = false
                    )
                }
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        isLoadingResources = false
                    )
                }
            }
        }
    }

    private fun loadLessonsForCourse(courseId: String) {
        viewModelScope.launch {
            _state.value = state.value.copy(
                isLoadingLessons = true
            )
            val result = getLessonsForCourse(courseId)
            when(result) {
                is Resource.Success -> {
                    _state.value = state.value.copy(
                        lessons = result.data ?: emptyList(),
                        isLoadingLessons = false
                    )
                }
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        isLoadingLessons = false
                    )
                }
            }
        }
    }
}


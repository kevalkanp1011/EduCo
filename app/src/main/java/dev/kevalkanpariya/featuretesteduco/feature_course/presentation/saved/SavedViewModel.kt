package dev.kevalkanpariya.featuretesteduco.feature_course.presentation.saved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kevalkanpariya.featuretesteduco.core.domain.use_case.GetOwnUserIdUseCase
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.UiEvent
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.core.util.UiText
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case.AddToBookmarkedCoursesUseCase
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case.GetBookmarkedCoursesUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedViewModel @Inject constructor(
    private val getBookmarkedCoursesUseCase: GetBookmarkedCoursesUseCase,
    private val addToBookmarkedCoursesUseCase: AddToBookmarkedCoursesUseCase,
    private val getOwnUserId: GetOwnUserIdUseCase
): ViewModel() {

    private val _bookmarkedCourses = MutableStateFlow(BookmarkState())
    val bookmarkedCourses: StateFlow<BookmarkState> = _bookmarkedCourses

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        loadBookmarkedCourses()
    }

    fun loadBookmarkedCourses() {
        viewModelScope.launch {
            _bookmarkedCourses.value = bookmarkedCourses.value.copy(
                isLoading = true
            )
            val result = getBookmarkedCoursesUseCase(getOwnUserId())

            when (result) {
                is Resource.Success -> {
                    _bookmarkedCourses.value = bookmarkedCourses.value.copy(
                        isLoading = false,
                        courses = result.data
                    )
                }
                is Resource.Error -> {
                    _bookmarkedCourses.value = bookmarkedCourses.value.copy(
                        isLoading = false
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
}
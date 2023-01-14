package dev.kevalkanpariya.featuretesteduco.presentation.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.kevalkanpariya.featuretesteduco.domain.model.ApiResponse
import dev.kevalkanpariya.featuretesteduco.domain.model.Course
import dev.kevalkanpariya.featuretesteduco.domain.model.CourseRequest
import dev.kevalkanpariya.featuretesteduco.domain.model.MessageBarState
import dev.kevalkanpariya.featuretesteduco.domain.repository.CourseRepository
import dev.kevalkanpariya.featuretesteduco.util.RequestState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val repository: CourseRepository
): ViewModel() {

    private val _apiResponse: MutableState<RequestState<ApiResponse>> =
        mutableStateOf(RequestState.Idle)
    val apiResponse: State<RequestState<ApiResponse>> = _apiResponse

    private val _course: MutableState<Course?> = mutableStateOf(null)
    val course: State<Course?> = _course


    private fun getCourseInfo(courseId: CourseRequest) {
        viewModelScope.launch(Dispatchers.IO){
            try {
                _apiResponse.value = RequestState.Loading
                val response = withContext(Dispatchers.IO) {
                    repository.getCourseById(courseId)
                }
                _apiResponse.value = RequestState.Success(response)

            } catch (e: Exception) {
                _apiResponse.value = RequestState.Error(e)

            }
        }
    }

}
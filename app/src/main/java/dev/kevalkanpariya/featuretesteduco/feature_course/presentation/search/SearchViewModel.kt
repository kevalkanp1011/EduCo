package dev.kevalkanpariya.featuretesteduco.feature_course.presentation.search

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kevalkanpariya.featuretesteduco.core.domain.models.CourseOverview
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case.GetDiscoverCoursesUseCase
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case.GetPopularCategoriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getDiscoverCourses: GetDiscoverCoursesUseCase,
    private val getPopularCategories: GetPopularCategoriesUseCase
): ViewModel() {

    private val _discoverCourses: MutableStateFlow<PagingData<CourseOverview>> =
        MutableStateFlow(PagingData.empty())
    val discoverCourses
        get() = _discoverCourses.asStateFlow()


}
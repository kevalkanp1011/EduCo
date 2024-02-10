package dev.kevalkanpariya.educo.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dev.kevalkanpariya.educo.domain.model.Student

class SharedViewModel: ViewModel() {

    var user by mutableStateOf<Student?>(null)
        private set

    fun addUser(student: Student) {
        user = student
    }
}
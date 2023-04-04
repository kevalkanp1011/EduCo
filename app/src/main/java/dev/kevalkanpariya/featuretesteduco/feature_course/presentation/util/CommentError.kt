package dev.kevalkanpariya.featuretesteduco.feature_course.presentation.util

import dev.kevalkanpariya.featuretesteduco.core.util.Error
sealed class CommentError : Error() {
    object FieldEmpty: CommentError()
}
package dev.kevalkanpariya.featuretesteduco.core.util

interface Paginator<T> {

    suspend fun loadNextItems()
}
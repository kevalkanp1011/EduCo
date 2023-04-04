package dev.kevalkanpariya.featuretesteduco.core.util

object Constants {


    const val STARTING_PAGE = 1
    const val NETWORK_PAGE_SIZE = 10

    object SortBy {
        const val FREE_CLASSES = "free_classes"
        const val PREMIUM_CLASSES = "premium_classes"
        const val ALL = "all"
    }


    object Filter {
        const val SORT_BY = "sort_by"
        const val LEVEL = "level"
        const val DURATION = "duration"
    }


    const val SPLASH_SCREEN_DURATION = 2000L

    const val MAX_POST_DESCRIPTION_LINES = 3

    const val MIN_USERNAME_LENGTH = 3
    const val MIN_PASSWORD_LENGTH = 3

    const val DEFAULT_PAGE_SIZE = 5
    const val DEFAULT_PAGE = 0

    const val KEY_JWT_TOKEN = "jwt_token"
    const val KEY_USER_ID = "userId"

    const val SHARED_PREF_NAME = "shared_pref"

    const val RECONNECT_INTERVAL = 5000L
}
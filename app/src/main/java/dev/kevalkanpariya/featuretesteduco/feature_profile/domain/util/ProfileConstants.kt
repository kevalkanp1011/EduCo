package dev.kevalkanpariya.featuretesteduco.feature_profile.domain.util

object ProfileConstants {

    val FACEBOOK_PROFILE_REGEX = "(https://)?(www\\.)?facebook\\.com/[A-z0-9_-]+/?".toRegex()
    val INSTAGRAM_PROFILE_REGEX = "(https?://)?(www\\.)?instagram\\.com/[a-z_\\-A-Z0-9]*".toRegex()
    val TWITTER_PROFILE_REGEX = "http(s)?://([\\w]+\\.)?twitter\\.com/in/[A-z0-9_-]+/?".toRegex()

    const val SEARCH_DELAY = 700L

}
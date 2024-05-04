package dev.kevalkanpariya.educo.di

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import androidx.credentials.CredentialManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dev.kevalkanpariya.educo.feature_auth.data.repoImpl.AuthRepoImpl
import dev.kevalkanpariya.educo.feature_course.data.repoImpl.CourseRepoImpl
import dev.kevalkanpariya.educo.feature_auth.domain.repository.AuthRepository
import dev.kevalkanpariya.educo.feature_course.domain.repository.CourseRepository
import dev.kevalkanpariya.educo.feature_auth.presentation.viewmodels.AuthViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { FirebaseFirestore.getInstance() }

    single { FirebaseAuth.getInstance() }
    //Repositories
    single<AuthRepository> { AuthRepoImpl(get(), get()) }
    single<CourseRepository> { CourseRepoImpl(get()) }

    single<SharedPreferences> {
        androidApplication().getSharedPreferences(
            "user_activity",
            Context.MODE_PRIVATE
        )
    }

    single<CredentialManager> { CredentialManager.create(androidApplication()) }

    viewModel { AuthViewModel(get(), get()) }


}
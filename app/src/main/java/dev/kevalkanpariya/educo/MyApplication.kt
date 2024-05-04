package dev.kevalkanpariya.educo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dev.kevalkanpariya.educo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin


class EduCoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@EduCoApplication)
            modules(appModule)
        }
    }
}
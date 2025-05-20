package com.vadimkarch.dbpractice

import android.app.Application
import com.vadimkarch.dbpractice.di.applicationModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class DBPracticeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@DBPracticeApplication)
            modules(applicationModules)
        }
    }
}
package br.com.safeguardian

import android.app.Application
import br.com.safeguardian.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Application: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@Application)
            modules(mainModule, databaseModule, repositoryModule)
        }
    }
}
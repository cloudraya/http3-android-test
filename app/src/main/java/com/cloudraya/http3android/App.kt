package com.cloudraya.http3android

import android.app.Application
import com.google.android.gms.net.CronetProviderInstaller

class App: Application() {
    override fun onCreate() {
        CronetProviderInstaller.installProvider(applicationContext)
        super.onCreate()
    }
}
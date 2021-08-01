package com.dt.test

import android.app.Application

/**
 * DT test application.
 */
class DTApp: Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        lateinit var context: DTApp private set
    }
}
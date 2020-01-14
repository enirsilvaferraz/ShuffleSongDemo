package com.eferraz.shufflesongs.infra

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.eferraz.shufflesongs.TestAppApplication

class CustomTestRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, TestAppApplication::class.java.name, context)
    }
}
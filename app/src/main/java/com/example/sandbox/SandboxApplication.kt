package com.example.sandbox

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class SandboxApplication : Application(), KodeinAware {
    override val kodein: Kodein
        get() = TODO("Not yet implemented")
}
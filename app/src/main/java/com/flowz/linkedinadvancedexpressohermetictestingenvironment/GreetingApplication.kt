package com.flowz.linkedinadvancedexpressohermetictestingenvironment

import android.app.Application
import dagger.internal.DaggerCollections

open class GreetingApplication: Application() {

//    open fun provideClock(): Clock = Clock()

    open val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
        DaggerApplicationComponent.builder()
            .clockModule(ClockModule)
            .build()

    }
}
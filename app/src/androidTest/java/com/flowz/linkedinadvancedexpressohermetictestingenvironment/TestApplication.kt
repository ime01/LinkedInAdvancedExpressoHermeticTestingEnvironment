package com.flowz.linkedinadvancedexpressohermetictestingenvironment

import org.mockito.Mockito

class TestApplication:GreetingApplication() {

    override  lateinit var component: ApplicationComponent


//    private val clock: Clock by lazy{
//        Mockito.mock(Clock::class.java)
//    }

//    fun setClock(clock: Clock){
//       this.clock = clock
//    }

//    override fun provideClock(): Clock = clock
}
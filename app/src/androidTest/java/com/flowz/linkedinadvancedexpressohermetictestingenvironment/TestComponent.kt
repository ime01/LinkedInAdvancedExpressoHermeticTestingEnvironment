package com.flowz.linkedinadvancedexpressohermetictestingenvironment

import dagger.BindsInstance
import dagger.Component

@Component
interface  TestComponent: ApplicationComponent{

    @Component.Builder
    interface Builder{

        fun build():TestComponent

        @BindsInstance
        fun clock(clock: Clock): Builder
    }
}
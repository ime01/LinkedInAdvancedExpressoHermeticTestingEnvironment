package com.flowz.linkedinadvancedexpressohermetictestingenvironment

import org.joda.time.DateTime

open class Clock {
  open  fun getNow() = DateTime()
}
package com.example.doubleratchetpoc

import java.security.SecureRandom

/**
 * @author Michal Ozaniak
 */
object Configuration {

    val APP_SPECIFIC_INFO = ByteArray(32)

    init {
        SecureRandom().nextBytes(APP_SPECIFIC_INFO)
    }

}
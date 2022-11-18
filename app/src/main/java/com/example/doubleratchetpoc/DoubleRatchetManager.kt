package com.example.doubleratchetpoc

import com.example.doubleratchetpoc.core.DoubleRatchet
import java.security.Security

/**
 * @author Michal Ozaniak
 */
class DoubleRatchetManager {

    private object Holder {
        val DOUBLE_RATCHET = DoubleRatchet.build(Configuration.APP_SPECIFIC_INFO) {}
    }

    companion object {
        val doubleRatchet: DoubleRatchet by lazy { Holder.DOUBLE_RATCHET }
    }

}
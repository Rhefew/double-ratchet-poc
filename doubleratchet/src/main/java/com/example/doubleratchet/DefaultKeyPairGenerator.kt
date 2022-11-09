package com.example.doubleratchet

import com.example.doubleratchet.DefaultKeyPair
import org.whispersystems.curve25519.Curve25519

/**
 * @author Michal Ozaniak
 */
class DefaultKeyPairGenerator : DoubleRatchetKeyPairGenerator {

    override fun generateKeyPair(): DoubleRatchetKeyPair =
            DefaultKeyPair(Curve25519.getInstance(Curve25519.BEST).generateKeyPair())

}
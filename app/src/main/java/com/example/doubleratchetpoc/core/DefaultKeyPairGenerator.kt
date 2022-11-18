package com.example.doubleratchetpoc.core


/**
 * @author Michal Ozaniak
 */
class DefaultKeyPairGenerator : DoubleRatchetKeyPairGenerator {

    override fun generateKeyPair(): DoubleRatchetKeyPair =
            DefaultKeyPair(generateECKeys()!!)

}
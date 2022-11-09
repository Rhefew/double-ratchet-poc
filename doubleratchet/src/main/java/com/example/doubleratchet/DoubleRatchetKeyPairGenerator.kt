package com.example.doubleratchet

/**
 * @author Michal Ozaniak
 */
interface DoubleRatchetKeyPairGenerator {
    fun generateKeyPair(): DoubleRatchetKeyPair
}
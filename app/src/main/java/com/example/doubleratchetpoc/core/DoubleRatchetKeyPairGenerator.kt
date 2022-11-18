package com.example.doubleratchetpoc.core

/**
 * @author Michal Ozaniak
 */
interface DoubleRatchetKeyPairGenerator {
    fun generateKeyPair(): DoubleRatchetKeyPair
}
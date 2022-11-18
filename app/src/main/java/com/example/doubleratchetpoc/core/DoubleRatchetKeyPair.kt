package com.example.doubleratchetpoc.core

/**
 * @author Michal Ozaniak
 */
interface DoubleRatchetKeyPair {
    fun getPublicKey(): ByteArray
    fun getPrivateKey(): ByteArray
    fun getAgreement(publicKey: ByteArray): ByteArray
}
package com.example.doubleratchetpoc.core

/**
 * @author Michal Ozaniak
 */
data class DoubleRatchetPacket(
        val header: DoubleRatchetHeader,
        val body: ByteArray
)
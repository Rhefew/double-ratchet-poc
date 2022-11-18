package com.example.doubleratchetpoc.core

import org.spongycastle.jce.ECNamedCurveTable
import java.security.*
import javax.crypto.KeyAgreement

/**
 * @author Michal Ozaniak
 */
class DefaultKeyPair(val keyPair: KeyPair) : DoubleRatchetKeyPair {

    override fun getPublicKey(): ByteArray = keyPair.public.encoded

    override fun getPrivateKey(): ByteArray = keyPair.private.encoded

    override fun getAgreement(publicKey: ByteArray): ByteArray =
            KeyAgreement.getInstance("ECDH", "AndroidKeyStore")
                .generateSecret()

}

fun generateECKeys(): KeyPair? {
    return try {
        val parameterSpec =
//            ECNamedCurveTable.getParameterSpec("brainpoolp256r1")
            ECNamedCurveTable.getParameterSpec("secp256r1")
        val keyPairGenerator: KeyPairGenerator = KeyPairGenerator.getInstance(
            "ECDH", "BC"
        )
        keyPairGenerator.initialize(parameterSpec)
        keyPairGenerator.generateKeyPair()
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
        null
    } catch (e: InvalidAlgorithmParameterException) {
        e.printStackTrace()
        null
    } catch (e: NoSuchProviderException) {
        e.printStackTrace()
        null
    }
}
package com.example.doubleratchetpoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.spongycastle.jce.provider.BouncyCastleProvider
import java.security.Security

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        Security.addProvider(BouncyCastleProvider())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val doubleRatchet = DoubleRatchetManager.doubleRatchet

        // Established shared key
        val keyPairAlice = doubleRatchet.generateKeyPair()
        val keyPairBob = doubleRatchet.generateKeyPair()
        val SKBob = keyPairBob.getAgreement(keyPairAlice.getPublicKey())
        val SKAlice = keyPairAlice.getAgreement(keyPairBob.getPublicKey())

        // Initializing Bob
        val bob = User("Bob", doubleRatchet.createReceiverState(keyPairBob, SKBob))

        // Initializing Alice
        val alice = User("Alice", doubleRatchet.createInitiatorState(SKAlice, keyPairBob.getPublicKey()))

        // Test 1
        alice.sendMessage(bob, "Hello Bob!")
        bob.sendMessage(alice, "Hi Alice, how are you?")
        alice.sendMessage(bob, "I'm fine, what about you?")

        // Test 2
        bob.sendMessage(alice, "Bob's first message in a row")
        bob.sendMessage(alice, "Bob's second message in a row")
        bob.sendMessage(alice, "Bob's third message in a row")

        // Test 3
        alice.sendMessage(bob, "Alice's first message in a row")
        alice.sendMessage(bob, "Alice's second message in a row")
        alice.sendMessage(bob, "Alice's third message in a row")

        // Test 4
        val undeliveredPacket1 = bob.forceSkipMessage(alice, "Bob's skipped message")
        bob.sendMessage(alice, "Bob's message after skipped message")
        bob.deliverSkippedMessage(alice, undeliveredPacket1)

    }
}
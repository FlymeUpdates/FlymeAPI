package ru.transaero21.flymeapi.shared

import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.Mac
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec
import javax.crypto.spec.SecretKeySpec

actual fun getMd5Sign(input: String, key: String): String {
    return MessageDigest.getInstance("MD5").digest((input + key).toByteArray()).toHexString()
}

actual fun getHmacSha256Sign(input: String, key: String): String {
    val mac = Mac.getInstance("HmacSHA256")
    val secret = SecretKeySpec(key.toByteArray(), "HmacSHA256")
    mac.init(secret)
    return mac.doFinal(input.toByteArray()).toHexString()
}

actual fun getDesSign(input: String, key: String): String {
    val keyFactory = SecretKeyFactory.getInstance("DES")
    val secretKey = keyFactory.generateSecret(DESKeySpec(key.toByteArray()))
    val cipher = Cipher.getInstance("DES")
    cipher.init(Cipher.ENCRYPT_MODE, secretKey)
    return cipher.doFinal(input.toByteArray()).toHexString()
}

fun ByteArray.toHexString(): String {
    return this.joinToString("") { "%02x".format(it) }
}

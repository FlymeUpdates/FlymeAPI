package ru.transaero21.flymeapi.shared

import kotlin.js.json

actual fun getMd5Sign(input: String, key: String): String {
    return CryptoJS.MD5(input + key).toString()
}

actual fun getHmacSha256Sign(input: String, key: String): String {
    return CryptoJS.HmacSHA256(input, key).toString()
}

actual fun getDesSign(input: String, key: String): String {
    val keyBytes = CryptoJS.enc.Utf8.parse(key)
    println(keyBytes)
    val encrypted = CryptoJS.DES.encrypt(
        input, keyBytes, json(
            "mode" to CryptoJS.mode.ECB,
            "padding" to CryptoJS.pad.Pkcs7
        )
    )
    return CryptoJS.enc.Hex.stringify(encrypted.ciphertext)
}

package ru.transaero21.flymeapi.shared

@Suppress("FunctionName", "PropertyName")
@JsModule("crypto-js")
@JsNonModule
external object CryptoJS {
    fun MD5(message: String): dynamic
    fun HmacSHA256(message: String, key: String): dynamic

    val DES: DESModule
    val enc: EncodingModule
    val mode: ModeModule
    val pad: PaddingModule

    interface DESModule {
        fun encrypt(
            message: String,
            key: dynamic,
            options: dynamic
        ): CipherParams
    }

    interface CipherParams {
        val ciphertext: dynamic
        fun toString(format: String = definedExternally): String
    }

    interface EncodingModule {
        val Utf8: Encoding
        val Hex: Encoding
    }

    interface Encoding {
        fun parse(input: String): dynamic
        fun stringify(bytes: dynamic): String
    }

    interface ModeModule {
        val ECB: dynamic
    }

    interface PaddingModule {
        val Pkcs7: dynamic
    }
}
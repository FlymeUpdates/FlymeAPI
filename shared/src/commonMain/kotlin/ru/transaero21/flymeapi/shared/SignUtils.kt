package ru.transaero21.flymeapi.shared

fun <K: Comparable<K>, V> getHmacSha256Sign(input: Map<K, V>, key: String): String {
    return getHmacSha256Sign(input.toMap().entries.joinToString("&") { "${it.key}=${it.value}" }, key)
}

expect fun getMd5Sign(input: String, key: String): String
expect fun getHmacSha256Sign(input: String, key: String): String
expect fun getDesSign(input: String, key: String): String
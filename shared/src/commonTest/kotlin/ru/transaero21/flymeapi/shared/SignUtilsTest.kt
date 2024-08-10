@file:Suppress("SpellCheckingInspection")

package ru.transaero21.flymeapi.shared

import kotlin.test.Test
import kotlin.test.assertEquals

private data class HashTestData(
    val input: String,
    val key: String,
    val sign: String
)

class SignUtilsTest {
    @Test
    fun shouldReturnCorrectMD5SignatureCase1() {
        val testCase = HashTestData(
            input = "BGJn2cCQOX",
            key = "igTYXTj7lm",
            sign = "c2802196793554cf930e84a7520722fd"
        )
        assertEquals(testCase.sign, getMd5Sign(testCase.input, testCase.key))
    }

    @Test
    fun shouldReturnCorrectMD5SignatureCase2() {
        val testCase = HashTestData(
            input = "A8vC33DaJ2",
            key = "4W3qYCpGoT",
            sign = "b1ef9fe25fc7baff61e2895142448e07"
        )
        assertEquals(testCase.sign, getMd5Sign(testCase.input, testCase.key))
    }

    @Test
    fun shouldReturnCorrectMD5SignatureCase3() {
        val testCase = HashTestData(
            input = "UzbyMOCrY6",
            key = "ELMTF6xzM0",
            sign = "ec12e0e2a11143edb0df806253237251"
        )
        assertEquals(testCase.sign, getMd5Sign(testCase.input, testCase.key))
    }

    @Test
    fun shouldReturnCorrectHmacSha256SignatureCase1() {
        val testCase = HashTestData(
            input = "cScWtJdVco",
            key = "qtXzdb79gP",
            sign = "c61f3321e9f1930585a8231bca45251c0d9452bcd541840cfcd5dc17339ff8f6"
        )
        assertEquals(testCase.sign, getHmacSha256Sign(testCase.input, testCase.key))
    }

    @Test
    fun shouldReturnCorrectHmacSha256SignatureCase2() {
        val testCase = HashTestData(
            input = "ieKpNrr8upCuSIPtRHH3",
            key = "z7ANrBzD7k6tj47x04Om",
            sign = "f6211fd2c11149d6d02c33d0b947cf73a54fa6a62d544ed086a05a570f04b385"
        )
        assertEquals(testCase.sign, getHmacSha256Sign(testCase.input, testCase.key))
    }

    @Test
    fun shouldReturnCorrectHmacSha256SignatureCase3() {
        val testCase = HashTestData(
            input = "yr2I86Abz34Vp8P",
            key = "aemaYhknpG2jTGO",
            sign = "a84dc53d8a73fabab07509f5970f9030087a1eecd7ebcd4d693f4f073225ddbf"
        )
        assertEquals(testCase.sign, getHmacSha256Sign(testCase.input, testCase.key))
    }

    @Test
    fun shouldReturnCorrectDesSignatureCase1() {
        val testCase = HashTestData(
            input = "cqFjuwgUCgUeoF9",
            key = "O3ODlwz9U6eLGjV",
            sign = "e7e5ed51bf4615dd986fd70ce3fe483f"
        )
        assertEquals(testCase.sign, getDesSign(testCase.input, testCase.key))
    }

    @Test
    fun shouldReturnCorrectDesSignatureCase2() {
        val testCase = HashTestData(
            input = "3XoM96IVuK",
            key = "bqM81YDO7j",
            sign = "0404cdf11d55366fd357e075451a74a2"
        )
        assertEquals(testCase.sign, getDesSign(testCase.input, testCase.key))
    }

    @Test
    fun shouldReturnCorrectDesSignatureCase3() {
        val testCase = HashTestData(
            input = "3wkbfscRRMOPJ",
            key = "JFHmMUmrjWlGl",
            sign = "140ef81e42ab89d1f863f29c4fee00e1"
        )
        assertEquals(testCase.sign, getDesSign(testCase.input, testCase.key))
    }
}

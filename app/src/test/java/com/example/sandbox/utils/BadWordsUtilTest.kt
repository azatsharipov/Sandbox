package com.example.sandbox.utils

import org.junit.Test

import org.junit.Assert.*

class BadWordsUtilTest {

    @Test
    fun `contains bad words return true`() {
        var result = BadWordsUtil.isContains("fuck")
        assertTrue(result)
        result = BadWordsUtil.isContains("suck")
        assertTrue(result)
    }

    @Test
    fun `contains bad words ignoring case return true`() {
        var result = BadWordsUtil.isContains("FUCK")
        assertTrue(result)
        result = BadWordsUtil.isContains("something SucK another text")
        assertTrue(result)
    }

    @Test
    fun `doesn't contain bad words return false`() {
        var result = BadWordsUtil.isContains("luck")
        assertFalse(result)
        result = BadWordsUtil.isContains("sun")
        assertFalse(result)
    }

    @Test
    fun `empty text return false`() {
        val result = BadWordsUtil.isContains("")
        assertFalse(result)
    }

}
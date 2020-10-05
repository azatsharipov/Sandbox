package com.example.sandbox.utils

object BadWordsUtil {
    val badWords = arrayOf("fuck", "suck")

    fun isContains(text: String?): Boolean {
        if (badWords.contains(text)) {
            return true
        } else {
            return false
        }
    }
}
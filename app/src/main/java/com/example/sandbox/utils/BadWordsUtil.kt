package com.example.sandbox.utils

object BadWordsUtil {
    val badWords = arrayOf("fuck", "suck")

    fun isContains(text: String?): Boolean {
        val words = text?.split(" ")
        words?.forEach {
            if (badWords.contains(it.toLowerCase()))
                return true
        }
        return false
    }
}
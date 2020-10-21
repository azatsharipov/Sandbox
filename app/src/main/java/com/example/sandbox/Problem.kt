package com.example.sandbox

import java.util.*
import java.util.Collections.max
import kotlin.collections.ArrayList
import kotlin.math.max

/**
 * 4 1 2 -> 1..2,4
 * 5 3 1 -> 1,3,5
 * 5 3 4 2 -> 2..5
 * 2 4 5 -> 2,4..5
 */

class Node(
    var elem: Int,
    var node: Node?
)

fun reverse(head: Node): Node? {
    var reversed: Node? = null
    var list: Node? = head
    while (list?.node != null) {
        list?.let {
            reversed = Node(it.elem, reversed)
        }
        list = list?.node
    }
    list?.let {
        reversed = Node(it.elem, reversed)
    }
    return reversed
}

//([1] -> 2 -> 3) => (1 <- 2 <- [3])

fun listToSegments(list: MutableList<Int>): String {
    var s = ""
    Collections.sort(list)
    var l = 0
    println(list)
    while (l < list.size) {
        var r = l
        while (r + 1 < list.size) {
            if (list[r + 1] - list[r] != 1)
                break
            r++
        }
        if (r == l)
            s = s + "${list[l]},"
        else
            s = s + "${list[l]..list[r]},"
        l = r + 1
    }
    return s.subSequence(0, s.length - 1) as String
}

fun solve(list: MutableList<Int>) {
    print(list)
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    var l1 = -1
    var r1 = nums1.size
    var m1 = 0
    var medium = 0.0
    while (l1 < r1 - 1) {
        m1 = (r1 + l1) / 2
        var l2 = -1
        var r2 = nums2.size
        var m2 = 0
        while (l2 < r2 - 1) {
            m2 = (r2 + l2) / 2
            if (nums2[m2] > nums1[m1])
                r2 = m2
            else
                l2 = m2
        }
        if (m1 + m2 == nums1.size + nums2.size) {
            medium = m1.toDouble()
            break
        } else if (m1 + m2 > nums1.size + nums2.size)
            r1 = m1
        else
            l1 = m1
    }
    return medium
}

fun lengthOfLongestSubstring(s: String): Int {
    val charsSet = mutableListOf<Char>()
    var maxLength = 0
    for (c in s) {
        if (c in charsSet) {
            maxLength = max(charsSet.size, maxLength)
            val l = charsSet.indexOf(c)
            for (i in 0..l)
                charsSet.removeAt(i)
            charsSet.add(c)
        } else {
            charsSet.add(c)
        }
        println(charsSet)
    }
    maxLength = max(charsSet.size, maxLength)
    return maxLength
}

fun main() {
    val list = mutableListOf(3, 2, 5)
    val s = mutableMapOf(3 to 1, 4 to 2)
    s[2] = 5
    println(s.contains(4))
    println(s.contains(5))
//    println(listToSegments(list))
//    println(lengthOfLongestSubstring("dvdf"))
//    println(reverse(Node(1, Node(2, Node(3, null))))?.elem)
}
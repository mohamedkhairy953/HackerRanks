package anagram

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'sherlockAndAnagrams' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */

fun sherlockAndAnagrams(s: String): Int {
    val map = mutableMapOf<String, Int>()
    val allSubs = mutableListOf<String>()
    var count = 0
    for (i in 0 .. s.length) {
        for (j in i + 1 .. s.length) {
            val arr = s.substring(i, j).toCharArray()
            val sub = String(arr.sorted().toCharArray())
            if (map.containsKey(sub)) {
                count += map[sub]!!
                map[sub] = map[sub]!! + 1
            } else {
                map[sub] = 1
            }
        }
    }
    return count


}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s = readLine()!!

        val result = sherlockAndAnagrams(s)

        println(result)
    }
}

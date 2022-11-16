package strings_anagram

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
 * Complete the 'makeAnagram' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING a
 *  2. STRING b
 */

fun makeAnagram(a: String, b: String): Int {
    // Write your code here
    val aChars = a.toCharArray().toList().toMutableList()
    val bMap = mutableMapOf<Char, Int>()
    for (c in b.toCharArray()) {
        if (bMap[c] != null) {
            bMap[c] = bMap[c]!! + 1
        } else {
            bMap[c] = 1
        }
    }
    val notDeletedFromA = mutableListOf<Char>()
    for (i in 0 until aChars.size) {
        if (bMap[aChars[i]] != null && bMap[aChars[i]]!! > 0){
            bMap[aChars[i]] =  bMap[aChars[i]]!! - 1
            notDeletedFromA.add(aChars[i])
        }
    }

    return (aChars.size - notDeletedFromA.size) + (bMap.values.sum())
}

fun main(args: Array<String>) {
    val a = readLine()!!

    val b = readLine()!!

    val res = makeAnagram(a, b)

    println(res)
}

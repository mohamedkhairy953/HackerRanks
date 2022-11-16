package tripets

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

// Complete the countTriplets function below.
fun countTriplets(arr: Array<Long>, r: Long): Long {
    val map = mutableMapOf<Int, Long>()
    val map2 = mutableMapOf<Long, MutableList<Int>>()

    val result = mutableListOf<List<Int>>()
    for (i in 0 until arr.size) {
        map[i] = arr[i]
        if (map2[arr[i]] != null) {
            map2[arr[i]]!!.add(i)
        } else {
            map2[arr[i]] = mutableListOf(i)
        }
    }
    map.keys.forEach {
        val tripest = mutableListOf<Int>()
        val firstValue = map[it]!!
        val secValue = firstValue * r
        val thrdValue = secValue * r
        if (map2[secValue]?.firstOrNull() != null && map2[thrdValue]?.firstOrNull() != null) {
            tripest.add(it)
            tripest.add(map[secValue.toInt()]?.toInt()!!)
            tripest.add(map[thrdValue.toInt()]!!.toInt())
            result.add(tripest)
        }
    }
    return result.size.toLong()
}

fun main(args: Array<String>) {
    val nr = readLine()!!.trimEnd().split(" ")

    val n = nr[0].toInt()

    val r = nr[1].toLong()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toLong() }.toTypedArray()

    val ans = countTriplets(arr, r)

    println(ans)
}

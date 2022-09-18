package newyears_chaos

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
 * Complete the 'minimumBribes' function below.
 *
 * The function accepts INTEGER_ARRAY q as parameter.
 */
var swaps = 0
fun minimumBribes(q: Array<Int>): Unit {
    for (i in 0 until q.size) {
        if ((q[i] - (i + 1)) > 2) {
            println("Too chaotic")
            return
        }
    }
   sort(q, 0, q.size-1)
    println(swaps)

}

fun sort(q: Array<Int>, l: Int, r: Int) {
    if (l < r) {
        val m: Int = (l + r) / 2
        sort(q, l, m)
        sort(q, m + 1, r)
        merge(q, l, m, r)
    }
}

fun merge(q: Array<Int>, l: Int, m: Int, r: Int) {
    val nl = m - l + 1
    val nr = r - m
    val lArr = mutableListOf<Int>()
    val rArr = mutableListOf<Int>()
    for (i in 0 until nl)
        lArr.add(q[i + l])
    for (j in 0 until nr)
        rArr.add(q[j + m + 1])

    var i = 0
    var j = 0
    var k = l
    while (i < nl && j < nr) {
        if (lArr[i] <= rArr[j]) {
            q[k] = lArr[i]
            i++
        } else {
            q[k] = rArr[j]
            j++
            swaps++
        }
        k++
    }
    while (i < nl) {
        q[k] = lArr[i]
        i++
        k++
        swaps+=1
    }
    while (j < nr) {
        q[k] = lArr[j]
        j++
        k++
    }

}
fun main(args: Array<String>) {
    minimumBribes(arrayOf(2,1,5,3,4))
}

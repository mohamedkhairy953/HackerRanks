package hourglass

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
 * Complete the 'hourglassSum' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */

fun hourglassSum(arr: Array<Array<Int>>): Int {
    // Write your code here
    val firstHG = arr[0][0] + arr[0][1] + arr[0][2] + arr[1][1] + arr[2][0] + arr[2][1] + arr[2][2]
    val secdHG = arr[0][1] + arr[0][2] + arr[0][3] + arr[1][2] + arr[2][1] + arr[2][2] + arr[2][3]
    val hg3 = arr[0][2] + arr[0][3] + arr[0][4] + arr[1][3] + arr[2][2] + arr[2][3] + arr[2][4]
    val hg4 = arr[0][3] + arr[0][4] + arr[0][5] + arr[1][4] + arr[2][3] + arr[2][4] + arr[2][5]

    val hg5 = arr[1][0] + arr[1][1] + arr[1][2] + arr[2][1] + arr[3][0] + arr[3][1] + arr[3][2]
    val hg6 = arr[1][1] + arr[1][2] + arr[1][3] + arr[2][2] + arr[3][1] + arr[3][2] + arr[3][3]
    val hg7 = arr[1][2] + arr[1][3] + arr[1][4] + arr[2][3] + arr[3][2] + arr[3][3] + arr[3][4]
    val hg8 = arr[1][3] + arr[1][4] + arr[1][5] + arr[2][4] + arr[3][3] + arr[3][4] + arr[3][5]

    var max = Int.MIN_VALUE
    for (i in 0..3) {
        for (j in 0..3) {
            val hg = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]+arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]

            println(firstHG)
            if (max < hg)
                max = hg
        }
    }

    return max

}

fun main(args: Array<String>) {

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}

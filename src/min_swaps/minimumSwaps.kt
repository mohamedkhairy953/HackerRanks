package min_swaps

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

// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {
    var swaps = 0
    var map = mutableMapOf<Int,Int>()
    
    for(i in 0 until arr.size)
        map[arr[i]] = i
     
    for(i in 0 until arr.size){
        if(arr[i] != i+1){
            map[i+1]?.let {
                map[arr[i]] = it
                map[arr[it]] = i
                val temp=arr[i]
                arr[i] = arr[it]
                arr[it] = temp

                ++swaps   
             }
          
        }
    }
     return swaps
}
fun main(args: Array<String>) {

    val res = minimumSwaps(arrayOf(4,3,1,2))

    println(res)
}

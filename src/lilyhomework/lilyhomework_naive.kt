import java.util.*
import java.util.Collections.swap
import kotlin.math.min

fun main() {
    print(lilysHomeworkNaive(arrayOf(66, 6, 3, 2, 5, 33, 22, 12, 10, 0)))

    //Algorithm works in O(n^2)
}

fun lilysHomeworkNaive(arr: Array<Int>): Int {
    var numberOfSwaps = 0
    val arrCopied = arr.copyOf()
    val sArr = arr.sortedArray()
    for (i in arr.indices) {
        if (sArr[i] != arr[i]) {
            val indexToSwapWith = arr.indexOf(sArr[i])
            val currentValueToSwap = arr[i]
            arr[i]=sArr[i]
            arr[indexToSwapWith]=currentValueToSwap
            numberOfSwaps++
        }

    }
    //Reversed
    var numberOfSwaps2 = 0
    val sArr2 = arrCopied.sortedArrayDescending()
    for (i in arrCopied.indices) {
        if (sArr2[i] != arrCopied[i]){
            val indexToSwapWith = arrCopied.indexOf(sArr[i])
            val currentValueToSwap = arrCopied[i]
            arrCopied[i]=sArr[i]
            arrCopied[indexToSwapWith]=currentValueToSwap
            numberOfSwaps2++

        }

    }

    return min(numberOfSwaps, numberOfSwaps2)
}

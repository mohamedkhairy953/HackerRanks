import kotlin.math.min

fun main() {
    print(lilysHomework(arrayOf(66,6,3,2,5,33,22,12,10,0)))
}
fun lilysHomework(arr: Array<Int>): Int {
    // Write your code here
    var numberOfSwaps = 0
    val originalMap = mutableMapOf<Int, Int>()
    val arrCopied = Array<Int>(size = arr.size,init={0})
    for (i in arr.indices) {
        originalMap[arr[i]] = i
        arrCopied[i]=arr[i]
    }
    val sArr = arr.sortedArray()
    for (i in arr.indices) {
        if (sArr[i] != arr[i]) {
            val temp = arr[i]
            arr[i] = arr[originalMap[sArr[i]]!!]
            arr[originalMap[sArr[i]]!!]=temp
            originalMap[temp]=originalMap[sArr[i]]!!
            numberOfSwaps++
        }
    }
    ////
    var numberOfSwaps2 = 0
    val originalMap2 = mutableMapOf<Int, Int>()
    for (i in arrCopied.indices) {
        originalMap2[arrCopied[i]] = i
    }
    val sArr2 = arrCopied.sortedArrayDescending()
    for (i in arrCopied.indices) {
        if (sArr2[i] != arrCopied[i]) {
            val temp = arrCopied[i]
            arrCopied[i] = arrCopied[originalMap2[sArr2[i]]!!]
            arrCopied[originalMap2[sArr2[i]]!!] = temp
            originalMap2[temp] = originalMap2[sArr2[i]]!!
            numberOfSwaps2++
        }
    }

    return min(numberOfSwaps, numberOfSwaps2)
}

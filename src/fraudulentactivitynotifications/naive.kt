import java.util.*
import kotlin.math.ceil

fun main() {
    print(activityNotifications(arrayOf(10, 20, 30, 40, 50), 3))
}

fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    var counter = 0
    val numberOfLoops = expenditure.size - d
    var slicedArray: MutableList<Int> = mutableListOf()
    val lowersH: PriorityQueue<Double> = PriorityQueue { first, second -> ceil(second - first).toInt() }
    val highersH: PriorityQueue<Double> = PriorityQueue()
    for (i in 0 until numberOfLoops) {
        var removedNumber = 0
        if (slicedArray.isEmpty())
            slicedArray = expenditure.slice(IntRange(i, i + d - 1)).toMutableList()
        else {
            removedNumber = slicedArray.removeAt(0)
            slicedArray.add(expenditure[i + d - 1])
        }
        val med = medianMaintenanceByHeaps(slicedArray, lowersH, highersH, removedNumber)

        if (expenditure[i + d] >= med * 2)
            counter++

    }
    return counter
}

fun medianMaintenanceByHeaps(
    numbers: MutableList<Int>,
    lowersH: PriorityQueue<Double>,
    highersH: PriorityQueue<Double>,
    numberToDelete: Int
): Double {
    if (lowersH.isEmpty() && highersH.isEmpty())
        numbers.forEach {
            addNumberToHeap(it, lowersH, highersH)
            balanceHeaps(lowersH, highersH)
        }
    else {
        removeNumberFromHeap(numberToDelete, lowersH, highersH)
        addNumberToHeap(numbers.last(), lowersH, highersH)

    }

    return computeMedian(lowersH, highersH)
}

fun computeMedian(lowersH: PriorityQueue<Double>, highersH: PriorityQueue<Double>): Double {
    val biggerHeap = if (lowersH.size > highersH.size) lowersH else highersH
    return if (lowersH.size == highersH.size) {
        (lowersH.peek() + highersH.peek()) / 2
    } else {
        biggerHeap.peek()
    }
}

fun balanceHeaps(lowersH: PriorityQueue<Double>, highersH: PriorityQueue<Double>) {
    val biggerHeap = if (lowersH.size > highersH.size) lowersH else highersH
    val smallerHeap = if (lowersH.size < highersH.size) lowersH else highersH
    if (biggerHeap.size > (smallerHeap.size + 1)) {
        lowersH.add(biggerHeap.poll())
    }
}

fun addNumberToHeap(it: Int, lowersH: PriorityQueue<Double>, highersH: PriorityQueue<Double>) {
    if (lowersH.isEmpty() || it < lowersH.peek())
        lowersH.add(it.toDouble())
    else
        highersH.add(it.toDouble())
}

fun removeNumberFromHeap(it: Int, lowersH: PriorityQueue<Double>, highersH: PriorityQueue<Double>) {
    if (lowersH.isEmpty() || it <= lowersH.peek())
        lowersH.remove(it.toDouble())
    else
        highersH.remove(it.toDouble())

    balanceHeaps(lowersH,highersH)
}
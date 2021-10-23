package fraudulentactivitynotifications

import java.util.*
import kotlin.math.ceil
import kotlin.math.exp
import kotlin.math.floor

fun main() {
    print(activityNotifications(arrayOf(1, 2, 3, 4,4), 4))
}

fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    val countingSortList = Array(size = 201) { 0 }
    var end = d
    for (i in 0 until end)
        countingSortList[expenditure[i]]++

    var current = 0
    var totalNotifications = 0

    val medPosition = if (d % 2 == 0) {
        d / 2
    } else {
        d / 2 + 1
    }
    val totalExpenditureLength = expenditure.size
    while (end < totalExpenditureLength) {
        val med = getMed(countingSortList, d, medPosition)
        if (expenditure[end] >= med * 2)
            totalNotifications++

        countingSortList[expenditure[current]]--
        countingSortList[expenditure[end]]++
        current++
        end++
    }

    return totalNotifications
}

fun getMed(arr: Array<Int>, d: Int, medLeftPosition: Int): Double {
    var counter = 0
    var left = 0
    while (counter < medLeftPosition) {
        counter += arr[left]
        left += 1
    }
    var right = left
    left -= 1

    if (counter > medLeftPosition || d % 2 != 0) {
        return left.toDouble()
    } else {
        while (arr[right] == 0)
            right++
        return (left + right).div(2.0)

    }

}

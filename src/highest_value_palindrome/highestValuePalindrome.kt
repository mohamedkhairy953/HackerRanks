package highest_value_palindrome

import java.util.*

fun main() {
    val `in` = Scanner(System.`in`)
    val n: Int = `in`.nextInt()
    val k: Int = `in`.nextInt()
    val number: String = `in`.next()
    print(highestValuePalindrome(number, n, k))
}

fun highestValuePalindrome(s: String, n: Int, k: Int): String {
    val leftString: CharArray
    val rightString: CharArray
    var medChar: Char? = null

    if (n % 2 == 0) {
        leftString = s.substring(0, n / 2).toCharArray()
        rightString = s.substring(n / 2, n).toCharArray()
    } else {
        medChar = s[n / 2]
        leftString = s.substring(0, n / 2).toCharArray()
        rightString = s.substring(n / 2 + 1, n).toCharArray()
    }
    if (k == 0) {
        return if (!leftString.contentEquals(rightString.reversedArray())) "-1"
        else
            s
    }
    val ss = doReplacement(k, leftString, rightString, medChar)

    return if (!leftString.contentEquals(rightString.reversedArray())) "-1"
    else
        return ss

}

private fun doReplacement(k: Int, leftString: CharArray, rightString: CharArray, medChar: Char?): String {
    var m = medChar
    if (k == 0) return "${String(leftString)}${m ?: ""}${String(rightString)}"

    var numberOfReplacements = k
    if (!leftString.contentEquals(rightString.reversedArray()))
        numberOfReplacements = updateLeftAndRight(numberOfReplacements, leftString, rightString)

    if (numberOfReplacements % 2 == 0) {
        doDoubleReplacements(numberOfReplacements, leftString, rightString)
    } else {
        val c = numberOfReplacements - 1
        doDoubleReplacements(c, leftString, rightString)
        if (medChar != null && Character.getNumericValue(medChar) < 9) {
            m = '9'
        }
    }
    return "${String(leftString)}${m ?: ""}${String(rightString)}"
}

fun doDoubleReplacements(k: Int, leftString: CharArray, rightString: CharArray) {
    var c1 = k
    while (c1 > 0) {
        for (i in leftString.indices) {
            if (c1 == 0) break
            if (leftString[i] != '9' && c1 > 1) {
                leftString[i] = '9'
                c1--
                if (rightString[rightString.lastIndex - i] != '9' && c1 > 1) {
                    rightString[rightString.lastIndex - i] = '9'
                    c1--
                }
               
            }
        }
    }
}

private fun updateLeftAndRight(c: Int, leftString: CharArray, rightString: CharArray): Int {
    if (c == 0) return c
    var c1 = c
    for (i in leftString.indices) {
        if (leftString[i] != rightString[rightString.lastIndex - i] && c1 > 0) {
            if (leftString[i] > rightString[rightString.lastIndex - i]) {
                if (leftString[i] != '9' && c1 > 1) {
                    rightString[rightString.lastIndex - i] = '9'
                    leftString[i] = '9'
                    c1 -= 2
                } else {
                    rightString[rightString.lastIndex - i] = leftString[i]
                    c1--
                }

            } else {
                if (rightString[rightString.lastIndex - i] != '9' && c1 > 1) {
                    rightString[rightString.lastIndex - i] = '9'
                    leftString[i] = '9'
                    c1 -= 2
                } else {
                    leftString[i] = rightString[rightString.lastIndex - i]
                    c1--
                }

            }
        }
    }
    return c1
}

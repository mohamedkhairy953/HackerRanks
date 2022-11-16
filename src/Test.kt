fun main() {

}

data class Node(
        var next: Node?,
        val value: Int,
)

fun addTwoLinkedLists(linked1: Node, linked2: Node): Node? {
    var result: Node? = null
    var sum1 = ""
    var sum2 = ""
    while (linked1.next != null) {
        sum1 += linked1.value
    }
    while (linked2.next != null) {
        sum2 += linked2.value
    }

    val sumResult = sum1.toInt() + sum2.toInt()
    

    sumResult.toString().toCharArray().map { it.toInt() }.forEach {
        val node = Node(value = it, next = null)

        while (true) {
            if (result == null) {
                result = node
                break
            }
            if (result?.next == null) {
                result?.next = node
                break
            }
        }

    }
    return result
}
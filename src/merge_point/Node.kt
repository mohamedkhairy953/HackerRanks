package merge_point

import java.io.*
import java.util.*

data class Node(
        val data: Int,
        val next: Node?
)

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val llistCount = scan.nextLine().trim().toInt()
    val llist = Node()

    for (i in 0 until llistCount) {
        val llist_item = scan.nextLine().trim().toInt()
        llist.insertNode(llist_item)
    }

    val data = scan.nextLine().trim().toInt()

    val position = scan.nextLine().trim().toInt()

    val llist_head = mergePoint(llist?.head, data, position)

}


fun mergePoint(h1: Node, h2: Node): Int {

    var c1: Node? = h1

    while (c1 != null) {
        var c2: Node? = h2
        while (c2 != null) {
            if (c1?.data == c2.data)
                return c1?.data ?: -1
            else
                c2 = c2?.next
        }
        c1 = c1?.next

    }
    return -1

}


fun detectCycle(h1: Node): Int {
    val map = mutableMapOf<Node, Int>()

    var c: Node? = h1
    while (c != null) {
        if (map[c] != null)
            return 1
        map[c] = 1
        c = c.next
    }
    return 0
}

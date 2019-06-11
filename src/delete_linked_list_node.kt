// https://www.interviewcake.com/question/java/delete-node

class LinkedListNode(var value: Int?, var next: LinkedListNode?) {}

fun deleteNode(node: LinkedListNode) {
    node.value = node.next?.value
    node.next = node.next?.next
}

fun main(args: Array<String>) {
    val c = LinkedListNode(3, null)
    val b = LinkedListNode(2, c)
    val a = LinkedListNode(1, b)

    deleteNode(b)
    assert(a.value == 1)
    assert(a.next?.value == 3)
    assert(a.next?.next == null)
}
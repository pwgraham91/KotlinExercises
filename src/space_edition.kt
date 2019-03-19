fun findDuplicateWithSpace(numbers: Array<Int>): Int? {
    val seenInts = mutableSetOf<Int>()

    for (num: Int in numbers) {
        if (seenInts.contains(num)) {
            return num
        }
        seenInts.add(num)
    }
    return null
}

fun main(args: Array<String>) {
    assert(findDuplicateWithSpace(arrayOf(1, 2, 3, 3)) == 3)
    assert(findDuplicateWithSpace(arrayOf(1, 2, 3)) === null)
}

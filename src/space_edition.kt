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

fun findDuplicateNoAddedSpace(numbers: Array<Int>): Int? {
    numbers.sort()
    for (i in 0 until numbers.size - 1) {
        if (numbers[i] == numbers[i + 1]) {
            return numbers[i]
        }
    }

    return null
}

fun main(args: Array<String>) {
    assert(findDuplicateWithSpace(arrayOf(1, 2, 3, 3)) == 3)
    assert(findDuplicateWithSpace(arrayOf(1, 2, 3)) == null)

    assert(findDuplicateNoAddedSpace(arrayOf(1, 2, 3, 3)) == 3)
    assert(findDuplicateNoAddedSpace(arrayOf(1, 2, 3)) == null)
}

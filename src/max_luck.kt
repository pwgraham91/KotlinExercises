// https://www.hackerrank.com/challenges/luck-balance/problem
data class Contest(val luckScore: Int, val isImportant: Boolean)

fun maxLuck(contests: List<Contest>, canLose: Int): Int {
    val sortedContests = contests.sortedWith(compareBy({ !it.isImportant }, { it.luckScore })).asReversed()

    var losses = 0
    var totalLuck = 0
    for (contest in sortedContests) {
        if (!contest.isImportant) {
            totalLuck += contest.luckScore
        } else {
            if (losses < canLose) {
                totalLuck += contest.luckScore
                losses++
            } else {
                totalLuck -= contest.luckScore
            }
        }
    }
    return totalLuck
}

fun main(args: Array<String>) {
    val maxLuckResult = maxLuck(
        listOf(
            Contest(5, true),
            Contest(2, true),
            Contest(1, true),
            Contest(8, true),
            Contest(10, false),
            Contest(5, false)
        ), 3
    )
    println(maxLuckResult)
    assert(
        maxLuckResult == 29
    )

    val maxLuckResult2 = maxLuck(
        listOf(
            Contest(13, true),
            Contest(10, true),
            Contest(9, true),
            Contest(8, true),
            Contest(13, true),
            Contest(12, true),
            Contest(18, true),
            Contest(13, true)
        ), 5
    )
    println(maxLuckResult2)
    assert(
        maxLuckResult2 == 42
    )
}
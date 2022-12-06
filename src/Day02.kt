fun main() {
    fun part1(input: List<String>): Int {
        val opponentScoreMap = mapOf("A" to 1, "B" to 2, "C" to 3)
        val playerScoreMap = mapOf("X" to 1, "Y" to 2, "Z" to 3)

        var score = 0

        for (line in input) {
            val opponent = line.split(" ")[0]
            val player = line.split(" ")[1]

            score += playerScoreMap[player] ?: 0

            if (playerScoreMap[player] == opponentScoreMap[opponent]) {
                score += 3
                continue
            }

            if (player == "X" && opponent == "C" || (!(player == "Z" && opponent == "A") && (playerScoreMap[player]
                    ?: 0) > (opponentScoreMap[opponent] ?: 0))
            ) score += 6

        }

        return score
    }

    fun part2(input: List<String>): Int {
        val opponentScoreMap = mapOf("A" to 1, "B" to 2, "C" to 3)
        val calcLosePoints = { i: Int -> if (i == 1) 3 else i - 1 }
        val calcWinPoints = { i: Int -> if (i == 3) 1 else i + 1 }
        var score = 0

        for (line in input) {
            val opponent = line.split(" ")[0]

            when (line.split(" ")[1]) {
                "X" -> score += calcLosePoints(opponentScoreMap[opponent]!!)
                "Y" -> score += 3 + opponentScoreMap[opponent]!!
                "Z" -> score += 6 + calcWinPoints(opponentScoreMap[opponent]!!)
            }
        }

        return score
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

fun getPriority(ch: Char): Int {
    return if (ch.code in 97..122) ch.code - 96 else ch.code - 38
}

fun main() {
    fun part1(input: List<String>): Int {
        var total = 0

        for (line in input) {
            val sec1 = line.substring(0 until line.length / 2)
            val sec2 = line.substringAfter(sec1)
            var matches = mutableListOf<Char>()

            for (ch in sec1) {
                if (!matches.contains(ch) && sec2.contains(ch)) matches.add(ch)
            }

            for (match in matches) total += getPriority(match)
        }

        return total
    }

    fun part2(input: List<String>): Int {
        var total = 0
        var groups = mutableListOf<List<String>>()

        for (i in 0 until input.size step 3) groups.add(input.subList(i, i + 3))

        for (group in groups) {
            var matches = mutableListOf<Char>()
            for (item in group[0]) {
                if (!matches.contains(item) && group[1].contains(item) && group[2].contains(item)) {
                    matches.add(item)
                }
            }

            for (match in matches) total += getPriority(match)
        }

        return total
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

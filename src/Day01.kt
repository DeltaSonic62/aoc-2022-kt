fun getCarriedCals(input: List<String>): List<Int> {
    val carriedCals: MutableList<Int> = mutableListOf()
    var total = 0

    for (str in input) {
        if (str.isEmpty() || str.isBlank()) {
            carriedCals.add(total)
            total = 0
            continue
        }

        total += str.toInt()
    }
    carriedCals.add(total)

    return carriedCals
}

fun main() {
    fun part1(input: List<String>): Int {
        val carriedCals = getCarriedCals(input)
        var max = carriedCals[0]

        for (cal in carriedCals) {
            if (cal > max) {
                max = cal
            }
        }

        return max
    }

    fun part2(input: List<String>): Int {
        val carriedCals = getCarriedCals(input).sortedDescending()

        return carriedCals.slice(0..2).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

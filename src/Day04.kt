fun main() {
    fun part1(input: List<String>): Int {
        var count = 0
        for (pair in input) {
            val first = pair.split(',')[0].split('-');
            val second = pair.split(',')[1].split('-');

            if ((first[0].toInt() <= second[0].toInt() && first[1].toInt() >= second[1].toInt()) || (second[0].toInt() <= first[0].toInt() && second[1].toInt() >= first[1].toInt())) {
                count++
            }
        }

        return count
    }

    fun part2(input: List<String>): Int {
        var count = 0
        for (pair in input) {
            val first = pair.split(',')[0].split('-');
            val second = pair.split(',')[1].split('-');

            for (i in first[0].toInt()..first[1].toInt()) {
                if (i >= second[0].toInt() && i <= second[1].toInt()) {
                    count++;
                    break;
                }
            }
        }

        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}

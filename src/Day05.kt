fun getData(input: List<String>): Pair<MutableList<MutableList<String>>, MutableList<List<Int>>> {
    val crates = mutableListOf<MutableList<String>>(mutableListOf())
    val instructions = mutableListOf<List<Int>>()
    var isCratesDone = false;

    for (line in input) {
        if (line.isBlank()) continue

        if (line[1] == '1') {
            isCratesDone = true
            continue
        }

        if (isCratesDone) {
            val inst1 = line.split("move")[1].split("from")[0].trim().toInt();
            val inst2 = line.split("move")[1].split("from")[1].split("to")[0].trim().toInt();
            val inst3 = line.split("move")[1].split("from")[1].split("to")[1].trim().toInt();
            instructions.add(listOf(inst1, inst2, inst3));
            continue
        }

        while (crates.size <= getColCount(input) - 1) {
            crates += mutableListOf<String>()
        }

        for ((index, i) in (line.indices step 4).withIndex()) {
            if (line.substring(i..i + 2).isNotBlank()) {
                crates[index].add(line.substring(i..i + 2))
            }
        }
    }

    return Pair(crates, instructions)
}

fun getColCount(input: List<String>): Int {
    for (line in input) {
        if (line[1] == '1') return line.trim().last().toString().toInt()
    }

    return 0
}

fun getTops(crates: List<List<String>>): String {
    var res = ""
    for (col in crates) {
        if (col.isNotEmpty()) res += col[0][1]
    }

    return res
}

fun main() {
    fun part1(input: List<String>): String {
        val (crates, instructions) = getData(input)

        for (ins in instructions) {
            for (i in 0 until ins[0]) {
                val temp = crates[ins[1] - 1].first()
                crates[ins[1] - 1].removeAt(0)
                crates[ins[2] - 1].add(0, temp)
            }
        }

        return getTops(crates);
    }

    fun part2(input: List<String>): String {
        val (crates, instructions) = getData(input)

        for (ins in instructions) {
            for (i in ins[0] - 1 downTo 0) {
                val temp = crates[ins[1] - 1][i]
                crates[ins[1] - 1].removeAt(i)
                crates[ins[2] - 1].add(0, temp)
            }
        }

        return getTops(crates)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}

import java.io.File

fun main() {
    val input = File("src/main/kotlin/inputs/day2.txt")

    println("Score is ${getPart1Score(input)}")
    println("Part 2 score is ${getPart2Score(input)}")
}

fun getPart1Score(input: File): Int {
    var total = 0
    var curr = 0

    input.forEachLine { line ->
        val opp = line[0]
        val you = line[2]

        // part 1: score from selection
        when(you) {
            'X' -> curr = 1
            'Y' -> curr = 2
            'Z' -> curr = 3
        }

        // part 2: score from comparison
        when (opp) {
            'A' -> curr += if (you == 'Y') 6 else if (you == 'X') 3 else 0
            'B' -> curr += if (you == 'Z') 6 else if (you == 'Y') 3 else 0
            'C' -> curr += if (you == 'X') 6 else if (you == 'Z') 3 else 0
        }

        total += curr
        curr = 0
    }

    return total
}

fun getPart2Score(input: File): Int {
    var total = 0
    var curr = 0

    input.forEachLine { line ->
        val opp = line[0]
        val you = line[2]

        when (opp) {
            'A' -> {
                curr = when (you) {
                    'X' -> 3 // rock beats scissors
                    'Y' -> 4 // rock ties with rock
                    'Z' -> 8 // rock loses to paper
                    else -> 0
                }
            }
            'B' -> {
                curr = when (you) {
                    'X' -> 1 // paper beats rock
                    'Y' -> 5 // paper ties with paper
                    'Z' -> 9 // paper loses to scissors
                    else -> 0
                }
            }
            'C' -> {
                curr = when (you) {
                    'X' -> 2 // scissors beats paper
                    'Y' -> 6 // scissors ties scissors
                    'Z' -> 7 // scissors loses to rock
                    else -> 0
                }
            }
        }
        total += curr
        curr = 0
    }
    return total
}
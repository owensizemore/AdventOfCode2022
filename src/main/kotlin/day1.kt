import java.io.File

fun main() {
    val input = File("src/main/kotlin/inputs/day1.txt")

    val max = getMaxCalories(input)
    println("Max number of calories is $max")

    val topThree = getTopThree(input)
    println("Sum of top three is $topThree")
}

fun getMaxCalories(input: File): Int {
    var curr = 0
    var max = 0

    input.forEachLine { line ->
        if (line.trim() == "") {
            if (curr > max) {
                max = curr
            }
            curr = 0
        } else {
            curr += line.toInt()
        }
    }

    return max
}

fun getTopThree(input: File): Int {
    val topThree = IntArray(3)
    var curr = 0

    input.forEachLine { line ->
        if (line.trim() == "") {
            if (curr > topThree[0]) {
                topThree[0] = curr
            } else if (curr > topThree[1]) {
                topThree[1] = curr
            } else if (curr > topThree[2]) {
                topThree[2] = curr
            }
            curr = 0
        } else {
            curr += line.toInt()
        }
    }

    return topThree[0] + topThree[1] + topThree[2]
}



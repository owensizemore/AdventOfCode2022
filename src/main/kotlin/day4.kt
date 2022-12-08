import java.io.File

fun main() {
    val input = File("src/main/kotlin/inputs/day4.txt")

    getContainedAndOverlappingPairs(input)
}

fun getContainedAndOverlappingPairs(input: File) {
    var numContainedPairs = 0
    var numOverlappingPairs = 0

    input.forEachLine { line ->
        val pairs: List<List<Int>> = getPairsFromLine(line)

        val aFirst = pairs[0][0]
        val aLast = pairs[0][1]
        val bFirst = pairs[1][0]
        val bLast = pairs[1][1]
        if ((aFirst <= bFirst && aLast >= bLast) || (bFirst <= aFirst && bLast >= aLast)) {
            numContainedPairs++
        }
        if (aFirst in bFirst..bLast || bLast in aFirst..aLast || bFirst in aFirst..aLast) {
            numOverlappingPairs++
        }
    }

    println("Num contained pairs is $numContainedPairs")
    println("Num overlapping pairs is $numOverlappingPairs")
}

fun getPairsFromLine(line: String): List<List<Int>> {
    val pairs = mutableListOf<List<Int>>()

    val splitString = line.split(",")
    pairs.add(getPair(splitString[0]))
    pairs.add(getPair(splitString[1]))

    return pairs
}

fun getPair(pairString: String): List<Int> = pairString.split("-").map { it.toInt() }

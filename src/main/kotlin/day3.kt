import java.io.File

fun main() {
    val input = File("src/main/kotlin/inputs/day3.txt")

    println("Part 1 sum of priorities is ${part1(input)}")
    println("Part 2 sum of priorities is ${part2(input)}")

}

fun part1(input: File): Int {
    var sumOfPriorities = 0

    input.forEachLine { line ->
        val split = line.length/2
        val items = HashSet<Char>()

        val first = line.substring(0, split).toCharArray()
        val second = line.substring(split).toCharArray()

        // get list of items found in both compartments
        first.forEach { c1 ->
            second.forEach { c2 ->
                if (c1 == c2) {
                    items.add(c1)
                }
            }
        }

        // get priorities for items
        items.forEach { item ->
            val itemCode = item.code
            sumOfPriorities += if (item.isLowerCase()) {
                (itemCode - 96)
            } else {
                (itemCode - 38)
            }
        }
    }

    return sumOfPriorities
}

fun part2(input: File): Int {
    var sum = 0
    var group = mutableListOf<String>()
    val items = mutableListOf<Char>()
    var itemFound = false

    input.forEachLine { line ->
        group.add(line)
        if (group.size == 3) {
            group[0].forEach { c1 ->
                group[1].forEach { c2 ->
                    if (c1 == c2) {
                        if (group[2].contains(c1) && !itemFound) {
                            items.add(c1)
                            itemFound = true
                        }
                    }
                }
            }
            itemFound = false
            group.clear()
        }
    }

    // get priorities for items
    items.forEach { item ->
        val itemCode = item.code
        sum += if (item.isLowerCase()) {
            (itemCode - 96)
        } else {
            (itemCode - 38)
        }
    }

    return sum
}


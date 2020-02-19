// Problem description: https://adventofcode.com/2019/day/2

package day2

import java.io.File

fun main(args: Array<String>) {
    //    PART 1
    val programPart1 = File("src/day2/input.txt").readText().split(",").map { it.toInt() }.toMutableList()
    programPart1[1] = 12
    programPart1[2] = 2
    val resultPart1 = IntcodeComputer.process(programPart1)[0]
    println("Part 1 result: $resultPart1")

    //    PART 2
    val programPart2 = File("src/day2/input.txt").readText().split(",").map { it.toInt() }.toMutableList()
    val nounAndVerb = IntcodeComputer.determineInputPair(programPart2, 19690720)
    val resultPart2 = 100 * nounAndVerb[0] + nounAndVerb[1]
    println("Part 2 result: $resultPart2")
}
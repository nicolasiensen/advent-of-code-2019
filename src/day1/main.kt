// Problem description: https://adventofcode.com/2019/day/1

package day1

import java.io.File

fun main(args: Array<String>) {
    val masses = File("src/day1/input.txt").readLines().map { it.toInt() }
    val fuel = FuelCalculator.calculate(masses)
    println("Required fuel: $fuel")
}
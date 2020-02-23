package day3

import java.io.File

fun main(args: Array<String>) {
    val wires = File("src/day3/input.txt").readLines().map { instructions ->
        val wireVectors = instructions.split(",").map { instruction -> WireVector(instruction) }
        Wire(wireVectors)
    }

    val centralPort = CentralPort(wires)
    println("The closest intersection is at ${centralPort.findManhattanDistanceToClosestIntersection()} Manhattan distance from the central port")
}
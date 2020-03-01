package day3

import java.io.File

fun main(args: Array<String>) {
    val wires = File("src/day3/input.txt").readLines().map { instructions ->
        val wireVectors = instructions.split(",").map { instruction -> WireVector(instruction) }
        Wire(wireVectors)
    }

    val centralPort = CentralPort(wires[0], wires[1])

    //    PART 1
    println("The closest intersection is at ${centralPort.findManhattanDistanceToClosestIntersection()} Manhattan distance from the central port")

    //    PART 2
    println("The sum of the wires' steps to the first intersection is ${centralPort.sumWiresDistanceToFirstIntersection()}")
}
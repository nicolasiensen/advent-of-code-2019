package day3

import java.awt.Point
import java.lang.Exception
import kotlin.math.abs

class CentralPort(private val wire1: Wire, private val wire2: Wire) {
    class NoIntersectionException(
        message: String = "There is no intersection between the wires of this central port"
    ) : Exception(message)

    private val intersections = wire1.findIntersections(wire2)

    fun findManhattanDistanceToClosestIntersection() : Int {
        return if (intersections.isNotEmpty()) {
            intersections.map { abs(it.x) + abs(it.y) }.min()!!
        } else throw NoIntersectionException()
    }

    fun sumWiresDistanceToFirstIntersection() : Int {
        return if (intersections.isNotEmpty()) {
            wire1.getDistanceToPoint(intersections.first()) + wire2.getDistanceToPoint(intersections.first())
        } else throw NoIntersectionException()
    }
}

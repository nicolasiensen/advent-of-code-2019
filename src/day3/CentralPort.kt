package day3

import java.awt.Point
import java.lang.Exception
import kotlin.math.abs

class CentralPort(private val wires: List<Wire>) {
    class NoIntersectionException(message: String) : Exception(message)

    fun findManhattanDistanceToClosestIntersection() : Int {
        val intersections = mutableListOf<Point>()
        var i = 0

        while(i < wires.size) {
            var j = i + 1
            while (j < wires.size) {
                intersections.addAll(wires[i].findIntersections(wires[j]))
                j++
            }
            i++
        }

        return if (intersections.isNotEmpty()) {
            intersections.map { abs(it.x) + abs(it.y) }.min()!!
        } else throw NoIntersectionException("There is no intersection between the wires of this central port")
    }
}

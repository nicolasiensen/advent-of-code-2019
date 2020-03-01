package day3

import java.awt.Point
import java.lang.Exception

class Wire(wireVectors: List<WireVector>) {
    class WireNeverCrossesThePointException(message: String) : Exception(message)

    private val points = mutableListOf<Point>()

    init {
        var currentPoint = Point(0, 0)
        wireVectors.forEach {
            points.addAll(it.getPoints(currentPoint))
            currentPoint = points.last()
        }
    }

    fun findIntersections(wire: Wire) : List<Point> {
        return points.filter { wire.points.contains(it) }
    }

    fun getDistanceToPoint(point: Point) : Int {
        val distance = points.indexOf(point) + 1

        if (distance > 0) {
            return distance
        } else {
            throw WireNeverCrossesThePointException("The wire never crosses the point [${point.x}, ${point.y}]")
        }
    }
}
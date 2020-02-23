package day3

import java.awt.Point

class Wire(wireVectors: List<WireVector>) {
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
}
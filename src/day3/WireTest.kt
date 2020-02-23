package day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.awt.Point

internal class WireTest {
    @Test
    fun findIntersectionsWhenThereIsNone() {
        val wire1 = Wire(listOf())
        val wire2 = Wire(listOf())

        assertEquals(listOf<Point>(), wire1.findIntersections(wire2))
    }

    @Test
    fun findIntersectionsWhenThereIsOne() {
        val wire1Steps = listOf(WireVector("U1"))
        val wire1 = Wire(wire1Steps)
        val wire2Steps = listOf(WireVector("U1"))
        val wire2 = Wire(wire2Steps)

        assertEquals(listOf(Point(0,1)), wire1.findIntersections(wire2))
    }

    @Test
    fun findIntersectionsWhenThereAreMany() {
        val wire1Steps = listOf(WireVector("U3"))
        val wire1 = Wire(wire1Steps)

        val wire2Steps = listOf(WireVector("U3"))
        val wire2 = Wire(wire2Steps)

        assertEquals(
            listOf(
                Point(0,1),
                Point(0,2),
                Point(0,3)
            ),
            wire1.findIntersections(wire2)
        )
    }
}
package day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.awt.Point
import kotlin.test.assertFailsWith

internal class WireVectorTest{
    @Test
    fun whenDirectionIsInvalid() {
        assertFailsWith<WireVector.InvalidDirectionException> { WireVector("Z1") }
    }

    @Test
    fun whenMagnitudeIsNotANumber() {
        assertFailsWith<java.lang.NumberFormatException> { WireVector("ZS") }
    }

    @Test
    fun getPointsWhenDirectionIsUp() {
        val wireStep = WireVector("U1")
        assertEquals(listOf(Point(0, 1)), wireStep.getPoints(Point(0, 0)))
    }

    @Test
    fun getPointsWhenDirectionIsRight() {
        val wireStep = WireVector("R1")
        assertEquals(listOf(Point(1, 0)), wireStep.getPoints(Point(0, 0)))
    }

    @Test
    fun getPointsWhenDirectionIsDown() {
        val wireStep = WireVector("D1")
        assertEquals(listOf(Point(0, -1)), wireStep.getPoints(Point(0, 0)))
    }

    @Test
    fun getPointsWhenDirectionIsLeft() {
        val wireStep = WireVector("L1")
        assertEquals(listOf(Point(-1, 0)), wireStep.getPoints(Point(0, 0)))
    }

    @Test
    fun getPointsWhenMagnitudeIsMoreThanOne() {
        val wireStep = WireVector("L3")
        assertEquals(
            listOf(
                Point(-1, 0),
                Point(-2, 0),
                Point(-3, 0)
            ),
            wireStep.getPoints(Point(0, 0))
        )
    }

    @Test
    fun getPointsWhenMagnitudeIsZero() {
        val wireStep = WireVector("L0")
        assertEquals(listOf<Point>(), wireStep.getPoints(Point(0, 0)))
    }
}
package day3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

internal class CentralPortTest {
    @Test
    fun findManhattanDistanceToClosestIntersectionWhenThereAreNoWires() {
        val centralPort = CentralPort(listOf())
        assertFailsWith<CentralPort.NoIntersectionException> { centralPort.findManhattanDistanceToClosestIntersection() }
    }

    @Test
    fun findManhattanDistanceToClosestIntersectionWhenThereAreTwoWiresThatIntersectOnce() {
        val wire1Steps = listOf(WireVector("U1"), WireVector("R1"))
        val wire1 = Wire(wire1Steps)

        val wire2Steps = listOf(WireVector("R1"), WireVector("U1"))
        val wire2 = Wire(wire2Steps)

        val centralPort = CentralPort(listOf(wire1, wire2))

        assertEquals(2, centralPort.findManhattanDistanceToClosestIntersection())
    }

    @Test
    fun findManhattanDistanceToClosestIntersectionWhenThereAreTwoWiresThatIntersectTwice() {
        val wire1Steps = listOf(WireVector("U3"), WireVector("R2"), WireVector("D2"), WireVector("L1"))
        val wire1 = Wire(wire1Steps)

        val wire2Steps = listOf(WireVector("R3"), WireVector("U2"), WireVector("L2"), WireVector("D1"))
        val wire2 = Wire(wire2Steps)

        val centralPort = CentralPort(listOf(wire1, wire2))

        assertEquals(2, centralPort.findManhattanDistanceToClosestIntersection())
    }

    @Test
    fun findManhattanDistanceToClosestIntersectionWhenThereIsAnIntersectionToTheBottomLeftOfTheInitialPoint() {
        val wire1Steps = listOf(
            WireVector("L2"),
            WireVector("D3"),
            WireVector("R3"),
            WireVector("U4")
        )

        val wire1 = Wire(wire1Steps)

        val wire2Steps = listOf(
            WireVector("D2"),
            WireVector("L3"),
            WireVector("U3"),
            WireVector("R4")
        )

        val wire2 = Wire(wire2Steps)

        val centralPort = CentralPort(listOf(wire1, wire2))

        assertEquals(2, centralPort.findManhattanDistanceToClosestIntersection())
    }
}
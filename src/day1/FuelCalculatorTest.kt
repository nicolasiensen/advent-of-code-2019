package day1

import org.junit.jupiter.api.Assertions.*

internal class FuelCalculatorTest {
    @org.junit.jupiter.api.Test
    fun calculateWhenNoModuleMassIsProvided() {
        assertEquals(0, FuelCalculator.calculate(arrayListOf()))
    }

    @org.junit.jupiter.api.Test
    fun calculateWhenModuleMassRequiresNoFuel() {
        assertEquals(0, FuelCalculator.calculate(arrayListOf(6)))
    }

    @org.junit.jupiter.api.Test
    fun calculateWhenModuleMassRequiresFuel() {
        assertEquals(1, FuelCalculator.calculate(arrayListOf(9)))
    }

    @org.junit.jupiter.api.Test
    fun calculateWhenModuleMassRequiresFuelThatAlsoRequiresFuel() {
        assertEquals(9 + 1, FuelCalculator.calculate(arrayListOf(33)))
    }

    @org.junit.jupiter.api.Test
    fun calculateWhenModuleMassRequiresFuelThatAlsoRequiresFuelThatRequiresFuel() {
        assertEquals(33 + 9 + 1, FuelCalculator.calculate(arrayListOf(105)))
    }

    @org.junit.jupiter.api.Test
    fun calculateWhenMultipleModuleMassesAreProvided() {
        assertEquals((9 + 1) + (33 + 9 + 1), FuelCalculator.calculate(arrayListOf(33, 105)))
    }
}
package day2

import day1.FuelCalculator
import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

internal class IntcodeComputerTest {
    @org.junit.jupiter.api.Test
    fun processWhenProgramHasOnlyOneSumOpcode() {
        assertEquals(arrayListOf(2,0,0,0,99), IntcodeComputer.process(arrayListOf(1,0,0,0,99)))
    }

    @org.junit.jupiter.api.Test
    fun processWhenProgramHasOnlyOneMultiplicationOpcode() {
        assertEquals(arrayListOf(2,3,0,6,99), IntcodeComputer.process(arrayListOf(2,3,0,3,99)))
    }

    @org.junit.jupiter.api.Test
    fun processWhenProgramHasMultipleOpcodes() {
        assertEquals(arrayListOf(30,1,1,4,2,5,6,0,99), IntcodeComputer.process(arrayListOf(1,1,1,4,99,5,6,0,99)))
    }

    @org.junit.jupiter.api.Test
    fun processWhenProgramHasInvalidOpcode() {
        assertFailsWith<IntcodeComputer.InvalidOpcode> { IntcodeComputer.process(arrayListOf(3,0,0,0,99)) }
    }

    @org.junit.jupiter.api.Test
    fun determineInputPairWhenOnlyNounNeedsToChange() {
        assertEquals(arrayListOf(2,0), IntcodeComputer.determineInputPair(arrayListOf(1,0,0,0,99), 1))
    }

    @org.junit.jupiter.api.Test
    fun determineInputPairWhenBothInputsNeedToChange() {
        assertEquals(arrayListOf(4,3), IntcodeComputer.determineInputPair(arrayListOf(1,0,0,0,99), 99))
    }

    @org.junit.jupiter.api.Test
    fun determineInputPairWhenItIsImpossibleToSolve() {
        assertFailsWith<IntcodeComputer.IndeterminableOutputException> { IntcodeComputer.determineInputPair(arrayListOf(1,0,0,0,99), 42) }
    }
}
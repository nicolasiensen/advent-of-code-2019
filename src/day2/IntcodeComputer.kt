package day2

import java.lang.Exception

object IntcodeComputer {
    class InvalidOpcodeException(message: String) : Exception(message)
    class IndeterminableInputPairException(message: String) : Exception(message)

    fun process(program: List<Int>): List<Int> {
        var opcodeIndex = 0
        val result = program.toMutableList()

        while(result[opcodeIndex] != 99) {
            val opcode = result[opcodeIndex]
            val input1 = result[opcodeIndex + 1]
            val input2 = result[opcodeIndex + 2]
            val output = result[opcodeIndex + 3]

            result[output] = when (opcode) {
                1 -> result[input1] + result[input2]
                2 -> result[input1] * result[input2]
                else -> throw InvalidOpcodeException("Invalid opcode $opcode at position $opcodeIndex")
            }

            opcodeIndex += 4
        }

        return result
    }

    fun determineInputPair(program: List<Int>, desiredOutput: Int) : List<Int> {
        var noun = 0
        var verb = 0

        while(verb < program.size) {
            noun = 0
            while (noun < program.size) {
                val newProgram = program.toMutableList()
                newProgram[1] = noun
                newProgram[2] = verb
                val result = process(newProgram)
                if (result[0] == desiredOutput) return arrayListOf(noun, verb)
                noun++
            }
            verb++
        }

        throw IndeterminableInputPairException("It was not possible to determine an input for the given program and desired output")
    }
}
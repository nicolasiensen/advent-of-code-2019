package day4

class Password(private val value: Int, private val exactlyTwoEqualAdjacentDigits : Boolean = true) {
    fun isValid() : Boolean {
        return hasSixDigits()
                && !hasDecreasingDigit()
                && if (exactlyTwoEqualAdjacentDigits) hasExactlyTwoEqualAdjacentDigits() else hasEqualAdjacentDigits()
    }

    private fun hasSixDigits() : Boolean {
        return value.toString().length == 6
    }

    private fun hasEqualAdjacentDigits() : Boolean {
        return value.toString()
            .toList()
            .zipWithNext()
            .any { it.first == it.second }
    }

    private fun hasExactlyTwoEqualAdjacentDigits() : Boolean {
        return value.toString()
            .map { it.toString() }
            .reduce { acc, c -> if (acc.substring(acc.lastIndex) == c) "$acc$c" else "$acc,$c" }
            .split(",")
            .any { it.length == 2 }
    }

    private fun hasDecreasingDigit() : Boolean {
        return value.toString()
            .map { it.toInt() }
            .zipWithNext()
            .any { it.first > it.second }
    }
}
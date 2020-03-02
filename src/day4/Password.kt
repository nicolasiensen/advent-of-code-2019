package day4

class Password(val value: Int) {
    fun isValid() : Boolean {
        val stringValue = value.toString()
        if (stringValue.length != 6) return false

        var i = 0
        var hasEqualAdjacentDigits = false

        while (i < stringValue.length - 1) {
            if (stringValue[i] == stringValue[i + 1]) {
                hasEqualAdjacentDigits = true
            }
            i++
        }

        if (!hasEqualAdjacentDigits) return false

        var hasDecreasingDigit = false
        i = 1

        while (i < stringValue.length) {
            if (stringValue[i - 1].toInt() > stringValue[i].toInt()) {
                hasDecreasingDigit = true
            }
            i++
        }

        if (hasDecreasingDigit) return false

        return true
    }
}
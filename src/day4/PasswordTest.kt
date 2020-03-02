package day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PasswordTest {
    @Test
    fun isValidWhenValueMeetsAllCriteria() {
        assertEquals(true, Password(111111).isValid())
    }

    @Test
    fun isValidWhenValueIsShorterThanSixDigits() {
        assertEquals(false, Password(11111).isValid())
    }

    @Test
    fun isValidWhenValueIsLongerThanSixDigits() {
        assertEquals(false, Password(1111111).isValid())
    }

    @Test
    fun isValidWhenValueHasNoEqualAdjacentDigits() {
        assertEquals(false, Password(123456).isValid())
    }

    @Test
    fun isValidWhenValueHasADigitThatDecreasesGoingLeftToRight() {
        assertEquals(false, Password(223450).isValid())
    }
}
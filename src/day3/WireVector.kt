package day3

import java.awt.Point
import java.lang.Error
import java.lang.Exception

class WireVector(instruction: String) {
    class InvalidDirectionException(message: String) : Exception(message)

    companion object {
        const val UP = 'U'
        const val RIGHT = 'R'
        const val DOWN = 'D'
        const val LEFT = 'L'
        val VALID_DIRECTIONS = listOf<Char>(UP, RIGHT, DOWN, LEFT)
    }

    private val direction = instruction[0]
    private val magnitude = instruction.substring(1).toInt()

    init {
        if (!VALID_DIRECTIONS.contains(direction)) throw InvalidDirectionException("Direction $direction is not valid")
    }

    private fun isUp() : Boolean { return direction == UP }
    private fun isRight() : Boolean { return direction == RIGHT }
    private fun isDown() : Boolean { return direction == DOWN }
    private fun isLeft() : Boolean { return direction == LEFT }

    fun getPoints(initialPoint: Point) : List<Point> {
        return (1..magnitude).map {
            Point(
                if (isRight()) initialPoint.x + it else if (isLeft()) initialPoint.x - it else initialPoint.x,
                if (isUp()) initialPoint.y + it else if (isDown()) initialPoint.y - it else initialPoint.y
            )
        }
    }
}
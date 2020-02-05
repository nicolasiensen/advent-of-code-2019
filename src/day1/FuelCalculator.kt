package day1

object FuelCalculator {
    fun calculate(moduleMasses: List<Int>) : Int {
        return moduleMasses.map { calculateFuelForModule(it) }.sum()
    }

    private fun calculateFuelForModule(moduleMass: Int) : Int {
        val fuel = moduleMass.div(3).minus(2)
        return if (fuel <= 6) {
            fuel
        } else {
            fuel + calculateFuelForModule(fuel)
        }
    }
}
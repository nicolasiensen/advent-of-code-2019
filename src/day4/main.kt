package day4

fun main(args: Array<String>) {
    val range = 246540..787419

//    PART 1
    val passwordsPart1 = range.toList().map { Password(it, false) }
    val validPasswordsPart1 = passwordsPart1.filter { it.isValid() }
    println("Part 1: There are ${validPasswordsPart1.size} different passwords within the range $range")

//    PART 2
    val passwordsPart2 = range.toList().map { Password(it) }
    val validPasswordsPart2 = passwordsPart2.filter { it.isValid() }
    println("Part 2: There are ${validPasswordsPart2.size} different passwords within the range $range")
}
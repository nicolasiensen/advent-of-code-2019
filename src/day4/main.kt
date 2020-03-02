package day4

fun main(args: Array<String>) {
    val range = 246540..787419
    val passwords = range.toList().map { Password(it) }
    val validPasswords = passwords.filter { it.isValid() }
    println("There are ${validPasswords.size} different passwords within the range $range")
}
class lv0_두_수의_합 {
    fun solution(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}

fun main() {
    val inps = arrayOf(
        arrayOf(2, 3),
        arrayOf(100, 2)
    )

    for (inp in inps) {
        println(lv0_두_수의_합().solution(inp[0], inp[1]))
    }
}
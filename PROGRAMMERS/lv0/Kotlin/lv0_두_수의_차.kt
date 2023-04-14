class lv0_두_수의_차 {
    fun solution(num1: Int, num2: Int): Int {
        return num1 - num2
    }
}

fun main() {
    val result: StringBuilder = StringBuilder()

    val inps = arrayOf(
        arrayOf(2, 3),
        arrayOf(100, 2),
    )

    for (inp in inps) {
        result.append("${lv0_두_수의_차().solution(inp[0], inp[1])}\n")
    }

    println(result)
}
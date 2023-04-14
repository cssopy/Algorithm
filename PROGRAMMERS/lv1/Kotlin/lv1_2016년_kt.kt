class lv1_2016년_kt {
    fun solution(a: Int, b: Int): String {
        val days = arrayOf("THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED")
        val lastDays = arrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

        return days[((0..a - 2).sumOf { lastDays[it] } + b) % 7]
    }
}

fun main() {
    var result: StringBuilder = StringBuilder();

    val inps = arrayOf(
        arrayOf(5, 24)
    )

    for (inp in inps) {
        result.append("${lv1_2016년_kt().solution(inp[0], inp[1])}\n")
    }

    print(result)
}
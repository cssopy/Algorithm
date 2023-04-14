class lv1_두_정수_사이의_합_kt {
    fun solution(a: Int, b: Int): Long {
        var ans: Long = 0;
        for (v in a.coerceAtMost(b)..a.coerceAtLeast(b)) {
            ans += v
        }
        return ans
    }
}

fun main() {
    var result = StringBuilder()

    val inp = arrayOf(
        arrayOf(3, 5),
        arrayOf(3, 3),
        arrayOf(5, 3)
    )

    inp.forEach { result.append("${lv1_두_정수_사이의_합_kt().solution(it[0], it[1])}\n") }

    print(result)
}
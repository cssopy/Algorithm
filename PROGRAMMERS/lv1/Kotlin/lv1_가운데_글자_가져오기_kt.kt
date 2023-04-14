class lv1_가운데_글자_가져오기_kt {
    fun solution(s: String): String {
        val mid: Int = s.length / 2;
        return s.substring(mid - 1 + s.length % 2..mid)
    }
}

fun main() {
    var result = StringBuilder()

    val inps = arrayOf(
        "abcde",
        "qwer"
    )

    for (inp in inps) {
        result.append("${lv1_가운데_글자_가져오기_kt().solution(inp)}\n")
    }

    print(result)
}
class lv0_머쓱이보다_키_큰_사람 {
    fun solution(array: IntArray, height: Int): Int {
        return array.count { it > height }
    }

    class Inp(val array: IntArray, val height: Int)
}

fun main() {
    val inps = arrayOf(
        lv0_머쓱이보다_키_큰_사람.Inp(intArrayOf(149, 180, 192, 170), 167),
        lv0_머쓱이보다_키_큰_사람.Inp(intArrayOf(180, 120, 140), 190)
    )

    for (inp in inps) {
        println(lv0_머쓱이보다_키_큰_사람().solution(inp.array, inp.height))
    }
}
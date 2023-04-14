class lv0_중복된_숫자_개수 {
    fun solution(array: IntArray, n: Int): Int {
        return array.count { it == n }
    }

    class Inp(val array: IntArray, val n: Int)
}

fun main() {
    val inps: Array<lv0_중복된_숫자_개수.Inp> = arrayOf(
        lv0_중복된_숫자_개수.Inp(intArrayOf(1, 1, 2, 3, 4, 5), 1),
        lv0_중복된_숫자_개수.Inp(intArrayOf(0, 2, 3, 4), 1)
    )

    for (inp: lv0_중복된_숫자_개수.Inp in inps) {
        println(lv0_중복된_숫자_개수().solution(inp.array, inp.n));
    }
}
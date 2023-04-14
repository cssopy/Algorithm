class lv1_나누어_떨어지는_숫자_배열_kt {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var ans = mutableListOf<Int>()

        arr.forEach { if(it % divisor==0) ans.add(it) }
        ans.sort()

        if(ans.isEmpty()) ans.add(-1)

        return ans.toIntArray()
    }

    class Inp(val arr: IntArray, val divisor: Int)
}

fun main() {
    var result = StringBuilder()

    val inps = arrayOf(
        lv1_나누어_떨어지는_숫자_배열_kt.Inp(intArrayOf(5, 9, 7, 10), 5),
        lv1_나누어_떨어지는_숫자_배열_kt.Inp(intArrayOf(2, 36, 1, 3), 1),
        lv1_나누어_떨어지는_숫자_배열_kt.Inp(intArrayOf(3, 2, 6), 10)
    )

    for (inp in inps) {
        val r = lv1_나누어_떨어지는_숫자_배열_kt().solution(inp.arr, inp.divisor);
        for (v in r) {
            result.append("$v ")
        }
        result.append('\n')
    }

    print(result)
}
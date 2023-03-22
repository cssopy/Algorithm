// 정수 제곱근 판별
// 정수 n에 대해, n이 정수 x의 제곱인지 아닌지 판단하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12934
public class lv1_정수_제곱근_판별 {
	public static void main(String[] args) {
		int[] inp = { 121, 3 };

		for (int i = 0; i < inp.length; i++) {
			System.out.println(solution(inp[i]));
		}
	}

	public static long solution(long n) {
		double x = Math.sqrt(n);
		double y = x - (int) x;

		if (y == 0) {
			return (long) Math.pow(x + 1, 2);
		} else {
			return -1;
		}
	}
}

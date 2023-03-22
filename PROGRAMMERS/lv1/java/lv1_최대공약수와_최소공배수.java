import java.util.Arrays;

// 최대공약수와 최소공배수
// 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12940
public class lv1_최대공약수와_최소공배수 {
	public static void main(String[] args) {
		int[] ns = { 3, 2 };
		int[] ms = { 12, 5 };

		for (int i = 0; i < 2; i++) {
			System.out.println(Arrays.toString(solution(ns[i], ms[i])));
		}
	}

	public static int[] solution(long n, long m) {
		int[] answer = new int[2];

		long ans = 0;
		for (long i = Math.min(n, m); i > 0; i--) {
			if (n % i == 0 && m % i == 0) {
				ans = Math.max(i, ans);
			}
		}
		answer[0] = (int) ans;
		// 최소공배수 * 최대공약수 = 두수의 곱
		answer[1] = (int) (n * m / answer[0]);

		return answer;
	}
}

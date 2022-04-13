package Algorithm.PROGRAMMERS.lv1;

// 약수의 개수와 덧셈
// https://programmers.co.kr/learn/courses/30/lessons/77884
public class lv1_약수의_개수와_덧셈 {
	public static void main(String[] args) {
		int[] left = { 13, 24 };
		int[] right = { 17, 27 };

		for (int i = 0; i < 2; i++) {
			System.out.println(solution(left[i], right[i]));
		}
	}

	public static int solution(int left, int right) {
		int answer = 0;
		for (int i = left; i <= right; i++) {
			double n = Math.pow(i, 0.5);
			if (n - (int) n != 0) {
				answer += i;
			} else {
				answer -= i;
			}
		}
		return answer;
	}
}

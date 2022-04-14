package Algorithm.PROGRAMMERS.lv1;

// 3진법 뒤집기
// https://programmers.co.kr/learn/courses/30/lessons/68935
public class lv1_3진법_뒤집기 {
	public static void main(String[] args) {
		int[] ns = { 45, 125 };

		for (int n : ns) {
			System.out.println(solution(n));
		}
	}

	public static int solution(int n) {
		StringBuilder t = new StringBuilder();

		int s;
		int r;
		do {
			s = n / 3;
			r = n % 3;

			t.append(r);

			n = s;
		} while (s != 0);

		int answer = 0;
		for (int i = t.length() - 1, j = 0; i >= 0; i--) {
			answer += Math.pow(3, j++) * Integer.parseInt(Character.toString(t.charAt(i)));
		}
		return answer;
	}
}

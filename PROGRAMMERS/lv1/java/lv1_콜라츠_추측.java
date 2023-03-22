// 콜라츠 추측
// 어떠한 조건에 따라 입력된 수에 어떠한 연산을 할때 1이 될때까지 연산의 횟수를 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12943
public class lv1_콜라츠_추측 {
	public static void main(String[] args) {
		int[] inps = { 6, 16, 626331 };

		for (int i = 0; i < inps.length; i++) {
			System.out.println(inps[i] + " " + solution(inps[i]));
		}
	}

	public static int solution(long num) {
		int c = 0;
		while (true) {
			// 연산 횟수가 500번 넘으면 -1 반환
			if (c > 500) {
				return -1;
			}

			// num이 목표한 1이 되는 순간 그때의 연산 횟수 반환
			if (num == 1) {
				return c;
			}

			// num이 짝수면 2로 나누고 홀수면 3을 곱하고 1더하기
			if (num % 2 == 0) {
				num /= 2;
				c++;
			} else {
				num = (num * 3) + 1;
				c++;
			}
		}
	}
}

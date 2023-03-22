// 음양 더하기
// https://programmers.co.kr/learn/courses/30/lessons/76501?language=java
public class lv1_음양_더하기 {
	public static void main(String[] args) {
		int[][] abs = { { 4, 7, 12 }, { 1, 2, 3 } };
		boolean[][] signs = { { true, false, true }, { false, false, true } };

		for (int i = 0; i < abs.length; i++) {
			System.out.println(solution(abs[i], signs[i]));
		}
	}

	public static int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for (int i = 0; i < absolutes.length; i++) {
			if (signs[i]) {
				answer += absolutes[i];
			} else {
				answer -= absolutes[i];
			}
		}
		return answer;
	}
}

// 두 정수 사이의 합
// 두 정수 a, b 사이에 속한 모든 정수의 합을 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12912
public class lv1_두_정수_사이의_합 {
	public static void main(String[] args) {
		int[][] inp = { { 3, 5 }, { 3, 3 }, { 5, 3 } };

		for (int i = 0; i < inp.length; i++) {
			System.out.println(solution(inp[i][0], inp[i][1]));
		}
	}

	public static long solution(int a, int b) {
		long answer = 0;
		
		// a와 b가 같다면 둘 중 아무거나 반환
		if (a == b) {
			answer = a;
		} 
		// 같지 않다면 대소를 구분하여 작은수부터 큰수까지 for문을 통해 덧셈
		else {
			for (long i = Math.min(a, b); i <= Math.max(a, b); i++) {
				answer += i;
			}
		}
		
		return answer;
	}
}

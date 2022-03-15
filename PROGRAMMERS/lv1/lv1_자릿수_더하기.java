package Algorithm.PROGRAMMERS.lv1;

// 자릿수 더하기
// 자연수 N에 대해 N의 각 자릿수의 합을 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12931
public class lv1_자릿수_더하기 {
	public static void main(String[] args) {
		int[] N = { 123, 987 };

		for (int i = 0; i < N.length; i++) {
			System.out.println(solution(N[i]));
		}
	}

	public static int solution(int n) {
		int answer = 0;

		// n의 자릿수에 접근하기 쉽게 문자열로 변환
		String s = Integer.toString(n);
		// n의 각 자릿수를 answer에 더함
		for (int i = 0; i < s.length(); i++) {
			answer += Integer.parseInt(Character.toString(s.charAt(i)));
		}

		return answer;
	}
}

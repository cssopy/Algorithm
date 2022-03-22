package Algorithm.PROGRAMMERS.lv1;

// 문자열 내림차순으로 배치하기
// 문자열 s에 있는 문자들을 큰것부터 작은 순으로 재정렬한 문자열을 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12917
public class lv1_문자열_내림차순으로_배치하기 {
	public static void main(String[] args) {
		String inp = "Zbcdefg";

		System.out.println(solution(inp));
	}

	public static String solution(String s) {
		// 문자들의 개수를 저장할 배열
		int[] chars = new int['z' + 1];

		// 문자열 s에 있는 문자들의 개수를 셈
		for (int i = 0; i < s.length(); i++) {
			chars[s.charAt(i)]++;
		}

		// 재정렬한 문자열
		StringBuilder answer = new StringBuilder();
		// 값이 큰 문자부터 접근하기 위해 chars의 끝부터 접근
		for (int i = chars.length - 1; i >= 0; i--) {
			// i의 값을 가진 문자가 1개이상 헤아려 졌다면 헤아린 횟수만큼 해당 i의 값을 가진 문자를 answer에 append
			if (chars[i] != 0) {
				for (int j = 0; j < chars[i]; j++) {
					answer.append((char) i);
				}
			}
		}
		
		return answer.toString();
	}
}

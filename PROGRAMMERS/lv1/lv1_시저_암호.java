package Algorithm.PROGRAMMERS.lv1;

// 시저 암호
// 입력된 문자열에 각 문자를 n만큼 밀어서 다른 알파벳으로 바뀐 문자열을 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12926
public class lv1_시저_암호 {
	public static void main(String[] args) {
		String[] inps = { "AB", "z", "a B z" };
		int[] ns = { 1, 1, 4 };

		for (int i = 0; i < inps.length; i++) {
			System.out.println(solution(inps[i], ns[i]));
		}
	}

	public static String solution(String s, int n) {
		StringBuilder answer = new StringBuilder();
		// 문자열에 각 문자에 접근
		for (int i = 0; i < s.length(); i++) {
			// 해당 문자가 스페이스면 바로 append
			if (s.charAt(i) == ' ') {
				answer.append(s.charAt(i));
			} 
			// 해당 문자가 스페이스가 아닌 알파벳이라면
			else {
				// 해당 문자가 소문자라면
				if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
					// 해당 문자를 n만큼 밀었을때 z를 넘는다면 문자는 'a'부터 다시 시작하는 처리
					if (s.charAt(i) + n > 'z') {
						answer.append(Character.toChars(s.charAt(i) + n - 'z' + 'a' - 1));
					} 
					// 해당 문자를 n만큼 밀었을때 z를 넘지 않으면 바로 append
					else {
						answer.append(Character.toChars(s.charAt(i) + n));
					}
				} 
				// 해당 문자가 대문자라면
				else {
					// 해당 문자를 n만큼 밀었을때 z를 넘는다면 문자는 'A'부터 다시 시작하는 처리
					if (s.charAt(i) + n > 'Z') {
						answer.append(Character.toChars(s.charAt(i) + n - 'Z' + 'A' - 1));
					} 
					// 해당 문자를 n만큼 밀었을때 z를 넘지 않으면 바로 append
					else {
						answer.append(Character.toChars(s.charAt(i) + n));
					}
				}
			}
		}
		return answer.toString();
	}
}

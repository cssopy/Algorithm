// 가운데 글자 가져오기
// https://programmers.co.kr/learn/courses/30/lessons/12903
public class lv1_가운데_글자_가져오기 {
	public static void main(String[] args) {
		String[] inps = { "abcde", "qwer" };

		for (String inp : inps) {
			System.out.println(solution(inp));
		}
	}

	public static String solution(String s) {
		String answer = "";
		if (s.length() % 2 == 0) {
			answer = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
		} else {
			answer = s.substring(s.length() / 2, s.length() / 2 + 1);
		}
		return answer;
	}
}

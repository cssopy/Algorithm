// 문자열 내 p와 y의 개수
// 문자열 s에서 p와 y의 개수를 비교하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12916
public class lv1_문자열_내_p와_y의_개수 {
	public static void main(String[] args) {
		String[] s = { "pPoooyY", "Pyy" };

		for (String i : s) {
			System.out.println(solution(i));
		}
	}

	static boolean solution(String s) {
		int p = 0, y = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
				p++;
			}
			if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
				y++;
			}
		}

		return (p == y) ? true : false;
	}
}

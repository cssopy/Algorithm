package Algorithm.PROGRAMMERS.lv2;

a
// 조이스틱
// https://programmers.co.kr/learn/courses/30/lessons/42860
public class lv2_조이스틱_0000000000 {
	public static void main(String[] args) {
		String[] inps = { "JEROEN", "JAN", "BBBBAAAABA"};

		for (String inp : inps) {
			System.out.println(inp);
			System.out.println(solution(inp));
		}
	}

	public static int solution(String name) {
		// 시작점, 끝점
		int si = 1, ei = name.length() - 1;
		// 시작점부터 중간까지 A의 개수, 끝점부터 중간까지 A의 개수
		int sa = 0, ea = 0;

		int ans = updown(name.charAt(0));
		while (true) {
			if (si >= ei) {
				if (si == ei && name.charAt(si) != 'A') {
					ans += updown(name.charAt(si));
				}
				break;
			}

			if (name.charAt(si) == 'A') {
				sa++;
			} else {
				ans += updown(name.charAt(si));
			}
			if (name.charAt(ei) == 'A') {
				ea++;
			} else {
				ans += updown(name.charAt(ei));
			}

			si++;
			ei--;
		}

		if (sa <= ea) {
			int idx = 0;
			for (int i = 1; i < name.length(); i++) {
				if (name.charAt(i) != 'A') {
					idx = i;
				}
			}
			ans += idx;
		} else {
			int idx = name.length();
			for (int i = name.length() - 1; i >= 1; i--) {
				if (name.charAt(i) != 'A') {
					idx = i;
				}
			}
			ans += name.length() - idx;
		}

		return ans;
	}

	public static int updown(char c) {
		return Math.min(c - 'A', 26 - (c - 'A'));
	}
}

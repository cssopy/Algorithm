// 수박수박수박수박수박수?
// 길이가 n이고 "수박수박수.."와 같은 패턴을 유지하는 문자열을 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12922
public class lv1_수박수박수박수박수박수 {
	public static void main(String[] args) {
		int[] inp = { 3, 4 };

		for (int i : inp) {
			System.out.println(solution(i));
		}
	}

	public static String solution(int n) {
		// '수'와 '박' 문자가 있는 문자배열
		char[] subak = { '수', '박' };
		// 정답
		StringBuilder ans = new StringBuilder();

		// n번 반복하면서 ans에 '수'와 '박'을 번갈아 append
		for (int i = 0; i < n; i++) {
			ans.append(subak[i % 2]);
		}
		
		return ans.toString();
	}
}

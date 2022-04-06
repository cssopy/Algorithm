package Algorithm.PROGRAMMERS.lv1;

// [1차] 비밀지도
// https://programmers.co.kr/learn/courses/30/lessons/17681
public class lv1_1차_비밀지도 {
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };

		String[] answer = solution(n, arr1, arr2);
		for (String ans : answer) {
			System.out.println(ans);
		}
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
			String s = Integer.toBinaryString(arr1[i] | arr2[i]).replace('1', '#').replace('0', ' ');

			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n - s.length(); j++) {
				sb.append(" ");
			}
			sb.append(s);

			answer[i] = sb.toString();
		}

		return answer;
	}
}

import java.util.Arrays;

// 자연수 뒤집어 배열로 만들기
// 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열을 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12932
public class lv1_자연수_뒤집어_배열로_만들기 {
	public static void main(String[] args) {
		int n = 12345;

		System.out.println(Arrays.toString(solution(n)));
	}

	public static int[] solution(long n) {
		// n의 각자리수에 접근하기 위한 처리
		String sn = Long.toString(n);
		// 반환할 정답 배열
		int[] answer = new int[sn.length()];
		for (int i = 0; i < sn.length(); i++) {
			// sn의 뒷자리부터 answer에 추가
			answer[i] = Integer.parseInt(Character.toString(sn.charAt(sn.length() - 1 - i)));
		}
		return answer;
	}
}

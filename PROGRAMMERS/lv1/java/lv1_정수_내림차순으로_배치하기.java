// 정수 내림차순으로 배치하기
// 정수 N의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12933
public class lv1_정수_내림차순으로_배치하기 {
	public static void main(String[] args) {
		long n = 118372;

		System.out.println(solution(n));
	}

	public static long solution(long n) {
		// n의 자릿수에 접근하기 쉽게 문자열로 변환
		String s = Long.toString(n);

		// n의 각 자릿수의 개수를 저장할 배열
		int[] edc = new int[10];
		for (int i = 0; i < s.length(); i++) {
			int ed = Integer.parseInt(Character.toString(s.charAt(i)));
			edc[ed]++;
		}

		StringBuilder sb = new StringBuilder();
		// 큰수부터 접근
		for (int i = edc.length - 1; i >= 0; i--) {
			// 그 수의 개수만큼 반복하여 sb에 append
			for(int c=0; c<edc[i]; c++) {
				sb.append(i);
			}
		}
		
		return Long.parseLong(sb.toString());
	}
}

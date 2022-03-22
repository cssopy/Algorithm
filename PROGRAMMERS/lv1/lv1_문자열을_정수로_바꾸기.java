package Algorithm.PROGRAMMERS.lv1;

// 문자열을 정수로 바꾸기
// 문자열 s를 숫자로 변환한 결과를 반환하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12925
public class lv1_문자열을_정수로_바꾸기 {
	public static void main(String[] args) {
		String[] inp = { "1234", "-1234" };

		for (String i : inp) {
			System.out.println(solution(i));
		}
	}

	public static int solution(String s) {
		return Integer.parseInt(s);
	}
}

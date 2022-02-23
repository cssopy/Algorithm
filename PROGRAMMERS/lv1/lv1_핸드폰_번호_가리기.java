package Algorithm.PROGRAMMERS.lv1;

// 핸드폰 번호 가리기
// 문자열로 핸드폰 번호가 주어질때 뒷자리 4자리를 남기고 모두 *으로 가린 문자열을 리턴하는 함수
// https://programmers.co.kr/learn/courses/30/lessons/12948
public class lv1_핸드폰_번호_가리기 {
	public static void main(String[] args) {
		System.out.println(solution("027778888"));
	}

	public static String solution(String phone_number) {
		// 정답으로 리턴할 sb변수
		StringBuilder sb = new StringBuilder();

		// 핸드폰 번호의 처음부터 뒷자리부터 4자리 떨어진 인덱스까지 "*"을 sb에 append
		for (int i = 0; i < phone_number.length() - 4; i++) {
			sb.append("*");
		}
		// 핸드폰 번호의 뒷자리부터 4자리 떨어진 번호부터 끝까지 sb에 append
		for (int i = phone_number.length() - 4; i < phone_number.length(); i++) {
			sb.append(phone_number.charAt(i));
		}

		return sb.toString();
	}
}

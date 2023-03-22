// 문자열 다루기 기본
// 문자열 s의 길이가 4 혹은 6이면서 숫자로만 구성되어 있는지 확이하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12918
public class lv1_문자열_다루기_기본 {
	public static void main(String[] args) {
		String[] inp = { "a234", "1234" };

		for (String i : inp) {
			System.out.println(solution(i));
		}
	}

	public static boolean solution(String s) {
		if (s.length() == 4 || s.length() == 6) {
			try {
				Integer.parseInt(s);
				return true;
			} catch (Exception e) {
				// 문자열 s를 int로 바꾸는데 exception이 발생한다면 숫자가 아닌 문자가 끼어있다는 것, false리턴
				return false;
			}
		}
		// 길이가 4 또는 6이 아니면 false리턴
		return false;
	}
}

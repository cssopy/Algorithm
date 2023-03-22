// 2016년
// https://programmers.co.kr/learn/courses/30/lessons/12901
public class lv1_2016년 {
	public static void main(String[] args) {
		System.out.println(solution(5, 24));
	}

	public static String solution(int a, int b) {
		int[] m = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] d = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		int ix = 5;

		int ds = 0;
		for (int i = 0; i < a - 1; i++) {
			ds += m[i];
		}

		return d[(ix + ds + b - 1) % 7];
	}
}

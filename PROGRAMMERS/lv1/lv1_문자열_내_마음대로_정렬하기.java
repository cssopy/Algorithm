package Algorithm.PROGRAMMERS.lv1;

import java.util.Arrays;
import java.util.Comparator;

// 문자열 내 마음대로 정렬하기
// 
// https://programmers.co.kr/learn/courses/30/lessons/12915
public class lv1_문자열_내_마음대로_정렬하기 {
	public static void main(String[] args) {
		String[][] strings = { { "sun", "bed", "car" }, { "abce", "abcd", "cdx" } };
		int[] n = { 1, 2 };

		for (int i = 0; i < 2; i++) {
			System.out.println(Arrays.toString(solution(strings[i], n[i])));
		}
	}

	public static String[] solution(String[] strings, int n) {
		Arrays.sort(strings, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (o1.charAt(n) != o2.charAt(n)) ? (o1.charAt(n) - o2.charAt(n)) : (o1.compareTo(o2));
			}

		});
		return strings;
	}
}

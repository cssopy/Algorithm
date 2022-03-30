package Algorithm.PROGRAMMERS.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 나누어 떨어지는 숫자 배열
// 숫자배열에서 div가 약수인 숫자들을 오름차순으로 정렬한 배열을 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12910
public class lv1_나누어_떨어지는_숫자_배열 {
	public static void main(String[] args) {
		int[][] inps = { { 5, 9, 7, 10 }, { 2, 36, 1, 3 }, { 3, 2, 6 } };
		int[] divs = { 5, 1, 10 };

		for (int i = 0; i < divs.length; i++) {
			System.out.println(Arrays.toString(solution(inps[i], divs[i])));
		}
	}

	public static int[] solution(int[] arr, int divisor) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				list.add(arr[i]);
			}
		}
		
		if(list.size()==0) {
			return new int[]{-1};
		}
		int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
		Arrays.sort(answer);
		return answer;
	}
}

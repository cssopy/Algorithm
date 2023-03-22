import java.util.Arrays;

// 제일 작은 수 제거하기
// 정수를 저장한 배열 arr에서 가장 작은 수를 제거한 배열을 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12935
public class lv1_제일_작은_수_제거하기 {
	public static void main(String[] args) {
		int[][] inp = { { 4, 3, 2, 1 }, { 10 } };

		for (int i = 0; i < inp.length; i++) {
			System.out.println(Arrays.toString(solution(inp[i])));
		}
	}

	public static int[] solution(int[] arr) {
		if (arr.length == 1) {
			// arr길이가 1이면 최소값 제거하면 비게됨
			return new int[] { -1 };
		} else {
			int max = Integer.MAX_VALUE;
			int idx = 0;
			// 최소값 인덱스 찾기
			for (int i = 0; i < arr.length; i++) {
				if (max > arr[i]) {
					max = arr[i];
					idx = i;
				}
			}

			int[] answer = new int[arr.length - 1];
			int cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				if (i == idx) {
					continue;
				}
				answer[cnt++] = arr[i];
			}

			return answer;
		}
	}
}

import java.util.Arrays;

// 같은 숫자는 싫어
// 배열 arr에서 중복된 숫자는 없앤 배열을 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12906
public class lv1_같은_숫자는_싫어 {
	public static void main(String[] args) {
		int[][] inps = { { 1, 1, 3, 3, 0, 1, 1 }, { 4, 4, 4, 3, 3 } };

		for (int[] inp : inps) {
			System.out.println(Arrays.toString(solution(inp)));
		}
	}

	public static int[] solution(int[] arr) {
		int[] ans = new int[arr.length];
		ans[0] = arr[0];
		int idx = 0;
		int cur = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (cur != arr[i]) {
				ans[++idx] = arr[i];
				cur = arr[i];
			}
		}

		return Arrays.copyOfRange(ans, 0, idx + 1);
	}
}

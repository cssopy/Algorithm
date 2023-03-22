import java.util.Arrays;

// 두 개 뽑아서 더하기
// https://programmers.co.kr/learn/courses/30/lessons/68644
public class lv1_두_개_뽑아서_더하기 {
	public static void main(String[] args) {
		int[][] inps = { { 2, 1, 3, 4, 1 }, { 5, 0, 2, 7 } };

		for (int[] inp : inps) {
			System.out.println(Arrays.toString(solution(inp)));
		}
	}

	public static int[] solution(int[] numbers) {
		boolean[] gh = new boolean[201];
		int cnt = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (!gh[numbers[i] + numbers[j]]) {
					gh[numbers[i] + numbers[j]] = true;
					cnt++;
				}
			}
		}

		int[] ans = new int[cnt];
		for (int i = 0, k = 0; i < 201; i++) {
			if (gh[i]) {
				ans[k++] = i;
			}
		}
		return ans;
	}
}

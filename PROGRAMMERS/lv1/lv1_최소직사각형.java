package Algorithm.PROGRAMMERS.lv1;

// 최소직사각형
// https://programmers.co.kr/learn/courses/30/lessons/86491
public class lv1_최소직사각형 {
	public static void main(String[] args) {
		int[][][] inps = { { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } },
				{ { 10, 7 }, { 12, 3 }, { 8, 15 }, { 14, 7 }, { 5, 15 } },
				{ { 14, 4 }, { 19, 6 }, { 6, 16 }, { 18, 7 }, { 7, 11 } } };

		for (int[][] inp : inps) {
			System.out.println(solution(inp));
		}
	}

	public static int solution(int[][] sizes) {
		int fm = 0;
		int sm = 0;
		for (int i = 0; i < sizes.length; i++) {
			int max = Math.max(sizes[i][0], sizes[i][1]);
			int min = Math.min(sizes[i][0], sizes[i][1]);

			fm = Math.max(fm, max);
			sm = Math.max(sm, min);
		}

		return fm * sm;
	}
}

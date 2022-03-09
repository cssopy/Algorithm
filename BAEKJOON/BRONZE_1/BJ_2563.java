package Algorithm.BAEKJOON.BRONZE_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이 (브론즈 1)
// 도화지 위에 색종이가 차지하는 공간의 넓이를 구하는 문제
// https://www.acmicpc.net/problem/2563
public class BJ_2563 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 색종이의 수
		int T = Integer.parseInt(br.readLine());
		// 도화지 배열
		boolean[][] paper = new boolean[100][100];
		// 칠해진 칸수
		int[] ans = new int[1];
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			paint(paper, x, y, ans);
		}

		System.out.println(ans[0]);
	}

	// (x,y)좌표부터 10칸씩 색칠하는 함수
	public static void paint(boolean[][] paper, int x, int y, int[] ans) {
		for (int xx = x; xx < x + 10; xx++) {
			for (int yy = y; yy < y + 10; yy++) {
				if (!paper[xx][yy]) {
					paper[xx][yy] = true;
					ans[0]++;
				}
			}
		}
	}
}

package Algorithm.BAEKJOON.SIVER_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 맥주 마시면서 걸어가기 (실버 1)
// https://www.acmicpc.net/problem/9205
public class BJ_9205 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 편의점의 수
			int N = Integer.parseInt(br.readLine());

			Point[] ps = new Point[N + 2];
			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());

				if (i == 0) {
					ps[i] = new Point(Y, X);
				} else if (i == N + 1) {
					ps[i] = new Point(Y, X);
				} else {
					ps[i] = new Point(Y, X);
				}
			}

			String ans = solve(N, ps, new boolean[N + 2][N + 2]);

			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static String solve(int N, Point[] ps, boolean[][] floyd) {
		// 서로 다른 정점 사이의 거리가 1000보다 작으면 이어진 걸로 판단
		for (int i = 0; i < N + 2; i++) {
			for (int j = i + 1; j < N + 2; j++) {
				if (ps[i].getDis(ps[j]) <= 1000) {
					floyd[i][j] = floyd[j][i] = true;
				}
			}
		}

		// 플로이드 와샬
		for (int k = 0; k < N + 2; k++) {
			for (int i = 0; i < N + 2; i++) {
				if (i == k) {
					continue;
				}
				for (int j = 0; j < N + 2; j++) {
					if (j == i || j == k) {
						continue;
					}

					if (floyd[i][k] && floyd[k][j]) {
						floyd[i][j] = true;
					}
				}
			}
		}

		if (floyd[0][N + 1]) {
			return "happy";
		} else {
			return "sad";
		}
	}

	public static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		public int getDis(Point o) {
			return Math.abs(this.i - o.i) + Math.abs(this.j - o.j);
		}
	}
}
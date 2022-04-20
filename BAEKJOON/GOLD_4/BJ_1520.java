package Algorithm.BAEKJOON.GOLD_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
a
// 내리막 길 (골드 4)
// https://www.acmicpc.net/problem/1520
public class BJ_1520 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 산의 세로 크기
		int M = Integer.parseInt(st.nextToken());
		// 산의 가로 크기
		int N = Integer.parseInt(st.nextToken());

		// 산
		int[][] map = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] ans = new int[1];
		solve(M, N, map, new Point(0, 0), ans);

		System.out.println(ans[0]);
	}

	public static void solve(int M, int N, int[][] map, Point cp, int[] ans) {
		// 맵의 오른쪽 끝에 도달한다면 count
		if (cp.i == M - 1 && cp.j == N - 1) {
			ans[0]++;
			return;
		}

		int[] di = { -1, 1, 0, 0 };
		int[] dj = { 0, 0, -1, 1 };

		for (int dir = 0; dir < 4; dir++) {
			// 4방향에 대한 다음 위치
			int ni = cp.i + di[dir];
			int nj = cp.j + dj[dir];

			// 맵을 벗어나면 continue
			if (ni < 0 || nj < 0 || ni >= M || nj >= N) {
				continue;
			}

			// 내리막이라면 이동
			if (map[ni][nj] < map[cp.i][cp.j]) {
				solve(M, N, map, new Point(ni, nj), ans);
			}
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
	}
}

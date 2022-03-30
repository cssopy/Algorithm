package Algorithm.BAEKJOON.GOLD_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 치즈 (골드 4)
// 치즈가 겉부터 녹아 없어질때 다 없어질때까지의 시간을 구하는 문제
// https://www.acmicpc.net/problem/2636
public class BJ_2636 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 세로 길이
		int R = Integer.parseInt(st.nextToken());
		// 가로 길이
		int C = Integer.parseInt(st.nextToken());

		// 판
		int[][] map = new int[R][C];
		// 지난 시간 및 남은 치즈의 개수
		int[] ans = new int[2];
		for (int rc = 0; rc < R; rc++) {
			st = new StringTokenizer(br.readLine());
			for (int cc = 0; cc < C; cc++) {
				int inp = Integer.parseInt(st.nextToken());
				map[rc][cc] = inp;
				// 치즈 개수 카운트
				if (inp == 1) {
					ans[1]++;
				}
			}
		}

		// 한 시간전 치즈의 개수
		int ra = ans[1];
		while (true) {
			solve(map, R, C, 0, 0, ans);
			ans[0]++;
			if (ans[1] <= 0) {
				break;
			}
			ra = ans[1];
		}

		System.out.println(ans[0]);
		System.out.println(ra);
	}

	public static void solve(int[][] map, int R, int C, int r, int c, int[] ans) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
				continue;
			}

			// 이동한 곳이 치즈가 아니고 지나왔던 곳이 아니라면
			if (map[nr][nc] != 1 && map[nr][nc] != -(ans[0] + 1)) {
				map[nr][nc] = -(ans[0] + 1);
				solve(map, R, C, nr, nc, ans);
			}

			if (map[nr][nc] == 1) {
				map[nr][nc] = -(ans[0] + 1);
				ans[1]--;
			}
		}
	}
}

package Algorithm.BAEKJOON.GOLD_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1194_000000000000000 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		// 세로 길이
		int N = Integer.parseInt(st.nextToken());
		// 가로 길이
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		Point minsik = null;
		for (int nc = 0; nc < N; nc++) {
			String r = br.readLine();
			for (int mc = 0; mc < M; mc++) {
				char inp = r.charAt(mc);
				map[nc][mc] = inp;
				if (inp == '0') {
					minsik = new Point(nc, mc);
				}
			}
		}
		
		solve(N, M, map, minsik, 0, new boolean[6]);
	}

	public static void solve(int N, int M, char[][] map, Point cur, int wc, boolean[] keys) {
		if (map[cur.i][cur.j] == '1') {
			System.out.println(wc);
			return;
		} else if ('a' <= map[cur.i][cur.j] && map[cur.i][cur.j] <= 'f') {
			keys[map[cur.i][cur.j] - 'a'] = true;
			map[cur.i][cur.j] = '.';
		} else if ('A' <= map[cur.i][cur.j] && map[cur.i][cur.j] <= 'F') {
			if (keys[map[cur.i][cur.j] - 'A']) {
				map[cur.i][cur.j] = '.';
			}else {
				return;
			}
		}

		int[] di = { -1, 1, 0, 0 };
		int[] dj = { 0, 0, -1, 1 };

		for (int dir = 0; dir < 4; dir++) {
			int ni = cur.i + di[dir];
			int nj = cur.j + dj[dir];

			if (ni < 0 || ni >= N || nj < 0 || nj >= M) {
				continue;
			}

			solve(N, M, map, new Point(ni, nj), wc + 1, keys.clone());
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

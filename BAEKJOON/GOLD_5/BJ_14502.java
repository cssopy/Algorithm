package Algorithm.BAEKJOON.GOLD_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구소
// https://www.acmicpc.net/problem/14502
public class BJ_14502 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 세로 크기
		int N = Integer.parseInt(st.nextToken());
		// 가로 크기
		int M = Integer.parseInt(st.nextToken());

		// 바이러스 위치
		List<Point> bs = new ArrayList<>();
		// 안전영역 개수
		int sa = 0;
		int[][] map = new int[N][M];
		for (int nc = 0; nc < N; nc++) {
			st = new StringTokenizer(br.readLine());
			for (int mc = 0; mc < M; mc++) {
				int inp = Integer.parseInt(st.nextToken());
				map[nc][mc] = inp;
				if (inp == 2) {
					bs.add(new Point(nc, mc));
				} else if (inp == 0) {
					sa++;
				}
			}
		}

		int[] ans = new int[1];
		solve(0, 0, map, N, M, bs.toArray(new Point[bs.size()]), sa, ans);
		
		System.out.println(ans[0]);
	}

	public static void solve(int cnt, int s, int[][] map, int N, int M, Point[] bs, int sa, int[] ans) {
		if (cnt == 3) {
			int fsa = countSA(map, N, M, bs, sa);
			ans[0] = Math.max(ans[0], fsa);
			return;
		}

		for (int i = s; i < N * M; i++) {
			int ni = i / M;
			int nj = i % M;

			if (map[ni][nj] == 0) {
				map[ni][nj] = 1;
				solve(cnt + 1, i + 1, map, N, M, bs, sa, ans);
				map[ni][nj] = 0;
			}
		}
	}

	private static int countSA(int[][] map, int N, int M, Point[] bs, int sa) {
		boolean[][] isVisited = new boolean[N][M];

		Queue<Point> que = new LinkedList<>();
		for (int i = 0; i < bs.length; i++) {
			que.offer(bs[i]);
		}

		int[] di = { -1, 1, 0, 0 };
		int[] dj = { 0, 0, -1, 1 };

		int cnt = 0;
		while (!que.isEmpty()) {
			Point cur = que.poll();

			if (map[cur.i][cur.j] == 0 && !isVisited[cur.i][cur.j]) {
				cnt++;
			}
			isVisited[cur.i][cur.j] = true;

			for (int dir = 0; dir < 4; dir++) {
				int ni = cur.i + di[dir];
				int nj = cur.j + dj[dir];

				if (ni < 0 || nj < 0 || ni >= N || nj >= M) {
					continue;
				}

				if (map[ni][nj] == 0 && !isVisited[ni][nj]) {
					que.offer(new Point(ni, nj));
				}
			}
		}

		return sa - cnt - 3;
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

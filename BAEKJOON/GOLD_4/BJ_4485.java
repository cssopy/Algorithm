package Algorithm.BAEKJOON.GOLD_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 녹색 옷 입은 애가 젤다지? (골드 4)
// NxN모양의 동굴에서 (0,0)에서 (N-1,N-1)까지 최소한의 도둑루피를 얻는 경로를 구하는 문제
// https://www.acmicpc.net/problem/4485
public class BJ_4485 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int pn = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}

			int[][] map = new int[N][N];
			int[][] dis = new int[N][N];
			for (int nc = 0; nc < N; nc++) {
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < N; i++) {
					map[nc][i] = Integer.parseInt(st.nextToken());
					dis[nc][i] = Integer.MAX_VALUE;
				}
			}

			int ans = solve(N, map, dis);
			sb.append("Problem " + (pn++) + ": " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

	public static int solve(int N, int[][] map, int[][] dis) {
		int[] di = { 1, -1, 0, 0 };
		int[] dj = { 0, 0, -1, 1 };

		Queue<Point> que = new PriorityQueue<>();
		que.offer(new Point(0, 0, map[0][0]));
		dis[0][0] = map[0][0];

		while (!que.isEmpty()) {
			Point cur = que.poll();
			int i = cur.i;
			int j = cur.j;
			for (int dir = 0; dir < 4; dir++) {
				int ni = i + di[dir];
				int nj = j + dj[dir];

				if (ni < 0 || ni >= N || nj < 0 || nj >= N) {
					continue;
				}

				if (dis[i][j] + map[ni][nj] < dis[ni][nj]) {
					dis[ni][nj] = dis[i][j] + map[ni][nj];
					que.offer(new Point(ni, nj, dis[ni][nj]));
				}
			}
		}

		return dis[N - 1][N - 1];
	}

	public static class Point implements Comparable<Point> {
		int i;
		int j;
		int w;

		public Point(int i, int j, int w) {
			super();
			this.i = i;
			this.j = j;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.w, o.w);
		}
	}
}
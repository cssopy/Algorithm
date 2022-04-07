package Algorithm.BAEKJOON.GOLD_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
a
// 말이 되고픈 원숭이 (골드 4)
// https://www.acmicpc.net/problem/1600
public class BJ_1600 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 원숭이가 말처럼 뛸 수 있는 횟수
		int K = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		// 격자판의 가로길이
		int W = Integer.parseInt(st.nextToken());
		// 격자판의 세로길이
		int H = Integer.parseInt(st.nextToken());

		// 격자판
		int[][] map = new int[H][W];
		// 격자판 입력
		for (int hc = 0; hc < H; hc++) {
			st = new StringTokenizer(br.readLine());
			for (int wc = 0; wc < W; wc++) {
				map[hc][wc] = Integer.parseInt(st.nextToken());
			}
		}

		int[] ans = new int[1];
		ans[0] = Integer.MAX_VALUE;
		solve(map, K, H, W, new boolean[H][W], 0, ans);
		if (ans[0] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans[0]);
		}
	}

	public static void solve(int[][] map, int K, int H, int W, boolean[][] isVisited, int d, int[] ans) {
		Point cur = new Point(0, 0, 0, K);

		Queue<Point> que = new LinkedList<>();
		que.offer(cur);
		isVisited[0][0] = true;

		int[] dr = { -1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1 };
		int[] dc = { 0, 0, -1, 1, -2, -1, 1, 2, 2, 1, -1, -2 };

		while (!que.isEmpty()) {
			cur = que.poll();

			if (cur.r == H - 1 && cur.c == W - 1 && cur.d >= 0) {
				ans[0] = cur.d;
				continue;
			}

			for (int dir = 0; dir < 12; dir++) {
				if (cur.k <= 0 && dir >= 4) {
					break;
				}

				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];

				if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
					continue;
				}

				if (map[nr][nc] == 0 && !isVisited[nr][nc]) {
					if (dir >= 4) {
						que.offer(new Point(nr, nc, cur.d + 1, cur.k - 1));
					} else {
						que.offer(new Point(nr, nc, cur.d + 1, cur.k));
					}
					isVisited[nr][nc] = true;
				}
			}
		}
	}
}

class Point {
	int r;
	int c;
	int d;
	int k;

	public Point(int r, int c, int d, int k) {
		super();
		this.r = r;
		this.c = c;
		this.d = d;
		this.k = k;
	}
}

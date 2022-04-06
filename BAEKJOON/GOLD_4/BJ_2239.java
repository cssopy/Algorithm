package Algorithm.BAEKJOON.GOLD_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 스도쿠
// https://www.acmicpc.net/problem/2239
public class BJ_2239 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 스도쿠 맵
		int[][] map = new int[9][9];

		List<Point> list = new ArrayList<>();
		// 맵 입력
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				int inp = Integer.parseInt(Character.toString(s.charAt(j)));
				map[i][j] = inp;
				if (inp == 0) {
					list.add(new Point(i, j));
				}
			}
		}

		boolean[] f = { false };
		solve(0, list.size(), map, list.toArray(new Point[list.size()]), f, sb);

		System.out.println(sb.toString());
	}

	public static void solve(int cnt, int ls, int[][] map, Point[] list, boolean[] f, StringBuilder sb) {
		if (cnt == ls) {
			if (f[0] == false) {
				f[0] = true;
			}

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}

			return;
		}

		if (f[0] == true) {
			return;
		}

		Point cur = list[cnt];

		for (int i = 1; i <= 9; i++) {
			// 맵 한칸 초기화
			map[cur.i][cur.j] = i;

			// 행 검증
			if (checkRow(map, cur.i) == false) {
				continue;
			}

			// 열 검증
			if (checkCol(map, cur.j) == false) {
				continue;
			}

			// 구역 검증
			if (checkArea(map, cur) == false) {
				continue;
			}

			solve(cnt + 1, ls, map, list, f, sb);
		}
		map[cur.i][cur.j] = 0;
	}

	public static boolean checkArea(int[][] map, Point cur) {
		int ti = 0, tj = 0;

		if (cur.i <= 2) {
			ti = 0;
		} else if (cur.i <= 5) {
			ti = 3;
		} else {
			ti = 6;
		}

		if (cur.j <= 2) {
			tj = 0;
		} else if (cur.j <= 5) {
			tj = 3;
		} else {
			tj = 6;
		}

		boolean[] isSel = new boolean[10];

		for (int i = ti; i < ti + 3; i++) {
			for (int j = tj; j < tj + 3; j++) {
				if (map[i][j] == 0) {
					continue;
				}

				if (isSel[map[i][j]]) {
					return false;
				} else {
					isSel[map[i][j]] = true;
				}
			}
		}

		return true;
	}

	public static boolean checkRow(int[][] map, int i) {
		boolean[] isSel = new boolean[10];

		for (int k = 0; k < 9; k++) {
			if (map[i][k] == 0) {
				continue;
			}

			if (isSel[map[i][k]]) {
				return false;
			} else {
				isSel[map[i][k]] = true;
			}
		}
		return true;
	}

	public static boolean checkCol(int[][] map, int j) {
		boolean[] isSel = new boolean[10];

		for (int k = 0; k < 9; k++) {
			if (map[k][j] == 0) {
				continue;
			}

			if (isSel[map[k][j]]) {
				return false;
			} else {
				isSel[map[k][j]] = true;
			}
		}
		return true;
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

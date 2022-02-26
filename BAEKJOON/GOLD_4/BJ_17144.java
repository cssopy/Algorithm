package Algorithm.BAEKJOON.GOLD_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 미세먼지 안녕! (골드 4)
// 방안에 공기청정기와 미세먼지가 있을때 T시간이 지난후의 미세먼지양을 구하는 문제
// https://www.acmicpc.net/problem/17144
public class BJ_17144 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 세로 길이(행)
		int R = Integer.parseInt(st.nextToken());
		// 가로 길이(열)
		int C = Integer.parseInt(st.nextToken());
		// 흐르는 시간(초)
		int T = Integer.parseInt(st.nextToken());

		// 방안의 정보
		int[][] map = new int[R][C];
		// 공기청정기 정보
		List<AirCleaner> acs = new ArrayList<>();
		// 먼지위치 및 양 정보
		Queue<Dust> ds = new LinkedList<>();
		// 총 먼지의 양
//		int ta_dust = 0;
		// 방안의 정보 입력
		for (int rc = 0; rc < R; rc++) {
			st = new StringTokenizer(br.readLine());
			for (int cc = 0; cc < C; cc++) {
				int inp = Integer.parseInt(st.nextToken());
				if (inp > 0) {
					ds.offer(new Dust(rc, cc, inp));
//					ta_dust += inp;
				} else if (inp == -1) {
					acs.add(new AirCleaner(rc, cc, inp));
				}
				map[rc][cc] = inp;
			}
		}

		map = solve(map, R, C, T, acs, ds);

		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] >= 1) {
					ans += map[i][j];
				}
			}
		}
		System.out.println(ans);
	}

	public static class AirCleaner {
		int r;
		int c;
		int v;

		public AirCleaner(int r, int c, int v) {
			super();
			this.r = r;
			this.c = c;
			this.v = v;
		}
	}

	public static class Dust {
		int r;
		int c;
		int amount;
		int dc;

		public Dust(int r, int c, int amount) {
			super();
			this.r = r;
			this.c = c;
			this.amount = amount;
		}
	}

	public static int[][] solve(int[][] map, int R, int C, int T, List<AirCleaner> acs, Queue<Dust> ds) {
		int[] di = { -1, 0, 1, 0 };
		int[] dj = { 0, 1, 0, -1 };

		for (int t = 0; t < T; t++) {
			int[][] nmap = new int[R][C];
			Queue<Dust> nds = new LinkedList<>();

			while (!ds.isEmpty()) {
				Dust d = ds.poll();

				if (d.amount >= 5) {
					// 갈 수 있는 방향 체크
					int dc = 0;
					for (int dir = 0; dir < 4; dir++) {
						int ni = d.r + di[dir];
						int nj = d.c + dj[dir];

						if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] != -1) {
							dc++;
						}
					}

					// 남겨진 양
					int left = map[d.r][d.c] - map[d.r][d.c] / 5 * dc;
					// 확산될 양
					int diffu = map[d.r][d.c] / 5;
					// 확산
					nmap[d.r][d.c] = nmap[d.r][d.c] + left;
					for (int dir = 0; dir < 4; dir++) {
						int ni = d.r + di[dir];
						int nj = d.c + dj[dir];

						if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] != -1) {
							nmap[ni][nj] = nmap[ni][nj] + diffu;
						}
					}
				} else {
					nmap[d.r][d.c] = nmap[d.r][d.c] + d.amount;
				}
			}
			map = nmap;
			for (int i = 0; i < acs.size(); i++) {
				map[acs.get(i).r][acs.get(i).c] = acs.get(i).v;
				rota(map, acs.get(i).r, acs.get(i).c, i);
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] >= 1) {
						nds.offer(new Dust(i, j, map[i][j]));
					}
				}
			}
			ds = nds;
		}
		return map;
	}

	// 시계 또는 반시계 방향으로 돌리는 함수
	public static void rota(int[][] map, int i, int j, int t) {
		int[] di = { -1, 0, 1, 0 };
		int[] dj = { 0, 1, 0, -1 };
		int R = map.length;
		int C = map[0].length;

		if (t == 0) {
			int ci = i - 1;
			int cj = j;
			int dir = 0;

			while (true) {
				int ni = ci + di[dir];
				int nj = cj + dj[dir];

				if (ni < 0 || ni > i || nj < 0 || nj >= C) {
					dir = (dir + 1) % 4;
					continue;
				}

				if (map[ni][nj] != -1) {
					map[ci][cj] = map[ni][nj];
				} else {
					map[ci][cj] = 0;
					break;
				}

				ci = ni;
				cj = nj;
			}
		} else {
			int ci = i + 1;
			int cj = j;
			int dir = 2;

			while (true) {
				int ni = ci + di[dir];
				int nj = cj + dj[dir];

				if (ni < i || ni >= R || nj < 0 || nj >= C) {
					dir = (dir - 1 + 4) % 4;
					continue;
				}

				if (map[ni][nj] != -1) {
					map[ci][cj] = map[ni][nj];
				} else {
					map[ci][cj] = 0;
					break;
				}

				ci = ni;
				cj = nj;
			}
		}
	}
}

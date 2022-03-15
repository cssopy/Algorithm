package Algorithm.BAEKJOON.GOLD_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 적록색약 (골드 5)
// 색별로 구역이 나눠진 그림이 있을때 적록색약이 아닌 사람과 적록색약인 사람이 보는 구역의 개수를 구하는 문제
// https://www.acmicpc.net/problem/10026
public class BJ_10026 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 그림의 크기
		int N = Integer.parseInt(br.readLine());
		// 그림
		char[][] map = new char[N][N];
		// 그림 입력
		for (int nc = 0; nc < N; nc++) {
			String inp = br.readLine();
			for (int i = 0; i < N; i++) {
				map[nc][i] = inp.charAt(i);
			}
		}

		// 영역의 개수
		int[] an = { 0, 0 };
		// 적록색약인 사람과 아닌 사람이 인식할 구역
		int[][][] area = new int[2][N][N];
		// 0,0 좌표부터 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 값이 있는 곳은 영역으로 인식됐으니 넘기고 0인 값의 위치부터 탐색 (적록색약X)
				if (area[0][i][j] == 0) {
					an[0]++;
					solve1(map, i, j, N, area[0], an[0]);
				}
				// 값이 있는 곳은 영역으로 인식됐으니 넘기고 0인 값의 위치부터 탐색 (적록색약O)
				if (area[1][i][j] == 0) {
					an[1]++;
					solve2(map, i, j, N, area[1], an[1]);
				}
			}
		}

		System.out.println(an[0] + " " + an[1]);
	}

	public static void solve1(char[][] map, int i, int j, int N, int[][] area, int an) {
		int[] di = { -1, 0, 1, 0 };
		int[] dj = { 0, 1, 0, -1 };

		for (int dir = 0; dir < 4; dir++) {
			int ni = i + di[dir];
			int nj = j + dj[dir];
			if (ni >= 0 && ni < N && nj >= 0 && nj < N && map[i][j] == map[ni][nj] && area[ni][nj] == 0) {
				area[ni][nj] = an;
				solve1(map, ni, nj, N, area, an);
			}
		}
	}

	public static void solve2(char[][] map, int i, int j, int N, int[][] area, int an) {
		int[] di = { -1, 0, 1, 0 };
		int[] dj = { 0, 1, 0, -1 };

		for (int dir = 0; dir < 4; dir++) {
			int ni = i + di[dir];
			int nj = j + dj[dir];
			if (ni >= 0 && ni < N && nj >= 0 && nj < N && area[ni][nj] == 0) {
				if (((map[i][j] == 'R' || map[i][j] == 'G') && (map[ni][nj] == 'R' || map[ni][nj] == 'G'))
						|| (map[i][j] == map[ni][nj])) {
					area[ni][nj] = an;
					solve2(map, ni, nj, N, area, an);
				}
			}
		}
	}
}

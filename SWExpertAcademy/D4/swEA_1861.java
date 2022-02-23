package Algorithm.SWExpertAcademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 정사각형 방 (D4)
// 어떤 조건들에 의해 방을 이동할수 있을때 최대로 많은 방을 지날 수 있는 최초 시작위치와 지난 방의 개수를 구하는 문제
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc
public class swEA_1861 {
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };
	static int N;
	static Set<Integer> set = new HashSet<>();
	static int max = 0;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			ans = N * N;
			for (int nc = 0; nc < N; nc++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					map[nc][k] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					swea_1861(map, i, j, 1, map[i][j]);
					set.clear();
				}
			}

			sb.append("#" + (tc + 1) + " " + ans + " " + max + "\n");
			max = 0;
		}

		System.out.println(sb.toString());
	}

	public static void swea_1861(int[][] map, int y, int x, int len, int start) {
		set.add(map[y][x]);

		for (int dir = 0; dir < 4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N) && Math.abs(map[y][x] - map[ny][nx]) == 1
					&& !set.contains(map[ny][nx])) {
				swea_1861(map, ny, nx, len + 1, start);
				return;
			}
		}

		if (len > max) {
			max = len;
			ans = start;
		} else if (len == max) {
			ans = Math.min(start, ans);
		}
	}
}

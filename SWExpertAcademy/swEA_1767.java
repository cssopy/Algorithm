package Algorithm.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 프로세서 연결하기
// 프로세서를 최대한 연결할때 전선의 길이의 합을 구하는 문제
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf
public class swEA_1767 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			// 배열의 크기
			int N = Integer.parseInt(br.readLine());
			// 배열
			int[][] map = new int[N][N];
			// core의 위치를 저장할 배열
			List<Point> core_pos = new ArrayList<Point>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 만약
					if (map[i][j] == 1 && ((i != 0 && i != N - 1) && (j != 0 && j != N - 1))) {
						core_pos.add(new Point(i, j));
					}
				}
			}

			// 전선의 길이
			int[] ans = new int[1];
			solve(map.clone(), 0, N, core_pos.toArray(new Point[core_pos.size()]), 0, 0);
		}
	}

	// 위치를 나타낼 클래스
	public static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

	public static void solve(int[][] map, int cnt, int N, Point[] core_pos, int c, int len) {
		if (cnt == N) {
			System.out.println("도달한거있니?");
			return;
		}

//		if (N - cnt - 1 < N - c) {
//			return;
//		}

		int[] di = { -1, 1, 0, 0 };
		int[] dj = { 0, 0, -1, 1 };

		for (int dir = 0; dir < 4; dir++) {
			if (!isGoable(map, core_pos[cnt], di[dir], dj[dir], N)) {
				continue;
			}

			int wire = countWire(map, core_pos[cnt], di[dir], dj[dir], N);
			solve(map.clone(), cnt + 1, N, core_pos.clone(), c + 1, len + wire);
			solve(map.clone(), cnt + 1, N, core_pos.clone(), c, len);
		}
	}

	// 코어의 위치를 기준으로 어떤 방향을 향해 맵 끝까지 도달가능한지 체크하는 함수
	public static boolean isGoable(int[][] map, Point cur_pos, int di, int dj, int N) {
		System.out.println("isGoable 시작");
		while (true) {
			cur_pos.i += di;
			cur_pos.j += dj;

			// 맵 끝에 도달전에 전선이나 코어를 만난다면 false 리턴
			if (map[cur_pos.i][cur_pos.j] != 0) {
				return false;
			}

			// 무사히 맵 끝에 도달했다면 true 리턴
			if ((cur_pos.i == 0 || cur_pos.i == N - 1) || (cur_pos.j == 0 || cur_pos.j == N - 1)) {
				System.out.println("isGoable 종료");
				return true;
			}
		}
	}

	// 코어의 위치를 기준으로 어떤 방향을 향해 설치해야할 전선의 수를 구하는 함수
	public static int countWire(int[][] map, Point cur_pos, int di, int dj, int N) {
		System.out.println("countWire 시작");
		int wire = 0;
		while (true) {
			cur_pos.i += di;
			cur_pos.j += dj;

			wire++;

			// 맵 끝에 도달했다면 설치해야할 전선 수 리턴
			if ((cur_pos.i == 0 || cur_pos.i == N - 1) || (cur_pos.j == 0 || cur_pos.j == N - 1)) {
				System.out.println("countWire 종료");
				return wire;
			}
		}
	}
}

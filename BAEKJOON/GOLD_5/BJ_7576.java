package Algorithm.BAEKJOON.GOLD_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토 (골드 5)
// 상자에 있는 토마토가 모두 익을때까지의 최소 날짜를 구하는 문제
// https://www.acmicpc.net/problem/7576
public class BJ_7576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 상자의 가로길이
		int N = Integer.parseInt(st.nextToken());
		// 상자의 세로길이
		int M = Integer.parseInt(st.nextToken());

		// 안익은 과일 수
		int[] unripe = new int[1];
		// 박스
		int[][] box = new int[M][N];
		// 익은 과일들의 위치정보
		Queue<Point> fs = new LinkedList<>();

		// 과일 상자 상태 입력
		for (int mc = 0; mc < M; mc++) {
			st = new StringTokenizer(br.readLine());
			for (int nc = 0; nc < N; nc++) {
				int inp = Integer.parseInt(st.nextToken());

				if (inp == 0) {
					unripe[0]++;
				} else if (inp == 1) {
					fs.offer(new Point(mc, nc, 0));
				}

				box[mc][nc] = inp;
			}
		}

		if (unripe[0] == 0) {
			System.out.println(0);
		} else {
			int ans = solve(box, N, M, unripe, fs);
			if (unripe[0] == 0) {
				System.out.println(ans);
			} else {
				System.out.println(-1);
			}
		}
	}

	// 익은 과일의 위치와 몇일에 익은지 저장할 클래스
	public static class Point {
		// 행
		int r;
		// 열
		int c;
		// 익은 날짜
		int d;

		public Point(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static int solve(int[][] box, int N, int M, int[] unripe, Queue<Point> fs) {
		int[] di = { -1, 0, 1, 0 };
		int[] dj = { 0, 1, 0, -1 };

		// 지난 일수
		int ans = 0;
		// 큐에 익은 과일이 없을때까지
		while (!fs.isEmpty()) {
			// 큐에서 익은 과일 하나 꺼내기
			Point f = fs.poll();
			// 그 과일의 익을일수의 최대값을 ans에 초기화
			ans = Math.max(ans, f.d);

			// 꺼낸 과일을 기준으로 네방향 검사
			for (int dir = 0; dir < 4; dir++) {
				int ni = f.r + di[dir];
				int nj = f.c + dj[dir];

				// 좌표가 상자를 벗어나지않고 해당 좌표의 과일이 아직 안익었다면 그 과일을 익은 처리를 해주고 이전 과일의 익은일수에 +1을 해서 큐에 삽입
				if (ni >= 0 && ni < M && nj >= 0 && nj < N && box[ni][nj] == 0) {
					fs.offer(new Point(ni, nj, f.d + 1));
					box[ni][nj] = 1;
					// 안익은 과일수 감소
					unripe[0]--;
				}
			}
		}
		return ans;
	}
}

package Algorithm.SWExpertAcademy.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최적 경로 (D5)
// 김대리가 회사에서 출발하여 N명의 고객을 전부 방문하고 집으로 돌아오는 경로 중 가장 짧은 경로를 구하는 문제
// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5M8LAaEvwDFASv&contestProbId=AV15OZ4qAPICFAYD&probBoxId=AX8F1Cr62A8DFARO+&type=PROBLEM&problemBoxTitle=02%EC%9B%94+17%EC%9D%BC&problemBoxCnt=++1+
public class swEA_1247 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			// 고객의 수
			int N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			// 위치를 저장할 배열
			Point[] ps = new Point[N + 2];
			for (int i = 0; i < N + 2; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				ps[i] = new Point(x, y);
			}

			// 거리정보 map
			int[][] map = new int[N + 2][N + 2];
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					map[i][j] = ps[i].getDsts(ps[j]);
				}
			}

			int[] ans = { Integer.MAX_VALUE };
			// 방문한 지점인지 체크하는 배열
			boolean[] isVisited = new boolean[N + 2];
			// 회사는 처음부터 방문한 상태
			isVisited[0] = true;
			solve(map, isVisited, N + 2, 0, 1, 0, ans);

			sb.append("#" + (tc + 1) + " " + ans[0] + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void solve(int[][] map, boolean[] isVisited, int N, int crt_pos, int cnt, int dsts, int[] ans) {
		// 집에 도착했을 경우
		if (crt_pos == 1) {
			// 지점을 다 방문했다면 현재까지 온 거리가 더 작으면 ans갱신
			if (cnt == N) {
				ans[0] = Math.min(ans[0], dsts);
			}
			// 지점을 다 방문했든 못했든 return
			return;
		}

		// 순열 + 백트래킹
		for (int i = 0; i < N; i++) {
			if (!isVisited[i] && dsts + map[crt_pos][i] < ans[0]) {
				isVisited[i] = true;
				solve(map, isVisited, N, i, cnt + 1, dsts + map[crt_pos][i], ans);
				isVisited[i] = false;
			}
		}
	}

	// 각 장소들을 표현할 클래스
	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getDsts(Point o) {
			return (Math.abs(this.x - o.x) + Math.abs(this.y - o.y));
		}
	}
}

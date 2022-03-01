package Algorithm.ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사각지대 2
// 주어진 맵에서 경비원이 동서남북 네방향으로만 감시할때 생기는 사각지대의 수를 구하는 문제
public class 사각지대2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int[] di = { -1, 0, 1, 0 };
		int[] dj = { 0, 1, 0, -1 };

		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			// 지도(map)의 크기
			int N = Integer.parseInt(br.readLine());
			// 지도
			int[][] map = new int[N][N];
			// 경비원 위치
			int gi = 0, gj = 0;
			// 빈 공간의 개수
			int zc = 0;
			// 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int inp = Integer.parseInt(st.nextToken());
					if (inp == 2) {	// 경비원 위치 저장
						gi = i;
						gj = j;
					} else if (inp == 0) { // 전체 통로의 칸수 저장
						zc++;
					}
					map[i][j] = inp;
				}
			}

			for (int dir = 0; dir < 4; dir++) {
				// 경비원 위치부터 시작
				int ni = gi;
				int nj = gj;

				// 한 방향으로 한칸 씩 이동하여 벽을 만나거나 맵을 벗어날때까지 탐색
				while (true) {
					// 해당 방향으로 한칸 이동
					ni += di[dir];
					nj += dj[dir];

					// 이동한 곳이 맵 밖이거나 벽이면 break
					if (ni < 0 || ni >= N || nj < 0 || nj >= N || map[ni][nj] == 1) {
						break;
					}

					// 이동한 곳이 맵 안쪽 통로라면 이동한 곳 체크하고 전체 빈공간의 개수에서 하나 뺌
					map[ni][nj] = 1;
					zc--;
				}
			}

			sb.append("#" + (tc + 1) + " " + zc + "\n");
		}
		System.out.println(sb.toString());
	}
}

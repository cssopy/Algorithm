package Algorithm.JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 해밀턴 순환회로
// 모든 정점을 들러야 할때 최소의 비용으로 도는 방법
// http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=954&sca=99&sfl=wr_hit&stx=1681
public class JO_1681 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 정점 개수
		int N = Integer.parseInt(br.readLine());
		// 인접 행렬
		int[][] adjMat = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adjMat[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] min = { Integer.MAX_VALUE };
		// 정점을 방문했는지 체크할 배열
		boolean[] isVisited = new boolean[N];
		solve(0, 0, N, adjMat, isVisited, 0, min);

		System.out.println(min[0]);
	}

	public static void solve(int cnt, int current, int N, int[][] adjMat, boolean[] isVisited, int sum, int[] min) {
		// 정점을 방문했을때 여태 나온 최저경로보다 크다면 더이상 진행할 이유가 없음
		if (sum > min[0]) {
			return;
		}

		// 회사를 제외하고 모든 정점을 돌았다면 종료
		if (cnt == N - 1) {
			// 마지막 정점에서 회사로 바로오는 경로가 없을 수 있으니 그 경로가 존재할때만 min 재초기화
			if (adjMat[current][0] != 0) {
				min[0] = Math.min(min[0], sum + adjMat[current][0]);
			}
			return;
		}

		// 회사를 제외하고 정점을 도는데 순서가 의미가 있으니 i는 1부터 순열로 풀이
		for (int i = 1; i < N; i++) {
			// i번 정점이 여태 방문하지 않았고 가는길도 있어야 재귀호출
			if (!isVisited[i] && adjMat[current][i] != 0) {
				isVisited[i] = true;
				solve(cnt + 1, i, N, adjMat, isVisited, sum + adjMat[current][i], min);
				isVisited[i] = false;
			}
		}
	}
}

package Algorithm.SWExpertAcademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Contact (D4)
// 여러 사람들의 연락망을 표현한 단방향 그래프에서 시작되는 사람을 지정했을때 연락을 받게 되는 사람중 가장 번호가 큰 사람을 구하는 문제
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD
public class swEA_1238 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			// 데이터의 길이
			int dl = Integer.parseInt(st.nextToken());
			// 시작점
			int start = Integer.parseInt(st.nextToken());

			// 인접 행렬
			int N = 100;
			int[][] adjMat = new int[N + 1][N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < dl / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjMat[from][to] = 1;
			}

			// 매번 바깥쪽의 정점들의 정보를 저장할 리스트
			List<int[]> list = new ArrayList<>();
			bfs(adjMat, N, start, new boolean[N + 1], list);

			// 가장 마지막 바깥쪽 정점들 중 최대값 찾기
			int ans = 0;
			for (int[] o : list) {
				ans = Math.max(o[1], ans);
			}
			
			sb.append("#" + (tc + 1) + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void bfs(int[][] adjMat, int N, int start, boolean[] isVisited, List<int[]> list) {
		Queue<int[]> que = new LinkedList<>();

		// 시작 정점의 영역값
		int skin = 0;
		// 시작 정점의 영역값과 값을 큐에 넣음
		que.offer(new int[] { skin, start });
		// 시작 정점은 처음부터 방문했다고 처리
		isVisited[start] = true;
		// list에 시작 정점의 영역값과 값을 넣음
		list.add(new int[] { skin, start });

		while (!que.isEmpty()) {
			// 큐가 완전 빌때까지 큐에서 하나씩 꺼냄
			int[] current = que.poll();
			// 꺼낸 정점이 현재 list에 있는 정점보다 바깥이라면 list 초기화
			if (list.get(0)[0] < current[0]) {
				list.clear();
			}
			// 꺼낸 정점의 영역값과 값을 list에 추가
			list.add(current);

			// 해당 정점의 다음 정점들중 방문하지 않은 정점들만 큐에 삽입하고 방문했다고 처리
			for (int i = 1; i <= N; i++) {
				if (!isVisited[i] && adjMat[current[1]][i] != 0) {
					que.offer(new int[] { current[0] + 1, i });
					isVisited[i] = true;
				}
			}
		}
	}
}
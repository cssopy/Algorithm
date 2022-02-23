package Algorithm.BAEKJOON.SIVER_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// DFS와 BFS (실버 2)
// 그래프 정보를 입력받아 해당 그래프를 DFS와 BFS로 탐색한 결과를 출력하는 문제
// https://www.acmicpc.net/problem/1260
public class BJ_1260_array {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		// 정점의 개수
		int N = Integer.parseInt(st.nextToken());
		// 간선의 개수
		int M = Integer.parseInt(st.nextToken());
		// 탐색을 시작할 정점 번호
		int V = Integer.parseInt(st.nextToken());

		// 그래프 정보 배열
		int[][] adjMat = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMat[from][to] = adjMat[to][from] = 1;
		}

		dfs(adjMat, N, V, new boolean[N + 1], sb);
		sb.append("\n");
		bfs(adjMat, N, V, new boolean[N + 1], sb);
		sb.append("\n");
		
		System.out.println(sb.toString());
	}

	public static void bfs(int[][] adjMat, int N, int V, boolean[] isVisited, StringBuilder sb) {
		Queue<Integer> que = new LinkedList<Integer>();

		que.offer(V);
		isVisited[V] = true;

		while (!que.isEmpty()) {
			int current = que.poll();
			sb.append(current + " ");

			for (int i = 1; i <= N; i++) {
				if (!isVisited[i] && adjMat[current][i] != 0) {
					que.offer(i);
					isVisited[i] = true;
				}
			}
		}
	}

	public static void dfs(int[][] adjMat, int N, int V, boolean[] isVisited, StringBuilder sb) {
		isVisited[V] = true;
		sb.append(V + " ");

		for (int i = 1; i <= N; i++) {
			if (!isVisited[i] && adjMat[V][i] != 0) {
				dfs(adjMat, N, i, isVisited, sb);
			}
		}
	}
}

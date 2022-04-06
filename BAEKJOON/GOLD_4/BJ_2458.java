package Algorithm.BAEKJOON.GOLD_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 키 순서 (골드 4)
// https://www.acmicpc.net/problem/2458
public class BJ_2458 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 학생의 수(정점의 수)
		int N = Integer.parseInt(st.nextToken());
		// 키를 비교한 횟수(간선의 수)
		int M = Integer.parseInt(st.nextToken());

		// 인접 행렬
		boolean[][] mat_A = new boolean[N][N];
		boolean[][] mat_DE = new boolean[N][N];
		
		for (int mc = 0; mc < M; mc++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;

			mat_A[from][to] = true;
			mat_DE[to][from] = true;
		}

		// 플로이드 워샬
		for (int e = 0; e < N; e++) {
			for (int from = 0; from < N; from++) {
				if (from == e) {
					continue;
				}
				for (int to = 0; to < N; to++) {
					if (to == from || to == e) {
						continue;
					}

					if (mat_A[from][e] && mat_A[e][to]) {
						mat_A[from][to] = true;
					}
					if (mat_DE[from][e] && mat_DE[e][to]) {
						mat_DE[from][to] = true;
					}
				}
			}
		}

		int ans = 0;
		first: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ((!mat_A[i][j] && !mat_DE[i][j]) && (i != j)) {
					continue first;
				}
			}
			ans++;
		}

		System.out.println(ans);
	}
}
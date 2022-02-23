package Algorithm.BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (4) (실버 3)
// N개의 숫자중 M개의 숫자를 고르는 경우의 수 구하는 문제(중복 조합)
// https://www.acmicpc.net/problem/15652
public class BJ_15652 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		solve(0, 1, N, M, new int[M], sb);
		
		System.out.println(sb.toString());
	}

	public static void solve(int cnt, int s, int N, int M, int[] ans, StringBuilder sb) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = s; i <= N; i++) {
			ans[cnt] = i;
			solve(cnt + 1, i, N, M, ans, sb);
		}
	}
}

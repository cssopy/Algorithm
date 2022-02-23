package Algorithm.BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (3) (실버 3)
// N개의 숫자중 M개의 숫자를 고르는 문제(중복 순열)
// https://www.acmicpc.net/problem/15651
public class BJ_15651 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		solve(0, N, M, new int[M], sb);

		System.out.println(sb.toString());
	}

	public static void solve(int cnt, int N, int M, int[] ans, StringBuilder sb) {
		// M개의 숫자를 뽑았다면 종료
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}

		// 1부터 N까지 cnt자리에 하나 뽑고 cnt+1자리에서도 중복 등을 고려하지 않고 또 뽑음
		for (int i = 1; i <= N; i++) {
			ans[cnt] = i;
			solve(cnt + 1, N, M, ans, sb);
		}
	}
}

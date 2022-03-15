package Algorithm.BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (5) (실버 3)
// N개의 수에서 M개를 고르는 방법 중 순서의 의미가 있는 순열 구하는 문제(순열+사전순)
// https://www.acmicpc.net/problem/15654
public class BJ_15654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] inps = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inps[i] = Integer.parseInt(st.nextToken());
		}

		// 사전순의 조건을 만족시키기 위해 정렬
		Arrays.sort(inps);

		solve(0, N, M, inps, new int[M], new boolean[N], sb);
		
		System.out.println(sb.toString());
	}

	public static void solve(int cnt, int N, int M, int[] inps, int[] result, boolean[] isSel, StringBuilder sb) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			// 이미 선택된 숫자라면 넘어가기
			if (isSel[i])	continue;
			result[cnt] = inps[i];
			isSel[i] = true;
			solve(cnt + 1, N, M, inps, result, isSel, sb);
			isSel[i] = false;
		}
	}
}

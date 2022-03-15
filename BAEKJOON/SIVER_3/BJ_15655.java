package Algorithm.BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (6) (실버 3)
// N개의 수에서 M개를 고르는 모든 수열을 구하는 문제(오름차순이 적용된 조합)
// https://www.acmicpc.net/problem/15655
public class BJ_15655 {
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

		Arrays.sort(inps);
		solve(0, 0, N, M, inps, "", sb);
//		solve(0, 0, N, M, inps, new int[M], sb);

		System.out.println(sb.toString());
	}

	public static void solve(int cnt, int s, int N, int M, int[] inps, String str, StringBuilder sb) {
		if (cnt == M) {
			sb.append(str + "\n");
			return;
		}

		for (int i = s; i < N; i++) {
			solve(cnt + 1, i + 1, N, M, inps, str + inps[i] + " ", sb);
		}
	}

	public static void solve(int cnt, int s, int N, int M, int[] inps, int[] sels, StringBuilder sb) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(sels[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = s; i < N; i++) {
			sels[cnt] = inps[i];
			solve(cnt + 1, i + 1, N, M, inps, sels, sb);
		}
	}
}

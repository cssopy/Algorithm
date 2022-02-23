package Algorithm.BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (8) (실버 3)
// N개의 수에서 M개를 골라 만들 수 있는 모든 수열을 구하는 문제(중복 조합, 다음 숫자는 더 작은 수여야만 함)
// https://www.acmicpc.net/problem/15657
public class BJ_15657 {
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
		
		System.out.println(sb.toString());
	}

	public static void solve(int cnt, int s, int N, int M, int[] inps, String str, StringBuilder sb) {
		if (cnt == M) {
			sb.append(str + "\n");
			return;
		}

		for (int i = s; i < N; i++) {
			solve(cnt + 1, i, N, M, inps, str + inps[i] + " ", sb);
		}
	}
}

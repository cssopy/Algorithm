package Algorithm.BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (7) (실버 3)
// N개의 수에서 M개를 선택하는 모든 수열을 구하는 문제(중복을 허용하는 순열)
// https://www.acmicpc.net/problem/15656
public class BJ_15656 {
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
		solve(0, N, M, inps, "", sb);

		System.out.println(sb.toString());
	}

	public static void solve(int cnt, int N, int M, int[] inps, String str, StringBuilder sb) {
		if (cnt == M) {
			sb.append(str + "\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			solve(cnt + 1, N, M, inps, str + inps[i] + " ", sb);
		}
	}
}

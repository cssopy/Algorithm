package Algorithm.BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열 (실버 3)
// N개의 수열에서 K만큼 떨어진 수들끼리 더했을때 그 중 최대값
// https://www.acmicpc.net/problem/2559
public class BJ_2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int sum = 0;
		int[] cul_sum = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int nc = 0; nc < N; nc++) {
			sum += Integer.parseInt(st.nextToken());
			cul_sum[nc] = sum;
		}

		int ans = cul_sum[K - 1];
		for (int i = K; i < N; i++) {
			int a = cul_sum[i] - cul_sum[i-K];
			ans = Math.max(ans, a);
		}
		
		System.out.println(ans);
	}
}

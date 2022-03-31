package Algorithm.BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1로 만들기 (실버 3)
// 정수 N이 주어졌을때 어떠한 연산을 사용해 1을 만들때 그 연산의 횟수의 최솟값을 구하는 문제
// https://www.acmicpc.net/problem/1463
public class BJ_1463 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] m = new int[N + 1];
		m[0] = 0;
		m[1] = 0;

		System.out.println(solve(m, N));
	}

	public static int solve(int[] m, int N) {
		if (N >= 2) {
			for (int i = 2; i <= N; i++) {
				int a = m[i - 1] + 1;
				if (i % 2 == 0) {
					a = Math.min(a, m[i / 2] + 1);
				}
				if (i % 3 == 0) {
					a = Math.min(a, m[i / 3] + 1);
				}
				m[i] = a;
			}
		}
		return m[N];
	}
}

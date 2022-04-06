package Algorithm.BAEKJOON.SIVER_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 돌 게임 (실버 5)
// https://www.acmicpc.net/problem/9655
public class BJ_9655 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 돌의 개수
		int N = Integer.parseInt(br.readLine());

		System.out.println(solve(N));
	}

	public static String solve(int N) {
		if (N % 2 == 0) {
			return "CY";
		} else {
			return "SK";
		}
	}
}

package Algorithm.BAEKJOON.BRONZE_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 직사각형을 만드는 방법 (브론즈 2)
// n개의 정사각혀으로 만들 수 있는 직사각형의 개수를 구하는 문제
// https://www.acmicpc.net/problem/8320
public class BJ_8320 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정사각형의 개수
		int n = Integer.parseInt(br.readLine());

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n / i; j++) {
				ans++;
			}
		}

		System.out.println(ans);
	}
}

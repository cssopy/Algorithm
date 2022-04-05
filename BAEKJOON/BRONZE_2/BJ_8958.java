package Algorithm.BAEKJOON.BRONZE_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// OX퀴즈 (브론즈 2)
// https://www.acmicpc.net/problem/8958
public class BJ_8958 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String inp = br.readLine();

			int s = 0;
			int ans = 0;
			for (int i = 0; i < inp.length(); i++) {
				if (inp.charAt(i) == 'O') {
					ans += ++s;
				} else {
					s = 0;
				}
			}

			sb.append(ans + "\n");
		}
		System.out.println(sb.toString());
	}
}

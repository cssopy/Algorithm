package Algorithm.BAEKJOON.BRONZE_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 일곱 난쟁이 (브론즈 2)
// 아홉 난쟁이 중 진짜 일곱난쟁이를 찾는 문제
// https://www.acmicpc.net/problem/2309
public class BJ_2309 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] inps = new int[9];
		int inp = 0;
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			inp = Integer.parseInt(br.readLine());
			sum += inp;
			inps[i] = inp;
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sum - inps[i] - inps[j] == 100) {
					inps[i] = 0;
					inps[j] = 0;
					for (int k = 0; k < 9; k++) {
						if (inps[k] != 0) {
							System.out.println(inps[k]);
						}
					}
					return;
				}
			}
		}
	}
}

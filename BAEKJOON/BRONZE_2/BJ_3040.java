package Algorithm.BAEKJOON.BRONZE_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백설 공주와 일곱 난쟁이 (브론즈 2)
// 2309문제와 99%동일, 정렬만 안해주면 됨
// https://www.acmicpc.net/problem/3040
public class BJ_3040 {
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

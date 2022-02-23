package Algorithm.BAEKJOON.BRONZE_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 설탕 배달 (브론즈 1)
// 상근이가 Nkg 설탕을 배달해야 할때 가져가야할 봉지의 최소 개수를 구하는 문제
// https://www.acmicpc.net/problem/2839
public class BJ_2839_greedy {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 배달해야 할 무게
		int N = Integer.parseInt(br.readLine());

		// 규칙찾기
		if (N == 4 || N == 7) {
			System.out.println(-1);
		} else if (N % 5 == 0) {
			System.out.println(N / 5);
		} else if (N % 5 == 1 || N % 5 == 3) {
			System.out.println((N / 5) + 1);
		} else if (N % 5 == 2 || N % 5 == 4) {
			System.out.println((N / 5) + 2);
		}
	}
}
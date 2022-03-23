package Algorithm.BAEKJOON.BRONZE_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 나머지 (브론즈 2)
// 수 10개를 입력받아 42로 나눈 나머지 중 서로 다른 값이 몇 개 있는지 구하는 문제
// https://www.acmicpc.net/problem/3052
public class BJ_3052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 수
		int C = 10;
		// 나누는 값
		int B = 42;

		// 해당 나머지가 구해졌는지 확인할 배열
		boolean[] mods = new boolean[B];
		// 서로 다른 나머지의 수
		int ans = 0;
		for (int i = 0; i < C; i++) {
			int A = Integer.parseInt(br.readLine());
			// 나머지가 아직 한번도 나오지 않은 값이라면
			if (mods[A % B] == false) {
				// 해당 나머지는 true로 초기화하여 다음에 헤아리지 않음
				mods[A % B] = true;
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}

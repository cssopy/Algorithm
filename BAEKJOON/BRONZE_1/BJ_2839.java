package Algorithm.BAEKJOON.BRONZE_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 설탕 배달 (브론즈 1)
// 3, 5kg 담을 수 있는 봉지가 있을때 Nkg을 배달해야 하는 상근이가 챙겨야 하는 최소 개수의 봉지를 구하는 문제 
// https://www.acmicpc.net/problem/2839
public class BJ_2839 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 배달해야 할 무게
		int N = Integer.parseInt(br.readLine());
		
		int ans = (int) Double.POSITIVE_INFINITY;
		
		// 3 or 5kg 봉지로 나누어 떨어졌는지 확인하는 변수
		boolean f = true;
		// 3 or 5의 배수이면 둘 중 최소값으로 초기화
		if (N % 5 == 0) {
			ans = Math.min(ans, N / 5);
			f = !f;
		}
		if (N % 3 == 0) {
			ans = Math.min(ans, N / 3);
			f = !f;
		}

		// 5kg 봉지 개수
		int fc = 0;
		// 3kg 봉지 개수
		int thc = 0;
		// 3, 5 봉지가 적절히 쓰여야 한다면 3kg봉지로 하나씩 줄이다가 5의 배수가 됐을때 전부 5kg봉지로 구성한다면 최소개수가 됨
		while (true) {
			N = N - 3;
			thc++;

			if (N % 5 == 0) {
				fc = N / 5;
				N = 0;
			}

			if (N <= 0)	break;
		}
		if (N == 0) {
			// 3, 5kg 봉지로 딱 맞게 사용됐다면 사용된 3, 5kg 봉지합과 비교후 초기화
			ans = Math.min(ans, fc + thc);
		} else {
			// 3, 5kg 봉지로 딱 맞게 사용안됐고 3 또는 5kg 봉지로도 안 나누어 떨어졌다면
			if(f)	ans = -1;
		}
		
		System.out.println(ans);
	}
}

package Algorithm.BAEKJOON.BRONZE_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 비밀 이메일 (브론즈 1)
// 입력된 문자열에 대해 어떤 조건을 만족하는 행렬을 만들어 왼쪽부터 위에서 아래로 해당 문자열의 문자들을 넣고 위부터 왼쪽에서 오른쪽으로 읽을 때 만들어지는 암호를 구하는 문제
// https://www.acmicpc.net/problem/2999
public class BJ_2999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		String inp = br.readLine();
		// 입력된 문자열의 길이
		int N = inp.length();

		int R = 1, C = N;
		for (int i = 1;; i++) {
			if (N % i == 0) {
				if (i > N / i) {
					break;
				}
				R = i;
				C = N / R;
			}
		}

		// 정답
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 문제에서 제시하는 조건을 만족하는 가상의 mat이 있다면 mat의 위부터 아래로 왼쪽부터 오른쪽순으로 차례로 접근해서 ans에 append
				ans.append(inp.charAt(j*R+i));
			}
		}
		
		System.out.println(ans.toString());
	}
}

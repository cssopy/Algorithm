package Algorithm.BAEKJOON.BRONZE_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 크로스워드 만들기 (브론즈 2)
// 두 단어 A,B는 서로 교차해야한다. 이때 교차된 모습을 구하는 문제
// https://www.acmicpc.net/problem/2804
public class BJ_2804 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();

		// 두 단어가 교차되는 위치를 저장할 배열
		int[] ab = new int[2];
		getIdx(A, B, ab);

		for (int i = 0; i < B.length(); i++) {
			for (int j = 0; j < A.length(); j++) {
				if (j == ab[0]) {
					sb.append(B.charAt(i));
				} else if (i == ab[1]) {
					sb.append(A.charAt(j));
				} else {
					sb.append(".");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	// 두 단어가 교차되는 위치를 구하는 함수
	public static void getIdx(String A, String B, int[] ab) {
		for (int a = 0; a < A.length(); a++) {
			for (int b = 0; b < B.length(); b++) {
				if(A.charAt(a)==B.charAt(b)) {
					ab[0] = a;
					ab[1] = b;
					return;
				}
			}
		}
	}
}

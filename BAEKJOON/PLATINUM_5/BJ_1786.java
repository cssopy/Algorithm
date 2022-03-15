package Algorithm.BAEKJOON.PLATINUM_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 찾기 (플래티넘 5)
// 문자열에서 패턴이 몇번 등장하는지 인덱스는 어디인지 구하는 문제 (KMP 알고리즘 활용)
// https://www.acmicpc.net/problem/1786
public class BJ_1786 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 본문 문자열
		String text = br.readLine();
		// 패턴 문자열
		String pt = br.readLine();

		// 본문 길이
		int tlen = text.length();
		// 패턴 길이
		int plen = pt.length();

		// 부분일치테이블 만들기
		int[] pi = new int[plen];
		for (int i = 1, j = 0; i < plen; i++) {
			while (j > 0 && pt.charAt(i) != pt.charAt(j))
				j = pi[j - 1];

			if (pt.charAt(i) == pt.charAt(j))
				pi[i] = ++j;
			else
				pi[i] = 0;
		}

		int cnt = 0;
		// i : text 포인터 , j : 패턴 포인터
		for (int i = 0, j = 0; i < tlen; ++i) {
			while (j > 0 && text.charAt(i) != pt.charAt(j))
				j = pi[j - 1];

			// 두 문자가 일치하면
			if (text.charAt(i) == pt.charAt(j)) {
				// j가 pt의 마지막 인덱스라면(=pt를 찾았다면)
				if (j == plen - 1) {
					cnt++;
					sb.append(((i + 1) - plen + 1) + " ");
					j = pi[j];
				} else {
					j++;
				}
			}
		}

		System.out.println(cnt);
		System.out.println(sb);
	}
}

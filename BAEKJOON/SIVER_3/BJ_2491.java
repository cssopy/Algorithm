package Algorithm.BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열 (실버 3)
// 수열에서 연속적으로 작아지거나 커지는 구간의 최대 길이를 구하는 문제
// https://www.acmicpc.net/problem/2491
public class BJ_2491 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int cn = 0;
		int ul = 0, dl = 0;
		int max = 0;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int inp;
		for (int nc = 0; nc < N; nc++) {
			inp = Integer.parseInt(st.nextToken());

			if (cn <= inp) {
				ul++;
				max = ul > max ? ul : max;
			} else {
				max = ul > max ? ul : max;
				ul = 1;
			}

			if (cn >= inp) {
				dl++;
				max = dl > max ? dl : max;
			} else {
				max = dl > max ? dl : max;
				dl = 1;
			}

			cn = inp;
		}

		System.out.println(max);
	}
}

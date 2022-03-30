package Algorithm.BAEKJOON.BRONZE_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 롤 케이크 (브론즈 1)
// 롤케이크를 L등분하여 방청객에게 나눠줄때 가장 많이 받을거라 기대되는 방청객과 실제로 많이 받는 방청객이 누구인지 구하는 문제
// https://www.acmicpc.net/problem/3985
public class BJ_3985 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 롤 케이크의 길이
		int L = Integer.parseInt(br.readLine());
		// 해당 번호의 케이크 조각을 가져갔는지에 대한 정보를 표시할 배열
		boolean[] cakes = new boolean[L + 1];

		// 방청객 수
		int N = Integer.parseInt(br.readLine());
		// 가장 많이 받을거라 기대되는 사람의 번호, 가장 많이 받을거라 기대되는 수
		int mp = 0, mv = 0;
		// 실제 가장 많이 받은 사람의 번호, 실제 제일 많이 케이크를 가져간 수
		int ap = 0, av = 0;
		for (int nc = 1; nc <= N; nc++) {
			st = new StringTokenizer(br.readLine());
			// 시작 번호
			int P = Integer.parseInt(st.nextToken());
			// 끝 번호
			int K = Integer.parseInt(st.nextToken());

			if (mv < K - P + 1) {
				mp = nc;
				mv = K - P + 1;
			}

			int c = 0;
			for (int i = P; i <= K; i++) {
				if (cakes[i] == false) {
					cakes[i] = true;
					c++;
				}
			}

			if (c > av) {
				ap = nc;
				av = c;
			}
		}

		System.out.println(mp);
		System.out.println(ap);
	}
}

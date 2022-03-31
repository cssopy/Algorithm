package Algorithm.BAEKJOON.SIVER_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// RGB거리 (실버 1)
// N개의 집을 어떠한 규칙을 만족하면서 페인트를 칠할때 페인트 칠한는 비용의 최솟값을 구하는 문제
// https://www.acmicpc.net/problem/1149
public class BJ_1149 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 집의 수
		int N = Integer.parseInt(br.readLine());

		// 해당 집까지 해당 색으로 색을 마무리를 짓는다할때 최소값을 저장할 배열
		int[][] as = new int[N][3];
		// 페인트마다 드는 비용을 저장할 배열
		int[] inps = new int[3];
		for (int nc = 0; nc < N; nc++) {
			st = new StringTokenizer(br.readLine());

			// 페인트마다 드는 비용 입력
			for (int i = 0; i < 3; i++) {
				inps[i] = Integer.parseInt(st.nextToken());
			}

			// 첫번째 집은 각각의 색의 비용으로 초기화
			if (nc == 0) {
				for (int i = 0; i < 3; i++) {
					as[nc][i] = inps[i];
				}
			} 
			// 2번째 집부터 각각의 색을 골랐을경우 이전의 집을 다른 색으로 골랐을 경우인 2가지의 비용을 가져와 그 중 더 적은 비용으로 더해서 초기화
			else {
				for (int i = 0; i < 3; i++) {
					as[nc][i] = Math.min(inps[i] + as[nc - 1][(i + 1) % 3], inps[i] + as[nc - 1][(i + 2) % 3]);
				}
			}
		}

		int[] ans = { Integer.MAX_VALUE };
		for (int i = 0; i < 3; i++) {
			ans[0] = Math.min(ans[0], as[N-1][i]);
		}

		System.out.println(ans[0]);
	}
}

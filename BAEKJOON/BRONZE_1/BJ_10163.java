package Algorithm.BAEKJOON.BRONZE_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이
// https://www.acmicpc.net/problem/10163
public class BJ_10163 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int[][] map = new int[1001][1001];

		// 색종이 수
		int N = Integer.parseInt(br.readLine());
		int[] na = new int[N + 1];
		for (int nc = 1; nc <= N; nc++) {
			st = new StringTokenizer(br.readLine());
			int ci = Integer.parseInt(st.nextToken());
			int cj = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int i = ci; i < ci + w; i++) {
				for (int j = cj; j < cj + h; j++) {
					if (map[i][j] != 0) {
						na[map[i][j]]--;
					}
					map[i][j] = nc;
					na[nc]++;
				}
			}
			
		}

		for (int i = 1; i <= N; i++) {
			sb.append(na[i]);
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
}

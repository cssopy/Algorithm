package Algorithm.BAEKJOON.SIVER_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참외밭 (실버 4)
// 움푹파인 직사각형 참외밭의 크기를 구하는 문제
// https://www.acmicpc.net/problem/2477
public class BJ_2477 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] inps = new int[6][3];

		int max = 0;
		int midx = -1;
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			inps[i][0] = Integer.parseInt(st.nextToken());
			inps[i][1] = Integer.parseInt(st.nextToken());
			inps[i][2] = i;
			if (inps[i][1] > max) {
				max = inps[i][1];
				midx = i;
			}
		}

		int nidx = (inps[(midx + 1) % 6][1] > inps[(midx - 1 + 6) % 6][1]) ? (midx + 1) % 6 : (midx - 1 + 6) % 6;
		int[] sidx = { inps[(Math.max(midx, nidx) + 3) % 6][2], inps[(Math.min(midx, nidx) + 3) % 6][2] };
		int result = (inps[midx][1] * inps[nidx][1]) - (inps[sidx[0]][1] * inps[sidx[1]][1]);
		
		System.out.println(result * K);
	}
}

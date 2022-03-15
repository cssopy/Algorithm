package Algorithm.BAEKJOON.BRONZE_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 직사각형 네개의 합집합의 면적 구하기 (브론즈 1)
// 평면에 네 개의 직사각형이 놓여있을때 직사각형들이 차지하는 면적을 구하는 문제
// https://www.acmicpc.net/problem/2669
public class BJ_2669 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] sqs = new int[4][4];
		int x1, y1, x2, y2;
		int mx = 0, my = 0;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			sqs[i][0] = x1;
			sqs[i][1] = y1;
			sqs[i][2] = x2;
			sqs[i][3] = y2;
			
			if (x2 > mx)	mx = x2;
			if (y2 > my)	my = y2;
		}
		
		int[][] map = new int[mx][my];
		for (int i = 0; i < 4; i++) {
			int[] sq = sqs[i];
			for (int x = sq[0]; x < sq[2]; x++) {
				for (int y = sq[1]; y < sq[3]; y++) {
					map[x][y] = 1;
				}
			}
		}
		
		int result = 0;
		for (int x = 0; x < mx; x++) {
			for (int y = 0; y < my; y++) {
				if (map[x][y] == 1)	result++;
			}
		}
		System.out.println(result);
	}
}

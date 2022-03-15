package Algorithm.BAEKJOON.SIVER_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 빙고 (실버 5)
// 숫자들이 입력될때 빙고판에 3빙고가 됐을경우를 구하는 문제
// https://www.acmicpc.net/problem/2564
public class BJ_2578 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Map<Integer, int[]> dic = new HashMap<>();
		int[][] map = new int[5][5];

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				dic.put(Integer.parseInt(st.nextToken()), new int[] { i, j });
			}
		}

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int[] idx = dic.get(Integer.parseInt(st.nextToken()));
				map[idx[0]][idx[1]] = 1;
				if (isBinggo(map)) {
					System.out.println((i*5) + (j+1));
					return;
				}
			}
		}
	}

	public static boolean isBinggo(int[][] map) {
		int bc = 0;
		
		int rb = 0;
		int cb = 0;
		int[] xb = new int[2];
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(map[i][j] == 1)	rb++;
				if(rb == 5)	bc++;
				
				if(map[j][i] == 1)	cb++;
				if(cb == 5)	bc++;
			}
			rb = 0;
			cb = 0;
			
			if(map[i][i] == 1)	xb[0]++;
			if(xb[0] == 5)	bc++;
			
			if(map[i][4-i] == 1)	xb[1]++;
			if(xb[1] == 5)	bc++;
		}
		
		if(bc>=3)	return true;
		else		return false;
	}
}

package Algorithm.BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이 (브론즈 1)
// 도화지 위에 색종이가 차지하는 공간의 넓이를 구하는 문제
// https://www.acmicpc.net/problem/2563
public class BJ_2563_00000000000000000 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int pn = Integer.parseInt(br.readLine());
		int[][][] papers = new int[pn][4][2];
		int x,y;
		for(int i=0; i<pn; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			papers[i][0][0] = x; 	papers[i][0][1] = y;
			papers[i][1][0] = x; 	papers[i][1][1] = y+10;
			papers[i][2][0] = x+10; papers[i][2][1] = y;
			papers[i][3][0] = x+10; papers[i][3][1] = y+10;
		}
		
		int result = 300;
		for(int i=0; i<pn; i++) {
			for(int j=i+1; j<pn; j++) {
				result -= bj_2563(papers[i], papers[j]);
			}
		}
		System.out.println(result);
	}
	
	public static int bj_2563(int[][] p1, int[][] p2) {
		int w = Math.min(p1[3][0], p2[3][0])-Math.max(p1[0][0], p2[0][0]);
		int h = Math.min(p1[3][1], p2[3][1])-Math.max(p1[0][1], p2[0][1]);
		
		if(w<0 || h<0) {
			return 0;
		}
		
		return Math.abs(w*h);
	}
}

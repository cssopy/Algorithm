package Algorithm.SWExpertAcademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Ladder1 (D4)
// 사다리타기를 하여 목표한 위치에 도달하는 시작위치를 구하는 문제
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh
public class swEA_1210 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 100;
		int[][] map = new int[N][N];
		
		for(int tc=0; tc<10; tc++) {
			int T = Integer.parseInt(br.readLine());
			
			int x = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2)	x = j;
				}
			}
			
			x = solve(map, x);
			System.out.println("#" + T + " " + x);
		}
	}
	
	public static int solve(int[][] map, int x) {
		int y = map.length-1;
		
		int dir = 0;
		while(true) {
			if(x-1 >= 0 && map[y][x-1] == 1) {
				while(x-1 >= 0 && map[y][x-1] == 1) x--;
			}else if(x+1 < map.length && map[y][x+1] == 1) {
				while(x+1 < map.length && map[y][x+1] == 1) x++;
			}
			
			if(dir != 0) {
				while(true) {
					if((x+dir >= 0 && x+dir < map.length) && map[y][x+dir] == 1) {
						x += dir;
					}else {
						dir = 0;
						break;
					}
				}
			}
			
			y--;
			
			if(y < 0) {
				break;
			}
		}
		
		return x;
	}
}
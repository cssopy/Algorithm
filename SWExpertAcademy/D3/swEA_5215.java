package Algorithm.SWExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 햄버거 다이어트 (D3)
// 조건이 걸린 조합문제(하지만 부분집합으로 풀이)
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT
public class swEA_5215 {
	
	static int n, l;
	static int[][] input;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());	// 테스트케이스 수
		
		for(int i=0; i<t; i++) {
			String[] data = br.readLine().split(" ");
			n = Integer.parseInt(data[0]);
			l = Integer.parseInt(data[1]);
			
			input = new int[n][2];
			// 재료들의 맛점수와 칼로리 입력
			for(int j=0; j<n; j++) {
				String[] ingredient = br.readLine().split(" ");
				input[j][0] = Integer.parseInt(ingredient[0]);
				input[j][1] = Integer.parseInt(ingredient[1]);
			}
			
			max = 0;
			swea_5215(0, 0, 0);
			System.out.println("#"+(i+1)+" "+max);
		}
	}
	
	// 부분집합 활용
	public static void swea_5215(int cnt, int st, int cal) {
		
		if(cal>l) {
			return;
		}
		if(cal<=l) {
			max = max > st ? max : st;
		}
		if(cnt==n) {
			return;
		}
		
		swea_5215(cnt+1, st+input[cnt][0], cal+input[cnt][1]);
		swea_5215(cnt+1, st, cal);
	}
}

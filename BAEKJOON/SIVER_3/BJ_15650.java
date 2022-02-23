package Algorithm.BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (2) (실버 3)
// N과 M이 주어질때 N개 숫자 중 M개의 수열을 모두 구하는 문제(조합 문제)
// https://www.acmicpc.net/problem/15650
public class BJ_15650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		combi(0, 1, N, M, new boolean[N+1], sb);
		
		System.out.println(sb.toString());
	}
	
	public static void combi(int cnt, int s, int N, int M, boolean[] isSel, StringBuilder sb) {
		// M개의 숫자를 뽑았다면 종료
		if (cnt == M) {
			for (int i = 1; i <= N; i++) {
				if(isSel[i]) {
					sb.append(i + " ");
				}
			}
			sb.append("\n");
			return;
		}

		// 해당 숫자를 뽑으면 다음 숫자는 해당숫자 다음 수부터 고려
		for (int i = s; i <= N; i++) {
			isSel[i] = true;
			combi(cnt + 1, i + 1, N, M, isSel, sb);
			isSel[i] = false;
		}
	}
}

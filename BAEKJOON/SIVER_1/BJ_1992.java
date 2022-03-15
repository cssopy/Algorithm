package Algorithm.BAEKJOON.SIVER_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쿼드트리 (실버 1)
// 분할정복, 재귀를 활용해 원본 영상을 압축하여 표현하는 문제
// https://www.acmicpc.net/problem/1992
public class BJ_1992 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 영상의 크기
		int N = Integer.parseInt(br.readLine());

		// 이미지 정보 저장할 이차원 배열
		int[][] map = new int[N][N];
		// 이미지 정보 입력
		for (int nc = 0; nc < N; nc++) {
			String inp = br.readLine();
			for (int i = 0; i < N; i++) {
				map[nc][i] = Integer.parseInt(Character.toString(inp.charAt(i)));
			}
		}

		solve(map, 0, 0, N, sb);
		System.out.println(sb.toString());
	}

	public static void solve(int[][] map, int y, int x, int N, StringBuilder sb) {
		// 1의 개수를 저장할 변수
		int sum = 0;
		// 1의 개수를 카운팅
		for(int i=y; i<y+N; i++) {
			for(int j=x; j<x+N; j++) {
				if(map[i][j] == 1)	sum++;
			}
		}
		// 해당 영역이 모두 0 이나 1로 가득차 있다면 가득차있는 숫자를 sb에 append
		if (sum == N * N) {
			sb.append(1);
			return;
		} else if(sum == 0) {
			sb.append(0);
			return;
		}
		
		sb.append("(");
		solve(map, y, x, N / 2, sb);
		solve(map, y, x + N / 2, N / 2, sb);
		solve(map, y + N / 2, x, N / 2, sb);
		solve(map, y + N / 2, x + N / 2, N / 2, sb);
		sb.append(")");
	}
}

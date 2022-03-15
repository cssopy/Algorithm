package Algorithm.BAEKJOON.SIVER_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 자리배정 (실버 4)
// 손님을 좌석에 배치할때 왼쪽아래부터 시작해 외각으로 시계방향으로 돌면서 배정한다고 할때 대기번호가 K인 사람의 좌석을 구하는 문제
// https://www.acmicpc.net/problem/10157
public class BJ_10157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		int[][] map = new int[R][C];

		int[] dy = { 1, 0, -1, 0 };
		int[] dx = { 0, 1, 0, -1 };
		int dir = 0;
		int y = 0, x = 0;
		if (K > C * R) {
			System.out.println("0");
		} else {
			for (int i = 1; i <= K; i++) {
				map[y][x] = i;
				if (i == K) {
					break;
				}
				if (y + dy[dir] > R - 1 || y + dy[dir] < 0 || x + dx[dir] > C - 1 || x + dx[dir] < 0
						|| map[y + dy[dir]][x + dx[dir]] != 0) {
					dir = (dir + 1) % 4;
				}
				y += dy[dir];
				x += dx[dir];
			}
			
			System.out.println((x + 1) + " " + (y + 1));
		}
	}
}

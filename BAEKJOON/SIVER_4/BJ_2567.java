package Algorithm.BAEKJOON.SIVER_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이 - 2 (실버 4)
// 도화지에 색종이가 놓였을때 검은 영역의 둘레의 길이를 구하는 문제
// https://www.acmicpc.net/problem/2567
public class BJ_2567 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 색종이의 수
		int T = Integer.parseInt(br.readLine());
		// 도화지 배열
		boolean[][] paper = new boolean[100][100];
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int xx = x; xx < x + 10; xx++) {
				for (int yy = y; yy < y + 10; yy++) {
					paper[xx][yy] = true;
				}
			}
		}

		// 둘레의 길이
		int[] ans = new int[1];
		checkRound(paper, ans);
		
		System.out.println(ans[0]);
	}

	// 사각형의 영역에만 접근해 사방탐색을 통해 둘레를 체크
	public static void checkRound(boolean[][] paper, int[] ans) {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };

		// 사각형의 영역에 접근
		for (int xx = 0; xx < 100; xx++) {
			for (int yy = 0; yy < 100; yy++) {
				// 사각형 영역이 아니면 continue
				if (!paper[xx][yy]) {
					continue;
				}
				// 사각형의 영역중 겉영역에서 각 좌표마다 사방탐색을 함
				for (int dir = 0; dir < 4; dir++) {
					int nx = xx + dx[dir];
					int ny = yy + dy[dir];

					// 탐색한 곳이 도화지 끝 부분이거나 둘레부분이면 둘레길이를 더함
					if ((nx < 0 || nx >= 100) || (ny < 0 || ny >= 100) || paper[nx][ny] == false) {
						ans[0]++;
					}
				}
			}
		}
	}
}

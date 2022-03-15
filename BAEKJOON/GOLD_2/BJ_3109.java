package Algorithm.BAEKJOON.GOLD_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빵집 (골드 2)
// 빵집을 운영하는 원웅이가 건물들을 피해 몰래 설치할 수 있는 최대의 파이프라인 개수를 구하는 문제
// https://www.acmicpc.net/problem/3109
public class BJ_3109 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 행의 수
		int R = Integer.parseInt(st.nextToken());
		// 열의 수
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][];
		// 건물 위치 입력
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int[] ans = new int[1];
		// 끝에 도달했을때 그 이상의 무의미한 파이프 설치를 막기위함
		boolean[] f = new boolean[1];
		// 첫번째 열부터 탐색
		for (int i = 0; i < R; i++) {
			// true이면 아직 끝에 도달 못했다는 의미
			f[0] = true;
			solve(map, i, 0, R, C, ans, f);
		}
		System.out.println(ans[0]);
	}

	public static void solve(char[][] map, int i, int j, int R, int C, int[] ans, boolean[] f) {
		if (f[0]) {
			// 현재 위치 파이프 설치
			map[i][j] = 'P';

			// 현재 위치가 도착지점일때
			if (j == C - 1) {
				// 완성된 파이프라인 1개 추가
				ans[0]++;
				// 해당 파이프라인은 설치가 완료
				f[0] = false;
				return;
			}
		} else {
			// 하나의 파이프라인이 완성됐다면 진행할 이유X
			return;
		}

		int[] di = { -1, 0, 1 };
		// 다음 오른쪽 칸 접근(오른쪽 위, 오른쪽, 오른쪽 아래)
		for (int dir = 0; dir < 3; dir++) {
			// 다음 칸 좌표
			int ni = i + di[dir];
			int nj = j + 1;

			// 다음 칸이 map을 벗어나지 않고 건물이나 다른 파이프가 없다면 이동
			if (ni >= 0 && ni < R && map[ni][nj] == '.') {
				solve(map, ni, nj, R, C, ans, f);
			}
		}
	}
}
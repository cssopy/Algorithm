package Algorithm.BAEKJOON.GOLD_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 알파벳 (골드 4)
// 알파벳으로 채워진 map을 이미 다녀간 알파벳을 제외하고 최대한 많이 돌아다니는 횟수를 구하는 문제
// https://www.acmicpc.net/problem/1987
public class BJ_1987 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 행의 수
		int R = Integer.parseInt(st.nextToken());
		// 열의 수
		int C = Integer.parseInt(st.nextToken());

		// 입력
		char[][] map = new char[R][C];
		for (int rc = 0; rc < R; rc++) {
			String inp = br.readLine();
			for (int cc = 0; cc < C; cc++) {
				map[rc][cc] = inp.charAt(cc);
			}
		}

		int[] ans = new int[1];
		solve(map, 0, 0, R, C, new HashSet<>(), ans);
		
		System.out.println(ans[0]);
	}

	public static void solve(char[][] map, int i, int j, int R, int C, Set<Character> set, int[] ans) {		
		if(set.contains(map[i][j])) {	// 현재 위치의 알파벳이 이미 지나왔던 알파벳이라면
			ans[0] = Math.max(ans[0], set.size());
			return;
		} else {
			// 현재 위치의 알파벳이 처음 본 알파벳이라면 set에 추가
			set.add(map[i][j]);
			
			int[] dy = { -1, 0, 1, 0 };
			int[] dx = { 0, 1, 0, -1 };
			
			// 현재위치 기준으로 4방향 다 가보기
			for (int dir = 0; dir < 4; dir++) {
				int ni = i + dy[dir];
				int nj = j + dx[dir];
				
				if((ni >= 0 && ni <R) && (nj >= 0 && nj <C)) {
					solve(map, ni, nj, R, C, set, ans);
				}
			}
			
			set.remove(map[i][j]);
		}
	}
}

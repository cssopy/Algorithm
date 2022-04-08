package Algorithm.BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사
// https://www.acmicpc.net/problem/14501
public class BJ_14501 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 스케줄 일 수
		int N = Integer.parseInt(br.readLine());
		// 스케줄
		int[][] sch = new int[N][2];
		for (int nc = 0; nc < N; nc++) {
			st = new StringTokenizer(br.readLine());
			sch[nc][0] = Integer.parseInt(st.nextToken());
			sch[nc][1] = Integer.parseInt(st.nextToken());
		}

		int[] ans = { 0 };
		for (int i = 0; i < N; i++) {
			solve(i, N, sch, 0, ans);
		}

		System.out.println(ans[0]);
	}

	public static void solve(int cnt, int N, int[][] sch, int p, int[] ans) {
		if (cnt >= N) {
			ans[0] = Math.max(ans[0], p);
			return;
		}

		if (cnt + sch[cnt][0] > N) {
			solve(cnt + sch[cnt][0], N, sch, p, ans);
		} else if (cnt + sch[cnt][0] == N) {
			solve(cnt + sch[cnt][0], N, sch, p + sch[cnt][1], ans);
		} else {
			for (int i = cnt + sch[cnt][0]; i < N; i++) {
				solve(i, N, sch, p + sch[cnt][1], ans);
			}
		}
	}
}

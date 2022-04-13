package Algorithm.BAEKJOON.SIVER_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스타트와 링크
// https://www.acmicpc.net/problem/14889
public class BJ_14889 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 사람 수
		int N = Integer.parseInt(br.readLine());
		// 능력치
		int[][] S = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[] f = new boolean[1];
		int[] ans = { Integer.MAX_VALUE };
		solve(0, 0, N, S, new boolean[N], ans, f);

		System.out.println(ans[0]);
	}

	public static void solve(int cnt, int s, int N, int[][] S, boolean[] isSel, int[] ans, boolean[] f) {
		if (cnt == N / 2) {
			if (!isSel[0]) {
				f[0] = true;
				return;
			}
			ans[0] = Math.min(ans[0], getTS(N, S, isSel));
			return;
		}

		if (f[0]) {
			return;
		}

		for (int i = s; i < N; i++) {
			isSel[i] = true;
			solve(cnt + 1, i + 1, N, S, isSel, ans, f);
			isSel[i] = false;
		}
	}

	public static int getTS(int N, int[][] S, boolean[] isSel) {
		int to = 0, tt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (isSel[i] == isSel[j]) {
					if (isSel[i]) {
						to += S[i][j];
					} else {
						tt += S[i][j];
					}
				}
			}
		}
		return Math.abs(to - tt);
	}
	
	public static int getTS2(int N, int[][] S, boolean[] isSel) {
		int io = 0, it = 0;
		int[] ios = new int[N / 2];
		int[] its = new int[N / 2];
		for (int i = 0; i < N; i++) {
			if (isSel[i]) {
				ios[io++] = i;
			} else {
				its[it++] = i;
			}
		}

		int to = 0, tt = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N; j++) {
				if (isSel[j]) {
					if (ios[i] < j) {
						to += S[ios[i]][j];
						to += S[j][ios[i]];
					}
				} else {
					if (its[i] < j) {
						tt += S[its[i]][j];
						tt += S[j][its[i]];
					}
				}
			}
		}

		return Math.abs(to - tt);
	}
}

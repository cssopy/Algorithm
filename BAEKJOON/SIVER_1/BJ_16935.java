package Algorithm.BAEKJOON.SIVER_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배열 돌리기 3 (실버 1)
// 배열을 상하, 좌우반전, 시계, 반시계회전, 등 다양한 처리를 하는 문제
// https://www.acmicpc.net/problem/16935
public class BJ_16935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		// 행 길이
		int N = Integer.parseInt(st.nextToken());
		// 열 길이
		int M = Integer.parseInt(st.nextToken());
		// 수행해야할 연산의 수
		int R = Integer.parseInt(st.nextToken());

		int[][] A = new int[N][M];
		// A의 원소 입력
		for (int nc = 0; nc < N; nc++) {
			st = new StringTokenizer(br.readLine());
			for (int mc = 0; mc < M; mc++) {
				A[nc][mc] = Integer.parseInt(st.nextToken());
			}
		}

		// 수행해야할 연산 입력 및 처리
		st = new StringTokenizer(br.readLine());
		for (int rc = 0; rc < R; rc++) {
			int algo = Integer.parseInt(st.nextToken());
			A = solve(A, A.length, A[0].length, algo);
		}

		// 출력
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				sb.append(A[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static int[][] solve(int[][] A, int N, int M, int algo) {
		if (algo == 1) {
			// 상하 반전
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M; j++) {
					int temp = A[i][j];
					A[i][j] = A[N - i - 1][j];
					A[N - i - 1][j] = temp;
				}
			}
			return A;
		} else if (algo == 2) {
			// 좌우 반전
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					int temp = A[i][j];
					A[i][j] = A[i][M - j - 1];
					A[i][M - j - 1] = temp;
				}
			}
			return A;
		} else if (algo == 3) {
			// 시계 방향 90도 회전
			int[][] newA = new int[M][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					newA[j][N - i - 1] = A[i][j];
				}
			}
			return newA;
		} else if (algo == 4) {
			// 반시계 방향 90도 회전
			int[][] newA = new int[M][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					newA[M - j - 1][i] = A[i][j];
				}
			}
			return newA;
		} else if (algo == 5) {
			// 4분할 후 시계 방향 회전
			int[][] newA = new int[N][M];
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					newA[i][j + M / 2] = A[i][j];
					newA[i + N / 2][j + M / 2] = A[i][j + M / 2];
					newA[i + N / 2][j] = A[i + N / 2][j + M / 2];
					newA[i][j] = A[i + N / 2][j];
				}
			}
			return newA;
		} else if (algo == 6) {
			// 4분할 후 반시계 방향 회전
			int[][] newA = new int[N][M];
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					newA[i + N / 2][j] = A[i][j];
					newA[i + N / 2][j + M / 2] = A[i + N / 2][j];
					newA[i][j + M / 2] = A[i + N / 2][j + M / 2];
					newA[i][j] = A[i][j + M / 2];
				}
			}
			return newA;
		}
		return null;
	}
}

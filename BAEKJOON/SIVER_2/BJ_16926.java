package Algorithm.BAEKJOON.SIVER_2;

import java.io.IOException;
import java.util.Scanner;

// 배열 돌리기 1 (실버 2)
// 이차원 배열을 반시계방향으로 돌리는데 제일 외각은 외각끼리 그다음 안쪽 사이클은 안쪽끼리 돌아가야하는 문제
// https://www.acmicpc.net/problem/16926
public class BJ_16926 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N, M, R;
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();

		//	A 배열에 입력값들 초기화
		int[][] A = new int[N][M];
		for (int nc = 0; nc < N; nc++) {
			for (int mc = 0; mc < M; mc++) {
				A[nc][mc] = sc.nextInt();
			}
		}
		sc.close();

		//	R만큼 회전
		for (int rc = 0; rc < R; rc++) {
			bj_16926(A, 0, N-1, M-1, 0);
		}
		
		//	출력
		for (int nc = 0; nc < N; nc++) {
			for (int mc = 0; mc < M; mc++) {
				System.out.print(A[nc][mc]+" ");
			}
			System.out.println();
		}
	}

	//	반시계 방향으로 회전하는 재귀 함수
	public static void bj_16926(int[][] A, int l, int d, int r, int u) {
		//	임시 저장공간(모서리에 있는 값들)
		int[] temp = new int[3];

		//	왼쪽 아래 모서리 값 저장
		temp[0] = A[d][l];
		//	왼쪽 변의 값들 이동
		for (int i = d; i > u; i--) {
			A[i][l] = A[i - 1][l];
		}

		// 오른쪽 아래 모서리 값 저장
		temp[1] = A[d][r];
		//	아래 변의 값들 이동
		for (int i = r; i > l + 1; i--) {
			A[d][i] = A[d][i - 1];
		}
		A[d][l + 1] = temp[0];

		//	오른쪽 위 모서리 값 저장
		temp[2] = A[u][r];
		//	오른쪽 변의 값들 이동
		for (int i = u; i < d - 1; i++) {
			A[i][r] = A[i + 1][r];
		}
		A[d - 1][r] = temp[1];
		
		//	윗 변의 값들 이동
		for (int i = l; i < r - 1; i++) {
			A[u][i] = A[u][i + 1];
		}
		A[u][r - 1] = temp[2];
		
		// 현재 싸이클이 가장 안쪽 싸이클이면 재귀함수 종료
		int min = d < r ? d : r;
		if (min / 2 == l)	return;

		// 다음 안쪽 싸이클
		bj_16926(A, l+1, d-1, r-1, u+1);
	}
}

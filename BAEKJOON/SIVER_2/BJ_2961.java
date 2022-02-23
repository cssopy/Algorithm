package Algorithm.BAEKJOON.SIVER_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 도영이가 만든 맛있는 음식 (실버 2)
// 어떤 재료들을 선택해야 신맛과 쓴맛의 차이를 줄일 수 있는지 찾는 문제
// https://www.acmicpc.net/problem/2961
public class BJ_2961 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 재료의 가지수
		int N = Integer.parseInt(br.readLine());
		// 재료 저장 배열
		int[][] mts = new int[N][2];
		for(int nc=0; nc<N; nc++) {
			st = new StringTokenizer(br.readLine());
			// 신 맛
			int S = Integer.parseInt(st.nextToken());
			// 쓴 맛
			int B = Integer.parseInt(st.nextToken());
			
			mts[nc][0] = S;
			mts[nc][1] = B;
		}
		
		// 신맛과 쓴맛의 차이의 최소값
		int[] ans = new int[1];
		ans[0] = (int) Double.POSITIVE_INFINITY;

		getT(0, mts, 1, 0, N, 0, ans);
		
		System.out.println(ans[0]);
	}

	// 재료들의 모든 부분집합에서 1개 이상의 재료를 사용한 경우의 신맛과 쓴맛의 차이의 최소값을 구하는 함수
//	public static void getT(int cnt, int[][] mts, boolean[] isSelected, int N, int[] ans) {
//		if (cnt == N) {
//			int S = 1;
//			int B = 0;
//			int c = 0;
//			for (int i = 0; i < N; i++) {
//				if (isSelected[i]) {
//					S *= mts[i][0];
//					B += mts[i][1];
//					c++;
//				}
//			}
//			if (c >= 1) {
//				ans[0] = ans[0] < Math.abs(S - B) ? ans[0] : Math.abs(S - B);
//			}
//			return;
//		}
//
//		// 현재 재료 채용
//		isSelected[cnt] = true;
//		getT(cnt + 1, mts, isSelected, N, ans);
//		
//		// 현재 재료 미채용
//		isSelected[cnt] = false;
//		getT(cnt + 1, mts, isSelected, N, ans);
//	}
	
	public static void getT(int cnt, int[][] mts, int S, int B, int N, int c, int[] ans) {
		if (cnt == N) {
			if (c >= 1) {
				ans[0] = ans[0] < Math.abs(S - B) ? ans[0] : Math.abs(S - B);
			}
			return;
		}

		// 현재 재료 채용
		getT(cnt + 1, mts, S * mts[cnt][0], B + mts[cnt][1], N, c + 1, ans);

		// 현재 재료 미채용
		getT(cnt + 1, mts, S, B, N, c, ans);
	}
}

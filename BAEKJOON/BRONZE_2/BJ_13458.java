package Algorithm.BAEKJOON.BRONZE_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시험 감독
// https://www.acmicpc.net/problem/13458
public class BJ_13458 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 시험장의 개수
		int N = Integer.parseInt(br.readLine());
		// 각 시험장에 있는 응시자의 수
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		// 총감독관이 감시할 수 있는 응시자의 수
		int B = Integer.parseInt(st.nextToken());
		// 부감독관이 감시할 수 있는 응시자의 수
		int C = Integer.parseInt(st.nextToken());

		long ans = N;
		for (int i = 0; i < N; i++) {
			if ((A[i] - B) > 0) {
				if ((A[i] - B) % C == 0) {
					ans += (A[i] - B) / C;
				} else {
					ans += (A[i] - B) / C + 1;
				}
			} 
		}

		System.out.println(ans);
	}
}

package Algorithm.BAEKJOON.BRONZE_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//	방 배정 (브론즈 2)
//	학년별 성별로 방을 배정하여 필요한 방의 수를 구하는 문제
//	https://www.acmicpc.net/problem/13300
public class BJ_13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 입력받을 총 학생 수
		int K = Integer.parseInt(st.nextToken());	// 방 제한인원

		// 이차원배열로 학년별 성별로 학생수를 저장
		int[][] stds = new int[7][2];

		// 입력
		for (int nc = 0; nc < N; nc++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			stds[Y][S]++;
		}

		int ans = 0;	// 결과 변수
		// 1명이라도 있으면 방을 배정해줘야 하기때문에 K로 나눈후 올림처리 = 필요한 방의 개수
		for (int nc = 1; nc < stds.length; nc++) {
			ans += Math.ceil((double) stds[nc][0] / K);
			ans += Math.ceil((double) stds[nc][1] / K);
		}
		System.out.println(ans);
	}
}

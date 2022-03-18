package Algorithm.BAEKJOON.BRONZE_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 슈퍼 마리오 (브론즈 1)
// 마리오가 받는 점수의 합을 최대한 100에 가깝게 구하는 문제
// https://www.acmicpc.net/problem/2851
public class BJ_2851 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int target = 100;
		int inp_n = 10;
		
		// 구간합을 저장할 배열
		int[] sums = new int[inp_n];
		// 입력
		int sum = 0;
		for (int i = 0; i < inp_n; i++) {
			sum += Integer.parseInt(br.readLine());
			sums[i] = sum;
		}
		
		// 정답
		int ans = 0;
		for(int i=0; i<inp_n; i++) {
			// 구간합과 ans중 100에 더 가까운 수를 ans에 재초기화
			if(Math.abs(sums[i]-target) <= Math.abs(ans-target)) {
				ans = sums[i];
			}
		}
		
		System.out.println(ans);
	}
}

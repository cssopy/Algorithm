package Algorithm.BAEKJOON.BRONZE_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 설탕 배달 (브론즈 1)
// 상근이가 Nkg 설탕을 배달해야 할때 가져가야할 봉지의 최소 개수를 구하는 문제
// https://www.acmicpc.net/problem/2839
public class BJ_2839_recursive {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 배달해야 할 무게
		int N = Integer.parseInt(br.readLine());
		
		solve(N, 0, 0);
		System.out.println(-1);
	}
	
	static void solve(int N, int weight, int cnt) {
		if (weight > N) return;
		if (weight == N) {
			System.out.println(cnt);
			System.exit(0);
		}
		
		solve(N, weight + 5, cnt + 1);
		solve(N, weight + 3, cnt + 1);
	}
}

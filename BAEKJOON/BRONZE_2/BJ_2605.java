package Algorithm.BAEKJOON.BRONZE_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 줄 세우기 (브론즈 2)
// 어떤 규칙에 의해 학생들을 줄세울때 완성될 줄의 모양을 구하는 문제
// https://www.acmicpc.net/problem/2605
public class BJ_2605 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		List<Integer> stds = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int inp = 0;
		for (int i = 0; i < N; i++) {
			stds.add(i + 1);
			inp = Integer.parseInt(st.nextToken());
			if (inp != 0) {
				stds.add(i - inp, stds.remove(i));
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(stds.get(i) + " ");
		}
	}
}

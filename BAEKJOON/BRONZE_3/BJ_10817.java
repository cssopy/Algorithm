package Algorithm.BAEKJOON.BRONZE_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 세 수
// https://www.acmicpc.net/problem/10817
public class BJ_10817 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int[] inps = new int[3];
		for (int i = 0; i < 3; i++) {
			inps[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(inps);
		System.out.println(inps[1]);
	}
}

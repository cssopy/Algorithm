package Algorithm.BAEKJOON.BRONZE_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A/B (브론즈 4)
// A에서 B를 나눈 값을 구하는 문제
// https://www.acmicpc.net/problem/1008
public class BJ_1008 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		System.out.println((double)Integer.parseInt(st.nextToken()) / Integer.parseInt(st.nextToken()));
	}
}

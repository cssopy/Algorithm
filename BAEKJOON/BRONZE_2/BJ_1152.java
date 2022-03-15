package Algorithm.BAEKJOON.BRONZE_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 단어의 개수 (브론즈 2)
// 한줄에 여러 영어단어들이 공백으로 구분되어 있는데 이 영어단어의 개수를 구하는 문제
// https://www.acmicpc.net/problem/1152
public class BJ_1152 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		System.out.println(st.countTokens());
	}
}

package Algorithm.BAEKJOON.BRONZE_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A+B (브론즈 5)
// A와 B를 더해 출력하는 문제
// https://www.acmicpc.net/problem/1000
public class BJ_1000 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		System.out.println(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));
	}
}

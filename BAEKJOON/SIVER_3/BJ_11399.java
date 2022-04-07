package Algorithm.BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// ATM
// https://www.acmicpc.net/problem/11399
public class BJ_11399 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 사람의 수
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> que = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int nc = 0; nc < N; nc++) {
			que.offer(Integer.parseInt(st.nextToken()));
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += que.poll() * (N - i);
		}

		System.out.println(ans);
	}
}

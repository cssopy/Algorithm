package Algorithm.BAEKJOON.SIVER_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// 최대 힙
// https://www.acmicpc.net/problem/11279
public class BJ_11279 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Queue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

		// 연산의 개수
		int N = Integer.parseInt(br.readLine());
		for (int nc = 0; nc < N; nc++) {
			int inp = Integer.parseInt(br.readLine());

			if (inp == 0) {
				if (que.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(que.poll()).append("\n");
				}
			} else {
				que.offer(inp);
			}
		}

		System.out.println(sb.toString());
	}
}

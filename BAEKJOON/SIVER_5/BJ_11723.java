package Algorithm.BAEKJOON.SIVER_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 집합 (실버 5)
// https://www.acmicpc.net/problem/11723
public class BJ_11723 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Set<Integer> set = new HashSet<>();

		// 수행해야 하는 연산의 수
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// 연산 유형
			String type = st.nextToken();
			// 연산 값
			int value = 0;

			if (!type.equals("all") && !type.equals("empty")) {
				value = Integer.parseInt(st.nextToken());
			}

			if (type.equals("add")) {
				set.add(value);
			} else if (type.equals("remove")) {
				set.remove(value);
			} else if (type.equals("check")) {
				if (set.contains(value)) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (type.equals("toggle")) {
				if (set.contains(value)) {
					set.remove(value);
				} else {
					set.add(value);
				}
			} else if (type.equals("all")) {
				for (int j = 1; j <= 20; j++) {
					set.add(j);
				}
			} else if (type.equals("empty")) {
				set.clear();
			}
		}
		System.out.println(sb.toString());
	}
}

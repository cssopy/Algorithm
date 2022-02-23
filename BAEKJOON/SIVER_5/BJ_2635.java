package Algorithm.BAEKJOON.SIVER_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 수 이어가기 (실버 5)
// 어떠한 규칙에 따라 수열을 만들때 그 수열의 길이가 가장 큰 수열을 구하는 문제
// https://www.acmicpc.net/problem/2635
public class BJ_2635 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int max = 0;
		List<Integer> ans_li = null;
		for (int i = N; i > 0; i--) {
			List<Integer> li = bj_2635(N, i);
			if (li.size() > max) {
				max = li.size();
				ans_li = li;
			}
		}

		sb.append(ans_li.size() + "\n");
		for (int i : ans_li) {
			sb.append(i + " ");
		}

		System.out.println(sb.toString());
	}

	public static List<Integer> bj_2635(int N1, int N2) {
		List<Integer> li = new ArrayList<Integer>();
		li.add(N1);
		li.add(N2);

		while (true) {
			int a = li.get(li.size() - 2) - li.get(li.size() - 1);
			if (a < 0) {
				break;
			}
			li.add(a);
		}

		return li;
	}
}

package Algorithm.BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 단어 뒤집기 2
// https://www.acmicpc.net/problem/17413
public class BJ_17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		StringBuilder gs = new StringBuilder();
		boolean f = false;
		for (int i = 0; i < s.length(); i++) {
			if (f) {
				if (s.charAt(i) == '>') {
					f = false;
				}

				sb.append(s.charAt(i));
				continue;
			}

			if (s.charAt(i) == '<') {
				sb.append(gs.toString());
				gs.setLength(0);

				sb.append(s.charAt(i));
				f = true;
			}

			if (s.charAt(i) == ' ') {
				sb.append(gs.toString());
				gs.setLength(0);

				sb.append(' ');
			}

			if (s.charAt(i) != ' ' && s.charAt(i) != '<' && s.charAt(i) != '>') {
				gs.insert(0, s.charAt(i));
			}
		}

		sb.append(gs.toString());

		System.out.println(sb.toString());
	}
}

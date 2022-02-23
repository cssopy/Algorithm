package Algorithm.BAEKJOON.BRONZE_1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// 단어 공부 (브론즈 1)
// 영어단어가 주어질때 해당 단어에서 제일 많이 사용된 알파벳을 찾는 문제(대소문자 구분X)
// https://www.acmicpc.net/problem/1157
public class BJ_1157 {
	public static void main(String[] args) throws IOException {
		Map<Character, Integer> m = new HashMap<>();

		int max = 0;
		while (true) {
			char inp = (char) System.in.read();
			if (inp == '\n' || inp == '\r') {
				break;
			}
			
			inp = Character.toUpperCase(inp);

			if (!m.containsKey(inp)) {
				if (1 > max) {
					max = 1;
				}
				m.put(inp, 1);
			} else {
				if (m.get(inp) + 1 > max) {
					max = m.get(inp) + 1;
				}
				m.put(inp, m.get(inp) + 1);
			}
		}
		
		int c = 0;
		char mC = '\u0000';
		for (Entry<Character, Integer> e : m.entrySet()) {
			if(e.getValue()==max) {
				mC = e.getKey();
				c++;
			}
			if (c >= 2) {
				System.out.println("?");
				return;
			}
		}
		System.out.println(mC);
	}
}

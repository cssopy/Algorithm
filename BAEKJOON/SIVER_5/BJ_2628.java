package Algorithm.BAEKJOON.SIVER_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 종이자르기 (실버 5)
// 종이르 가로, 세로 방향으로 여러번 잘랐을때 제일 큰 사각형의 넓이를 구하는 문제
// https://www.acmicpc.net/problem/2628
public class BJ_2628 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		List<Integer> ws = new ArrayList<>();
		ws.add(0);
		ws.add(W);
		List<Integer> hs = new ArrayList<>();
		hs.add(0);
		hs.add(H);

		int N = Integer.parseInt(br.readLine());
		for (int nc = 0; nc < N; nc++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());

			if (dir == 0)	hs.add(val);
			else			ws.add(val);
		}
		
		ws.sort(Comparator.reverseOrder());
		hs.sort(Comparator.reverseOrder());

		int h_max = 0;
		for (int h = 0; h < hs.size() - 1; h++) {
			int cha = hs.get(h) - hs.get(h+1);
			h_max = Math.max(h_max, cha);
		}

		int w_max = 0;
		for (int w = 0; w < ws.size() - 1; w++) {
			int cha = ws.get(w) - ws.get(w+1);
			w_max = Math.max(w_max, cha);
		}
		
		System.out.println(h_max * w_max);
	}
}

package Algorithm.BAEKJOON.GOLD_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 탑 (골드 5)
// 높이가 다른 탑들이 있을때 탑들의 신호가 그 탑들의 왼쪽의 어느 위치에 있는 탑에 수신이 되는지 찾는 문제
// https://www.acmicpc.net/problem/2493
public class BJ_2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<int[]> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int inp = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty()) {
				if (stack.peek()[0] >= inp) {
					System.out.print((stack.peek()[1] + 1) + " ");
					break;
				}
				stack.pop();
			}

			if (stack.isEmpty())
                System.out.print("0 ");
			stack.push(new int[] { inp, i });
		}
	}
}
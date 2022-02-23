package Algorithm.SWExpertAcademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 계산기2 (D4)
// 수식이 문자열로 입력될때 계산하여 답을 구하는 문제
// https://swexpertacademy.com/main/talk/solvingClub/problemView.do
public class swEA_1223 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder post_ep;

		Map<Character, Integer> ch_val = new HashMap<Character, Integer>();
		ch_val.put('+', 1);
		ch_val.put('*', 2);

		int T = 10;
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());

			post_ep = new StringBuilder();
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			for (int nc = 0; nc < N; nc++) {
				char inp = s.charAt(nc);
				if (inp != '+' && inp != '*') {
					post_ep.append(inp);
				} else {
					if (stack.isEmpty()) {
						stack.push(inp);
					} else {
						while (!stack.isEmpty() && ch_val.get(stack.peek()) >= ch_val.get(inp)) {
							post_ep.append(stack.pop());
						}
						stack.push(inp);
					}
				}
			}
			while (!stack.isEmpty())	post_ep.append(stack.pop());

			Stack<Integer> stack_i = new Stack<>();
			for (int nc = 0; nc < post_ep.length(); nc++) {
				char inp = post_ep.charAt(nc);
				if (inp != '+' && inp != '*') {
					stack_i.push(Character.getNumericValue(inp));
				} else {
					if (inp == '+') {
						int a = stack_i.pop() + stack_i.pop();
						stack_i.push(a);
					} else {
						int a = stack_i.pop() * stack_i.pop();
						stack_i.push(a);
					}
				}
			}

			sb.append("#" + (tc + 1) + " " + stack_i.pop() + "\n");
		}
		System.out.println(sb.toString());
	}
}

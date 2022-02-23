package Algorithm.SWExpertAcademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 계산기3 (D4)
// 수식이 문자열로 주어질때 계산하여 답을 구하는 문제(괄호추가버전)
// https://swexpertacademy.com/main/code/problem/problemDetail.do
public class swEA_1224 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Map<Character, Integer> ch_val = new HashMap<Character, Integer>();
		ch_val.put('+', 1);
		ch_val.put('*', 2);
		ch_val.put('(', 3);
		ch_val.put(')', 3);
		
		int T = 10;
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String ep = br.readLine();
			
			StringBuilder post_ep = new StringBuilder();
			Stack<Character> stack_op = new Stack<>();

			for (int nc = 0; nc < N; nc++) {
				char inp = ep.charAt(nc);
				
				if (inp != '+' && inp != '*' && inp != '(' && inp != ')') {
					post_ep.append(inp);
				} else if(inp == ')') {
					while(stack_op.peek() != '(') {
						post_ep.append(stack_op.pop());
					}
					stack_op.pop();
				} else {
					if (stack_op.isEmpty()) {
						stack_op.push(inp);
					} else {
						while (!stack_op.isEmpty() && ch_val.get(stack_op.peek()) >= ch_val.get(inp)) {
							if(stack_op.peek() == '(')	break;
							post_ep.append(stack_op.pop());
						}
						stack_op.add(inp);
					}
				}
			}
			while (!stack_op.isEmpty())	post_ep.append(stack_op.pop());
			
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

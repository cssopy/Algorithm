package Algorithm.SWExpertAcademy.D4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

// 괄호 짝짓기 (D4)
// 주어진 괄호들의 짝이 모두 맞는지 판별하는 문제
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD
public class swEA_1218 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int tc = 0; tc < T; tc++) {
			int T_len = sc.nextInt();
			String T_s = sc.next();

			System.out.println("#" + (tc + 1) + " " + swea_1218(T_len, T_s));
		}
		
		sc.close();
	}

	public static int swea_1218(int T_len, String T_s) {
		Stack<Character> st = new Stack<>();
		Map<Character, Character> dic = new HashMap<>();
		dic.put(')', '(');
		dic.put(']', '[');
		dic.put('}', '{');
		dic.put('>', '<');
		
		for(int i=0; i<T_len; i++) {
			if(dic.values().contains(T_s.charAt(i))) {
				st.push(T_s.charAt(i));
			}else {
				if(st.isEmpty()) return 0;
				else {
					if(dic.get(T_s.charAt(i))==st.peek()) {
						st.pop();
					}
					else	return 0;
				}
			}
		}
		
		if(!st.isEmpty())	return 0;
		else				return 1;
	}
}
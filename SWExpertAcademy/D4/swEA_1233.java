package Algorithm.SWExpertAcademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사칙연산 유효성 검사 (D4)
// 수식을 표현한 이진 트리가 주어졌을때 해당 트리가 연산이 가능한 수식인지 확인하는 문제
// 입력으로부터 이진 트리를 구성해 풀어도 되지만 사실상 연산이 되려면 가장 아래의 단일노드들이 모두 숫자여야 연산이 가능하다는 점을 이용
// (+ 노드개수도 짝수면 계산이 불가능)
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD
public class swEA_1233 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스
		int T = 10;
		
		for (int i = 0; i < T; i++) {
			// 노드 개수
			int N = Integer.parseInt(br.readLine());
			
			// 이때의 노드위치부터 모두 숫자여야함
			int c = N / 2 + 1;
			
			int ans = 1;
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				// 노드 번호
				int nn = Integer.parseInt(st.nextToken());
				
				// 해당 노드의 값(연산기호 or 숫자)
				char nv = st.nextToken().charAt(0);
				
				// 제일 아래 단일노드가 숫자가 아닌 기호일 경우 => 연산 불가능
				if (!Character.isDigit(nv) && nn >= c) {
					ans = 0;
				}
			}
			System.out.println("#" + (i + 1) + " " + ans);
		}
	}
}

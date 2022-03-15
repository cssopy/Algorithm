package Algorithm.BAEKJOON.BRONZE_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//	딱지놀이 (브론즈 1)
//	두 개의 딱지를 비교해 딱지에 표신된 도형의 종류와 개수를 판단해 승자를 가리는 문제
//	https://www.acmicpc.net/problem/14696
public class BJ_14696 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 총 라운드 수
		int N = Integer.parseInt(br.readLine());
		
		// 라운드 수만큼 반복
		for (int nc = 0; nc < N; nc++) {
			// 각 라운드마다 저장될 a,b의 카드정보
			int[][] ab_cards = new int[2][5];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				// 도형 개수
				int C = Integer.parseInt(st.nextToken());
				
				// 도형을 모두 입력받아 각 도형의 개수를 카운트
				for (int cc = 0; cc < C; cc++) {
					int kc = Integer.parseInt(st.nextToken());
					ab_cards[i][kc]++;
				}
			}

			// a,b 동시에 별부터 비교하면서 누구 하나라도 승부가 나면 A,B를 출력
			boolean f = true;
			for (int j = 4; j > 0; j--) {
				if (ab_cards[0][j] > ab_cards[1][j]) {
					sb.append("A\n");
					f = !f;
					break;
				} else if (ab_cards[0][j] < ab_cards[1][j]) {
					sb.append("B\n");
					f = !f;
					break;
				}
			}
			
			// 끝까지 승부가 못나 비기면 D 출력
			if (ab_cards[0][4] == ab_cards[0][4] && f) {
				sb.append("D\n");
			}
		}
		System.out.println(sb.toString());
	}
}

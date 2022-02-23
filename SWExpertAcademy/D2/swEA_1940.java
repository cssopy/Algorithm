package Algorithm.SWExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가랏! RC카! (D2)
// 명령에 따라 RC카의 속도가 달라지는데 N초후 RC카가 이동한 거리를 구하는 문제
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PjMgaALgDFAUq
public class swEA_1940 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 명령어의 수 및 지나는 시간
			int N = Integer.parseInt(br.readLine());
			// RC카 속도
			int spd = 0;
			// RC카 이동거리
			int dis = 0;
			for (int nc = 0; nc < N; nc++) {
				st = new StringTokenizer(br.readLine());
				// 명령어 종류
				int c = Integer.parseInt(st.nextToken());
				// 명령어 정보
				int v = 0;
				if (c != 0)
					v = Integer.parseInt(st.nextToken());

				switch (c) {
				case 1:
					spd += v;
					break;
				case 2:
					spd -= v;
					spd = (spd < 0) ? 0 : spd;
					break;
				}
				dis += spd;
			}

			sb.append("#" + tc + " " + dis + "\n");
		}
		System.out.println(sb.toString());
	}
}

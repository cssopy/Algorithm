package Algorithm.SWExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 퍼펙트 셔플 (D3)
// 주어진 N개의 카드를 교대로 섞는 문제
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW
public class swEA_3499 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] inps = br.readLine().split(" ");

			int pi = N / 2;
			sb.append("#" + (tc + 1) + " ");
			if (N % 2 == 0) {
				for (int i = 0; i < pi; i++) {
					sb.append(inps[i] + " " + inps[i + pi] + " ");
				}
			} else {
				for (int i = 0; i < pi; i++) {
					sb.append(inps[i] + " " + inps[i + pi + 1] + " ");
				}
				sb.append(inps[pi]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}

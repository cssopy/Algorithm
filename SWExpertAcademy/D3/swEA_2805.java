package Algorithm.SWExpertAcademy.D3;

import java.util.Scanner;

// 농작물 수확하기 (D3)
// NxN크기의 농장에서 농장 크기에 맞게 마름모꼴 형태로 수확했을때 얻을 수 있는 수익을 구하는 문제 
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB
public class swEA_2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int sum = 0;
			int si = n / 2, ei = n / 2 + 1;
			int sg = -1, eg = 1;
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = si; j < ei; j++) {
					sum += Integer.parseInt(Character.toString(s.charAt(j)));
				}
				if (i == n / 2) {
					sg = 1;
					eg = -1;
				}
				si += sg;
				ei += eg;
			}
			System.out.println("#" + (tc + 1) + " " + sum);
		}
		sc.close();
	}
}

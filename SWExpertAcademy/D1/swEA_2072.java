package Algorithm.SWExpertAcademy.D1;

import java.util.Scanner;

// 홀수만 더하기 (D1)
// 10개의 수를 입력받아 그 중에서 홀수만 더하는 문제
// https://swexpertacademy.com/main/talk/solvingClub/problemView.do
public class swEA_2072 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		sc.nextLine();

		int[] sum = new int[t];

		for (int i = 0; i < t; i++) {
			String[] s_num = sc.nextLine().split(" ");
			for (int j = 0; j < s_num.length; j++) {
				if (Integer.parseInt(s_num[j]) % 2 != 0)
					sum[i] += Integer.parseInt(s_num[j]);
			}
		}
		sc.close();

		for (int i = 0; i < t; i++) {
			System.out.printf("#%d %d\n", i + 1, sum[i]);
		}
	}
}

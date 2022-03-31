package Algorithm.ETC;

import java.util.Scanner;

// 길이와 색이 다른 막대들로 n길이의 막대를 만드는 방법의 수를 구하는 문제
public class 파란막대_노란막대_빨간막대 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.close();

		int[] m = new int[n + 1];
		m[0] = 1;
		m[1] = 2;

		System.out.println(solve(m, n));
	}

	public static int solve(int[] m, int n) {
		if (n >= 2 && m[n] == 0) {
			return solve(m, n - 1) * 2 + solve(m, n - 2);
		}
		return m[n];
	}
}

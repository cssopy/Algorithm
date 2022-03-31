package Algorithm.ETC;

import java.util.Scanner;

// 아파트를 층별로 노란색 파란색 페인트를 칠하되 노란색은 연속하여 칠할 수 있고 파란색은 없을때 가능한 방법의 수를 구하는 문제
public class 노란색_파란색_페인트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 아파트 층 수
		int n = sc.nextInt();
		sc.close();

		int[] m = new int[n + 1];
		m[0] = 1;
		m[1] = 2;
		
		System.out.println(fibo(m, n));
	}

	public static int fibo(int[] m, int n) {
		if (n >= 2 && m[n] == 0) {
			return fibo(m, n - 1) + fibo(m, n - 2);
		}
		return m[n];
	}
}

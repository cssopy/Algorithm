package Algorithm.SWExpertAcademy.D3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Flatten (D3)
// 어지럽게 쌓여있는 상자들을 평탄화작업으로 정리했을때 제일 높은 상자와 제일 낮은 상자의 차이를 구하는 문제
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh
public class swEA_1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {
			int dc = sc.nextInt();
			List<Integer> hs = new ArrayList<>();
			for (int i = 0; i < 100; i++) {
				hs.add(sc.nextInt());
			}
			for (int i = 0; i < dc; i++) {
				int max = Collections.max(hs);
				int max_i = hs.indexOf(max);
				int min = Collections.min(hs);
				int min_i = hs.indexOf(min);
				
				hs.set(max_i, max - 1);
				hs.set(min_i, min + 1);
			}
			int result = Collections.max(hs) - Collections.min(hs);
			System.out.println("#" + (tc + 1) + " " + result);
		}
		
		sc.close();
	}
}

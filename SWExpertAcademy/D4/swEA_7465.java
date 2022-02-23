package Algorithm.SWExpertAcademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 창용 마을 무리의 개수 (D4)
// 창용 마을에 있는 무리의 개수를 구하는 문제
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU
public class swEA_7465 {
	// 집합 만들기, 처음에는 각 번호가 스스로 부모 및 루트번호
	public static int[] makeSet(int N) {
		int[] parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		return parents;
	}

	// a의 루트번호 찾는 재귀함수
	public static int findSet(int[] parents, int a) {
		// a가 타고 올라온 숫자(끝까지 간 숫자)가 부모와 같다면(=결국 루트숫자에 도달했다면) 해당 숫자 반환
		if (a == parents[a])
			return a;
		// a의 부모숫자를 기준으로 다시 findSet함수 호출
		return parents[a] = findSet(parents, parents[a]);
	}

	public static boolean union(int[] parents, int a, int b) {
		int aRoot = findSet(parents, a);
		int bRoot = findSet(parents, b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			// 마을 사람의 수
			int N = Integer.parseInt(st.nextToken());
			// 사람의 관계 수
			int M = Integer.parseInt(st.nextToken());

			int[] parents = makeSet(N);
			for (int mc = 0; mc < M; mc++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				union(parents, a, b);
			}

			for (int i = 1; i <= N; i++) {
				findSet(parents, i);
			}
			
			Set<Integer> set = new HashSet<>();
			for (int i = 1; i <= N; i++) {
				set.add(parents[i]);
			}
			sb.append("#" + (tc + 1) + " " + set.size() + "\n");
		}
		System.out.println(sb.toString());
	}
}

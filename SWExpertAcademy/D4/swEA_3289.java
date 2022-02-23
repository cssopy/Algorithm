package Algorithm.SWExpertAcademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 서로소 집합 (D4)
// 서로소 집합을 구성하여 사용자가 원하는 연산(집합 합치기, 둘이 같은 집합인지)을 수행하는 문제
// https://swexpertacademy.com/main/talk/solvingClub/clubView.do?solveclubId=AX5M8LAaEvwDFASv
public class swEA_3289 {
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

		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			sb.append("#" + (tc + 1) + " ");

			st = new StringTokenizer(br.readLine());
			// 집합의 개수
			int n = Integer.parseInt(st.nextToken());
			// 연산의 개수
			int m = Integer.parseInt(st.nextToken());

			// 해당 숫자의 부모가 누군지 저장할 배열
			int[] parents = makeSet(n);
			// m번의 연산 입력
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				// 연산의 종류
				int k = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				switch (k) {
				case 0:
					union(parents, a, b);
					break;
				case 1:
					sb.append((findSet(parents, a) == findSet(parents, b)) ? 1 : 0);
					break;
				}
			}

			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}

package Algorithm.SWExpertAcademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 준환이의 양팔저울 (D4)
// N개의 서로 다른 저울추들을 무게추의 왼,오른쪽 팔에 순서를 생각하여 올릴 수 있는 경우의 수 (오른팔의 무게추 합은 왼팔의 무게추 합보다 크면 안된다)
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWAe7XSKfUUDFAUw
public class swEA_3234_np {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 테스트케이스 수
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			// 무게추 수
			int N = Integer.parseInt(br.readLine());
			// 무게추 저장 배열
			int[] inps = new int[N];
			st = new StringTokenizer(br.readLine());
			// 무게추 입력
			for (int nc = 0; nc < N; nc++) {
				inps[nc] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(inps);
			
			int[] ans = new int[1];
			do {
				solve(inps, N, 0, 0, 0, ans);
			} while (np(inps, N));
			
			sb.append("#" + (tc + 1) + " " + ans[0] + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void solve(int[] inps, int N, int cnt, int ls, int rs, int[] ans) {
		if (cnt == N) {
			ans[0]++;
			return;
		}

		solve(inps, N, cnt + 1, ls + inps[cnt], rs, ans);
		if (rs + inps[cnt] <= ls) {
			solve(inps, N, cnt + 1, ls, rs + inps[cnt], ans);
		}
	}
	
	private static boolean np(int[] inps, int N) {
		// 1. 교환위치 찾기
		int i = N - 1;
		while (i > 0 && inps[i - 1] >= inps[i])
			i--;

		if (i == 0)
			return false;

		// 2. 교환위치에 교환할 값 찾기
		int j = N - 1;
		while (inps[i - 1] >= inps[j])
			j--;

		// 3. 교환위치와 교환할 값 교환하기
		swap(inps, i - 1, j);

		// 4. 교환위치 뒤(꼭대기)부터 맨 뒤까지 만들수 있는 가장 작은 순열 생성(오름차순 정렬)
		int k = N - 1;
		while (i < k) {
			swap(inps, i++, k--);
		}

		return true;
	}

	public static void swap(int[] inps, int i, int j) {
		int temp = inps[i];
		inps[i] = inps[j];
		inps[j] = temp;
	}
}

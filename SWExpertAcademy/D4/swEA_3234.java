package Algorithm.SWExpertAcademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 준환이의 양팔저울 (D4)
// N개의 서로 다른 저울추들을 무게추의 왼,오른쪽 팔에 순서를 생각하여 올릴 수 있는 경우의 수 (오른팔의 무게추 합은 왼팔의 무게추 합보다 크면 안된다)
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWAe7XSKfUUDFAUw
public class swEA_3234 {
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
			solve(inps, N, 0, 0, 0, new boolean[N], ans);
			sb.append("#" + (tc + 1) + " " + ans[0] + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void solve(int[] inps, int N, int cnt, int ls, int rs, boolean[] isSel, int[] ans) {
		if (cnt == N) {
			ans[0]++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!isSel[i]) {
				isSel[i] = true;
				solve(inps, N, cnt + 1, ls + inps[i], rs, isSel, ans);
				if(rs + inps[i] <= ls) {
					solve(inps, N, cnt + 1, ls, rs + inps[i], isSel, ans);
				}
				isSel[i] = false;
			}
		}
	}
}

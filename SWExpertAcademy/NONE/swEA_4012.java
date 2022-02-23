package Algorithm.SWExpertAcademy.NONE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 요리사
// N개의 재료중 N/2개씩 재료들을 선택해 두가지 요리를 만들어 두 요리의 맛 차이의 최소값을 구하는 문제
// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AWIeUtVakTMDFAVH&solveclubId=AX5M8LAaEvwDFASv&problemBoxTitle=02%EC%9B%94+16%EC%9D%BC&problemBoxCnt=2&probBoxId=AX7_0-IaObEDFARO
public class swEA_4012 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			// 재료의 수
			int N = Integer.parseInt(br.readLine());
			// 식재료간의 시너지를 저장할 이차원 배열
			int[][] ing = new int[N][N];
			// 식재료간의 시너지 입력
			for (int nc = 0; nc < N; nc++) {
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < N; i++) {
					ing[nc][i] = Integer.parseInt(st.nextToken());
				}
			}

			// 정답 변수, 무한대로 초기화
			int[] ans = { (int) Double.POSITIVE_INFINITY };
			solve(0, 0, N, ing, new int[N / 2], ans);

			sb.append("#" + (tc + 1) + " " + ans[0] + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void solve(int cnt, int start, int N, int[][] ing, int[] isSel, int[] ans) {
		// N개의 재료중 N/2개의 재료를 선택했다면
		if (cnt == N / 2) {
			// isntSel 배열에 선택하지 않은 재료들 넣기
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < isSel.length; i++) {
				set.add(isSel[i]);
			}
			int[] isntSel = new int[N / 2];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if (!set.contains(i))	isntSel[idx++] = i;
			}
			
			// sng1:선택 된 재료들의 시너지 합
			// sng2:선택되진 못한 재료들의 시너지 합
			int sng1 = 0, sng2 = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = i + 1; j < N / 2; j++) {
					sng1 += ing[isSel[i]][isSel[j]] + ing[isSel[j]][isSel[i]];
					sng2 += ing[isntSel[i]][isntSel[j]] + ing[isntSel[j]][isntSel[i]];
				}
			}
			ans[0] = Math.min(ans[0], Math.abs(sng1 - sng2));
			return;
		}

		for (int i = start; i < N; i++) {
			isSel[cnt] = i;
			solve(cnt + 1, i + 1, N, ing, isSel, ans);
		}
	}
}
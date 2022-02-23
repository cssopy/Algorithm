package Algorithm.SWExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 규영이와 인영이의 카드게임 (D3)
// 규영이와 인영이가 각각 9장의 카드로 점수를 내어 대결할때 규영이가 이긴 횟수와 진 횟수를 구하는 문제
// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5M8LAaEvwDFASv&contestProbId=AWgv9va6HnkDFAW0&probBoxId=AX73EelaxLoDFARO&type=PROBLEM&problemBoxTitle=02%EC%9B%94+14%EC%9D%BC&problemBoxCnt=1
public class swEA_6808_Permutation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			// 규영이의 카드를 저장할 배열
			int[] gy = new int[9];
			// 인영이의 카드를 저장할 배열
			int[] iy = new int[9];

			Set<Integer> set = new HashSet<>();

			// 규영이의 카드정보 입력
			for (int i = 0; i < 9; i++) {
				gy[i] = Integer.parseInt(st.nextToken());
				set.add(gy[i]);
			}

			// 인영이의 카드정보 입력
			int ii = 0;
			for (int i = 1; i <= 18; i++) {
				if (!set.contains(i))	iy[ii++] = i;
			}
			
			int[] gyvl = new int[2];
			permutation(0, 0, new int[9], gy, iy, gyvl);
			
			sb.append("#" + (tc + 1) + " " + gyvl[0] + " " + gyvl[1] + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void permutation(int cnt, int flag, int[] numbers, int[] gy, int[] iy, int[] gyvl) {
		if (cnt == 9) {
			int gys = 0;
			int iys = 0;
			for (int i = 0; i < 9; i++) {
				if (gy[i] > numbers[i])	gys += gy[i] + numbers[i];
				else					iys += gy[i] + numbers[i];
			}
			if (gys > iys)	gyvl[0]++;
			else			gyvl[1]++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if ((flag & 1 << i) != 0)	continue;

			numbers[cnt] = iy[i];
			permutation(cnt + 1, flag | 1 << i, numbers, gy, iy, gyvl);
		}
	}
}
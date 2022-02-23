package Algorithm.SWExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 규영이와 인영이의 카드게임 (D3)
// 규영이와 인영이가 각각 9장의 카드로 점수를 내어 대결할때 규영이가 이긴 횟수와 진 횟수를 구하는 문제
// https://swexpertacademy.com/main/talk/solvingClub/clubView.do?solveclubId=AX5M8LAaEvwDFASv
public class swEA_6808_NextPermutation {
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
			
			Arrays.sort(iy);
			
			int[] gyvl = new int[2];
			do {
				int gys = 0;
				int iys = 0;
				for (int i = 0; i < 9; i++) {
					if(gy[i] > iy[i]) {
						gys += gy[i] + iy[i];
					} else {
						iys += gy[i] + iy[i];
					}
				}
				if (gys > iys) {
					gyvl[0]++;
				} else {
					gyvl[1]++;
				}
			} while (np(iy, 9));
			
			sb.append("#" + (tc + 1) + " " + gyvl[0] + " " + gyvl[1] + "\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean np(int[] iy, int N) {
		// 1. 교환위치 찾기
		int i = N - 1;
		while (i > 0 && iy[i - 1] >= iy[i])
			i--;

		if (i == 0)
			return false;

		// 2. 교환위치에 교환할 값 찾기
		int j = N - 1;
		while (iy[i - 1] >= iy[j])
			j--;

		// 3. 교환위치와 교환할 값 교환하기
		swap(iy, i - 1, j);

		// 4. 교환위치 뒤(꼭대기)부터 맨 뒤까지 만들수 있는 가장 작은 순열 생성(오름차순 정렬)
//		int k = N - 1;
//		while (i < k) {
//			swap(iy, i++, k--);
//		}
		
		// 4번과 동일한 기능
		Arrays.sort(iy, i, 9);

		return true;
	}

	public static void swap(int[] iy, int i, int j) {
		int temp = iy[i];
		iy[i] = iy[j];
		iy[j] = temp;
	}
}
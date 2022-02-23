package Algorithm.SWExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백만 장자 프로젝트 (D2)
// 원재의 사재기를 도와 최대의 이익을 얻게 도와주는 문제
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LrsUaDxcDFAXc&categoryId=AV5LrsUaDxcDFAXc&categoryType=CODE&problemTitle=1859&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
public class swEA_1859 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 총 매매가의 수
			int N = Integer.parseInt(br.readLine());

			// 매매가를 저장할 배열
			int[] inps = new int[N];
			st = new StringTokenizer(br.readLine());
			// 매매가 입력
			for (int nc = 0; nc < N; nc++) {
				inps[nc] = Integer.parseInt(st.nextToken());
			}

			sb.append("#" + tc + " " + solve(0, inps, 0) + "\n");
		}
		System.out.println(sb.toString());
	}

	public static long solve(int si, int[] inps, long revenue) {
		// si부터 끝까지 inps의 최대값의 위치를 구함
		int midx = 0;
		int max = 0;
		for (int i = si; i < inps.length; i++) {
			if (inps[i] > max) {
				max = inps[i];
				midx = i;
			}
		}

		// si부터 최대값 이전까지 구입을 함
		int bg = 0;
		int c = 0;
		for (int i = si; i < midx; i++) {
			bg -= inps[i];
			c++;
		}

		// revenuw에 si부터 최대값까지 거래시의 이득을 더함
		revenue += (inps[midx] * c) + bg;

		// 찾은 최대값의 위치가 마지막이라면 return, 아니라면 최대값 다음 인덱스부터 반복
		if (midx == inps.length - 1) {
			return revenue;
		} else {
			return solve(midx + 1, inps, revenue);
		}
	}
}

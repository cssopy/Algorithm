package Algorithm.BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
a
// 감시 (골드 5)
// map에 cctv의 배치에서 나올 수 있는 사각지대의 최소값을 구하는 문제
// https://www.acmicpc.net/problem/15683
public class BJ_15683_00000000000000 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		// 사무실의 세로 크기
		int N = Integer.parseInt(st.nextToken());
		// 사무실의 가로 크기
		int M = Integer.parseInt(st.nextToken());

		List<CCTV> cctvs = new ArrayList<BJ_15683_00000000000000.CCTV>();
		char[][] map = new char[N][M];
		// map 입력
		for (int nc = 0; nc < N; nc++) {
			st = new StringTokenizer(br.readLine());
			for (int mc = 0; mc < M; mc++) {
				map[nc][mc] = st.nextToken().charAt(0);
				if (map[nc][mc] != '6' && map[nc][mc] != '0') {
					cctvs.add(new CCTV(nc, mc, map[nc][mc] - '0'));
				}
			}
		}
		
		System.out.println(cctvs);
	}

	public static class CCTV {
		int i;
		int j;
		int type;
		int dc;

		public CCTV(int i, int j, int type) {
			super();
			this.i = i;
			this.j = j;
			this.type = type;
			
			switch (this.type) {
				case 1:
				case 3:
				case 4:
					this.dc = 4;
					break;
				case 2:
					this.dc = 2;
					break;
				case 5:
					this.dc = 1;
					break;
			}
		}

		@Override
		public String toString() {
			return i + " " + j + " " + type+" "+dc;
		}
	}
}

package Algorithm.BAEKJOON.GOLD_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 치킨 배달 (골드 5)
// 치킨 집 중 M개의 치킨집을 골랐을 때 도시의 치킨 거릐의 최솟값을 구하는 문제
// https://www.acmicpc.net/problem/15686
public class BJ_15686 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 도시의 크기
		int N = Integer.parseInt(st.nextToken());
		// 고를 치킨 집의 수
		int M = Integer.parseInt(st.nextToken());

		// 치킨 집 위치들
		List<Point> chickens = new ArrayList<>();
		// 집 위치들
		List<Point> houses = new ArrayList<>();
		// 입력을 받아 치킨, 집 리스트에 위치 추가
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int inp = Integer.parseInt(st.nextToken());
				switch (inp) {
				case 1:
					houses.add(new Point(i, j));
					break;
				case 2:
					chickens.add(new Point(i, j));
					break;
				}
			}
		}

		int[] ans = { Integer.MAX_VALUE };
		solve(0, 0, M, N, houses.toArray(new Point[houses.size()]), chickens.toArray(new Point[chickens.size()]),
				new Point[M], ans);

		System.out.println(ans[0]);
	}
	
	// 위치정보와 두 점의 거리를 구하는 class
	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		public int getDis(Point p) {
			return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
		}
	}

	// 치킨집 중 m개를 선택하는 재귀함수
	public static void solve(int cnt, int s, int M, int N, Point[] houses, Point[] chickens, Point[] sels, int[] ans) {
		// 치킨집이 m개 선택됐을때
		if (cnt == M) {
			ans[0] = Math.min(ans[0], getMinDis(houses, sels));
			return;
		}

		for (int i = s; i < chickens.length; i++) {
			sels[cnt] = chickens[i];
			solve(cnt + 1, i + 1, M, N, houses, chickens, sels, ans);
		}
	}

	// 선택된 m개의 치킨집과 집들 사이의 최소거리를 구함
	public static int getMinDis(Point[] houses, Point[] chickens) {
		int md = 0;
		for (int i = 0; i < houses.length; i++) {
			int ehmd = Integer.MAX_VALUE;
			for (int j = 0; j < chickens.length; j++) {
				ehmd = Math.min(ehmd, houses[i].getDis(chickens[j]));
			}
			md += ehmd;
		}
		return md;
	}
}

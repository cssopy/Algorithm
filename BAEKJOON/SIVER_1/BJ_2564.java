package Algorithm.BAEKJOON.SIVER_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경비원 (실버 1)
// 어떤 사각형 모서리에 경비원과 상점들이 있을때 각 상점들마다의 최소거리의 합을 구하는 문제
// https://www.acmicpc.net/problem/2564
public class BJ_2564 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] map_size = new int[2];
		st = new StringTokenizer(br.readLine());
		map_size[0] = Integer.parseInt(st.nextToken());
		map_size[1] = Integer.parseInt(st.nextToken());

		int st_n = Integer.parseInt(br.readLine());
		Point[] stores = new Point[st_n];
		for (int i = 0; i < st_n; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			stores[i] = new Point(dir, val, map_size);
		}

		st = new StringTokenizer(br.readLine());
		Point DG;
		int dir = Integer.parseInt(st.nextToken());
		int val = Integer.parseInt(st.nextToken());
		DG = new Point(dir, val, map_size);

		int sum = 0;
		for (int i = 0; i < st_n; i++) {
			if ((DG.dir + stores[i].dir) == 3 || (DG.dir + stores[i].dir) == 7) {
				int a = (DG.x + stores[i].x) + (DG.y + stores[i].y);
				int b = ((2 * map_size[1]) - (DG.x + stores[i].x)) + ((2 * map_size[0]) - (DG.y + stores[i].y));
				sum += Math.min(a, b);
			} else {
				sum += Math.abs(DG.x - stores[i].x) + Math.abs(DG.y - stores[i].y);
			}
		}
		System.out.println(sum);
	}
}

class Point {
	int x;
	int y;
	int dir;

	public Point(int dir, int val, int[] map_size) {
		this.dir = dir;
		switch (dir) {
		case 1:
			this.x = 0;
			this.y = val;
			break;
		case 2:
			this.x = map_size[1];
			this.y = val;
			break;
		case 3:
			this.x = val;
			this.y = 0;
			break;
		case 4:
			this.x = val;
			this.y = map_size[0];
			break;
		}
	}
}
package Algorithm.BAEKJOON.GOLD_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 게리맨더링
// https://www.acmicpc.net/problem/17471
public class BJ_17471 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 구역의 수
		int N = Integer.parseInt(br.readLine());

		// 각 구역의 인구수
		int[] pl = new int[N];
		// 모든 구역 인구수 합
		int apl = 0;
		st = new StringTokenizer(br.readLine());
		for (int nc = 0; nc < N; nc++) {
			pl[nc] = Integer.parseInt(st.nextToken());
			apl += pl[nc];
		}

		// 인접 리스트
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		for (int nc = 0; nc < N; nc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			for (int vc = 0; vc < V; vc++) {
				int nv = Integer.parseInt(st.nextToken());
				list.get(nc).add(nv - 1);
			}
		}

		int[] ans = { Integer.MAX_VALUE };
		for (int i = 1; i <= N / 2; i++) {
			combi(0, 0, i, N, new boolean[N], pl, list, apl, 0, ans);
		}

		if (ans[0] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans[0]);
		}
	}

	public static void combi(int cnt, int s, int sc, int N, boolean[] isSel, int[] pl, List<List<Integer>> list,
			int apl, int spl, int[] ans) {
		if (cnt == sc) {
			if (Math.abs(spl - (apl - spl)) < ans[0] && isShareable(isSel, sc, list)) {
				ans[0] = Math.abs(spl - (apl - spl));
			}
			return;
		}

		for (int i = s; i < N; i++) {
			isSel[i] = true;
			combi(cnt + 1, i + 1, sc, N, isSel, pl, list, apl, spl + pl[i], ans);
			isSel[i] = false;
		}
	}

	public static boolean isShareable(boolean[] isSel, int sc, List<List<Integer>> list) {
		Queue<Integer> que = new LinkedList<>();
		for (int i = 0; i < isSel.length; i++) {
			if (isSel[i]) {
				que.offer(i);
				break;
			}
		}

		boolean[] isVisited = new boolean[isSel.length];

		int cnt = 0;
		while (!que.isEmpty()) {
			int cur = que.poll();

			if (isVisited[cur]) {
				continue;
			}

			isVisited[cur] = true;
			cnt++;

			for (int i = 0; i < list.get(cur).size(); i++) {
				if (isSel[list.get(cur).get(i)] && !isVisited[list.get(cur).get(i)]) {
					que.offer(list.get(cur).get(i));
				}
			}
		}

		if (cnt != sc) {
			return false;
		}

		que.clear();
		for (int i = 0; i < isSel.length; i++) {
			if (!isSel[i]) {
				que.offer(i);
				break;
			}
		}

		isVisited = new boolean[isSel.length];

		cnt = 0;
		while (!que.isEmpty()) {
			int cur = que.poll();

			if (isVisited[cur]) {
				continue;
			}

			isVisited[cur] = true;
			cnt++;

			for (int i = 0; i < list.get(cur).size(); i++) {
				if (!isSel[list.get(cur).get(i)] && !isVisited[list.get(cur).get(i)]) {
					que.offer(list.get(cur).get(i));
				}
			}
		}

		if (cnt != isSel.length - sc) {
			return false;
		}

		return true;
	}
}

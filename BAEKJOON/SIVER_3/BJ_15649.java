package Algorithm.BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (실버 3)
// 자연수 N과 M이 주어졌을때 N개의 숫자중 M개의 수열을 모두 구하는 문제
// https://www.acmicpc.net/problem/15649
public class BJ_15649 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		permu(0, N, M, new boolean[N + 1], new int[M], sb);
		
		System.out.println(sb.toString());
	}

	// 순열 함수
	public static void permu(int cnt, int N, int M, boolean[] isSel, int[] ans, StringBuilder sb) {
		// M개의 숫자를 뽑았다면 종료
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}

		// 1부터 N까지 중 선택을 할때 이미 선택했던 숫자면 다음 숫자로, 아니라면 해당 숫자를 선택후 permu재귀호출
		for (int i = 1; i <= N; i++) {
			if (isSel[i])	continue;
			isSel[i] = true;
			ans[cnt] = i;
			permu(cnt + 1, N, M, isSel, ans, sb);
			isSel[i] = false;
		}
	}
}

package Algorithm.BAEKJOON.BRONZE_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 블랙잭 (브론즈 2)
// N장의 카드중 M을 넘지 않으면서 M에 최대한 가까운 3장의 카드를 고르는 문제
// https://www.acmicpc.net/status?from_mine=1&problem_id=2798&user_id=cssopy
public class BJ_2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 카드의 수
		int N = Integer.parseInt(st.nextToken());
		// 목표 값
		int M = Integer.parseInt(st.nextToken());

		// 카드를 저장할 배열
		int[] cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		// 정답
		int[] ans = new int[1];
		combi(0, 0, 3, cards, N, M, 0, ans);
		
		System.out.println(ans[0]);
	}

	// cards에 있는 카드중 three개를 고르는 조합을 구하는 함수
	public static void combi(int cnt, int s, int three, int[] cards, int N, int M, int hab, int[] ans) {
		if (cnt == three) {
			ans[0] = Math.max(ans[0], hab);
			return;
		}

		for (int i = s; i < N; i++) {
			// 현재 hab에 해당 카드를 더했을때 M보다 커지면 그 경우는 더이상 고려할 필요 없음
			if (hab + cards[i] <= M) {
				combi(cnt + 1, i + 1, three, cards, N, M, hab + cards[i], ans);
			}
		}
	}
}

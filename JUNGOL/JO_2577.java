package Algorithm.JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 회전 초밥(고)
// http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1838
public class JO_2577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 접시의 수
		int N = Integer.parseInt(st.nextToken());
		// 초밥의 가짓수
		int D = Integer.parseInt(st.nextToken());
		// 연속해서 먹는 접시의 수
		int K = Integer.parseInt(st.nextToken());
		// 쿠폰 번호
		int C = Integer.parseInt(st.nextToken());

		int[] sushis = new int[N];
		for (int nc = 0; nc < N; nc++) {
			sushis[nc] = Integer.parseInt(br.readLine());
		}

		int[] ans = { 0 };
		solve(sushis, D, K, C, ans);

		System.out.println(ans[0]);
	}

	public static void solve(int[] sushis, int D, int K, int C, int[] ans) {
		// 특정 번호의 초밥 몇번 먹었는지 세기위한 배열
		int[] eat = new int[D + 1];

		// 중복되지 않는 먹은 초밥의 개수
		int cnt = 0;
		// 처음엔 초밥 0번부터 K개를 먹음
		for (int i = 0; i < K; i++) {
			// 아직 한번도 안먹었던 초밥이면 cnt++
			if (eat[sushis[i]] == 0) {
				cnt++;
			}
			eat[sushis[i]]++;
		}

		// 쿠폰 처리, 쿠폰 번호 C의 초밥을 안 먹었다면 cnt에 1을 더한값과 비교
		if (eat[C] == 0) {
			ans[0] = Math.max(ans[0], cnt + 1);
		} else {
			ans[0] = Math.max(ans[0], cnt);
		}

		for (int i = K; i < sushis.length + K - 1; i++) {
			// 가장 처음에 먹은것 뱉기
			eat[sushis[(i - K) % sushis.length]]--;
			if (eat[sushis[(i - K) % sushis.length]] == 0) {
				cnt--;
			}

			// 다음 초밥 먹기
			if (eat[sushis[i % sushis.length]] == 0) {
				cnt++;
			}
			eat[sushis[i % sushis.length]]++;

			// 쿠폰 처리
			if (eat[C] == 0) {
				ans[0] = Math.max(ans[0], cnt + 1);
			} else {
				ans[0] = Math.max(ans[0], cnt);
			}
		}
	}
}

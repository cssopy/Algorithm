package Algorithm.BAEKJOON.BRONZE_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 영식이와 친구들 (브론즈 2)
// 영식이와 친구들이 원형으로 둘러앉아 공을 주고 받을때 누군가 총 M번이나 받으면 행위를 중단한다. 그때의 공을 던진 횟수를 구하는 문제
// https://www.acmicpc.net/problem/1592
public class BJ_1592 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 사람의 수
		int N = Integer.parseInt(st.nextToken());
		// 최대 공을 받을 횟수
		int M = Integer.parseInt(st.nextToken());
		// 시계 또는 반시계 방향으로 L번째에 던짐
		int L = Integer.parseInt(st.nextToken());

		// 각 사람들이 공을 받은 횟수
		int[] rec = new int[N];
		// 1번이 처음 공을 가지고 있기에 카운팅
		int idx = 0;
		rec[idx] = 1;

		// 공을 던진 횟수
		int ans = 0;
		while (true) {
			// 공을 받은 사람이 M번이나 받았다면 종료
			if (rec[idx] == M) {
				break;
			}
			
			// 현재 사람이 받은 횟수가 홀수이면
			if (rec[idx] % 2 != 0) {
				idx = (idx + L + N) % N;
			}
			// 현재 사람이 받은 횟수가 짝수이면
			else {
				idx = (idx - L + N) % N;
			}

			// 공을 던짐
			ans++;
			// 공을 받은 사람의 공을 받은 횟수 증가
			rec[idx]++;
		}

		System.out.println(ans);
	}
}

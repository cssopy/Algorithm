package Algorithm.BAEKJOON.GOLD_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 암호 만들기 (골드 5)
// 주어진 알파벳으로 모음은 최소 1개이상, 자음은 최소 2개이상을 사용해 만들 수 있는 모든 암호를 구하는 문제
// https://www.acmicpc.net/problem/1759
public class BJ_1759 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		// 암호의 길이
		int L = Integer.parseInt(st.nextToken());
		// 문자의 개수
		int C = Integer.parseInt(st.nextToken());

		// 입력된 문자 저장할 배열
		char[] inps = new char[C];

		// 문자 입력
		st = new StringTokenizer(br.readLine());
		for (int cc = 0; cc < C; cc++) {
			inps[cc] = st.nextToken().charAt(0);
		}

		// 문자 알파벳순 정렬
		Arrays.sort(inps);

		solve(0, 0, L, C, inps, new char[C], 0, 0, sb);
		
		System.out.println(sb.toString());
	}

	// 모음 모음 set
	static Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

	public static void solve(int cnt, int s, int L, int C, char[] inps, char[] sels, int mac, int jac,
			StringBuilder sb) {
		// 만약 남아있는 자리의 수를 고려해 그 수가 필요한 모음수와 자음수보다 적으면 return
		if (L - cnt < 1 - mac || L - cnt < 2 - jac)	return;

		// 문자를 L개 뽑았다면(=암호를 완성했다면) sb에 append
		if (cnt == L) {
			for (int i = 0; i < cnt; i++) {
				sb.append(sels[i]);
			}
			sb.append("\n");
			return;
		}

		for (int i = s; i < C; i++) {
			sels[cnt] = inps[i];
			// 해당 문자가 모음이면 mac에 1을 더해서 재귀, 모음이 아니면 jac에 1을 더하여 재귀
			if (set.contains(sels[cnt])) {
				solve(cnt + 1, i + 1, L, C, inps, sels, mac + 1, jac, sb);
			} else {
				solve(cnt + 1, i + 1, L, C, inps, sels, mac, jac + 1, sb);
			}
		}
	}
}

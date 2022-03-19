package Algorithm.BAEKJOON.SIVER_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 크로아티아 알파벳
// 들어오는 입력에 크라오티아 알파벳과 그냥 알파벳이 몇 개인지 구하는 문제
// https://www.acmicpc.net/problem/2941
public class BJ_2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 크로아티아 알파벳 집합
		Set<String> set = new HashSet<>();
		set.add("c=");
		set.add("c-");
		set.add("dz=");
		set.add("d-");
		set.add("lj");
		set.add("nj");
		set.add("s=");
		set.add("z=");

		// 입력
		String inp = br.readLine();

		// 정답
		int[] ans = new int[1];
		// 최대값으로 둔 이유는 크로아티아 알파벳을 알차게? 썼다면 solve함수에서 헤아린 알파벳수는 최소가 될것이기 때문
		ans[0] = Integer.MAX_VALUE;
		solve(inp, set, 0, ans);

		System.out.println(ans[0]);
	}

	// 들어온 inp에 대해 첫문자부터 더해가면서 더한 문자열이 크로아티아 알파벳인지 그냥 알파벳인지 확인하여 헤아리는 함수
	public static void solve(String inp, Set<String> set, int c, int[] ans) {
		// 백트랙킹
		if (c > ans[0]) {
			return;
		}

		// 다 헤아렸다면 함수 종료
		if (inp.equals("")) {
			ans[0] = c;
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < inp.length(); i++) {
			// inp문자열에 첫문자부터 하나씩 sb에 append
			sb.append(inp.charAt(i));
			// 만약 sb가 크로아티아 알파벳이라면 다음 인덱스부터 문자열을 잘라서 solve함수 재호출
			if (set.contains(sb.toString())) {
				solve(inp.substring(i + 1), set, c + 1, ans);
				// 크로아티아 알파벳을 찾았다면 더이상 인덱스를 늘려가면서 할 이유가 없기때문에 return
				return;
			}
		}

		// for 반복문을 다 돌았다면 inp의 첫문자로 시작하는 크로아티아 알파벳을 찾지 못했으므로 첫문자는 그냥 헤아리고 다음 위치부터의 문자열로 solve 재호출
		sb = new StringBuilder();
		sb.append(inp.charAt(0));
		solve(inp.substring(1), set, c + 1, ans);
	}
}

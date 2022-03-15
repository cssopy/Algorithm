package Algorithm.BAEKJOON.SIVER_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Z (실버 1)
// 2^N x 2^N 크기의 맵 이 주어졌을때 Z모양꼴로 r행 c열을 몇 번째로 방문했는지 구하는 문제
// https://www.acmicpc.net/problem/1074
public class BJ_1074 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 맵의 크기를 결정하는 변수
		int N = Integer.parseInt(st.nextToken());
		// 행
		int r = Integer.parseInt(st.nextToken()) + 1;
		// 열
		int c = Integer.parseInt(st.nextToken()) + 1;

		// 맵 한변의 길이
		int ml = (int) Math.pow(2, N);

		// 재귀 시작
		solve(ml, r, c, 0, (int) Math.pow(ml, 2));
	}

	// 재귀를 통해 인덱스와 0~(2^N)^2 범위의 값들을 4분할했을경우의 인덱스와 범위로 재초기화
	// N:맵의 한변의 크기, r:row인덱스, c:col인덱스, s:시작 값, e:끝 값
	public static void solve(int N, int r, int c, int s, int e) {
		// map 크기가 2x2 가 되면 row,col 인덱스에 따라 해당하는 정답을 출력
		if(N==2) {
			r -= 1;
			c -= 1;
			System.out.println(s + ((2 * r) + c));
			return;
		}
		
		// 다음 맵의 한변의 크기
		int nN = N / 2;
		// 다음 row인덱스
		int nr = (r > nN) ? (r - nN) : r;
		// 다음 col인덱스
		int nc = (c > nN) ? (c - nN) : c;
		
		int sc = 0, cc = 0;
		if (r > nN)	sc = 2;
		if (c > nN)	cc = 1;

		// 다음 시작 값
		int ns = s + ((int) (sc * Math.pow(N, 2) / 4) + (int) (cc * Math.pow(N, 2) / 4));
		// 다음 끝 값
		int ne = ns + (int) (Math.pow(N, 2) / 4) - 1;
		
		solve(nN, nr, nc, ns, ne);
	}
}

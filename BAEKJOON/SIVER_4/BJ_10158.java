package Algorithm.BAEKJOON.SIVER_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 개미 (실버 4)
// 격자 공간에서 개미가 t시간 지났을때의 위치를 구하는 문제
// 정공법으로 풀면 시간초과가 나옴, 가로, 세로를 따로보고 어떤 시간이 지나면 결국 제자리라는 점을 이용
// https://www.acmicpc.net/problem/10158
public class BJ_10158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] pos = new int[2];
		st = new StringTokenizer(br.readLine());
		pos[0] = Integer.parseInt(st.nextToken());
		pos[1] = Integer.parseInt(st.nextToken());

		int T = Integer.parseInt(br.readLine());

		int x = (pos[0] + T) % (2 * W);
		int y = (pos[1] + T) % (2 * H);

		x = W - Math.abs(W - x);
		y = H - Math.abs(H - y);

		System.out.println(x + " " + y);
	}
}

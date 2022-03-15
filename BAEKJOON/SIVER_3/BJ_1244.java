package Algorithm.BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스위치 켜고 끄기 (실버 3)
// 성별에 따른 규칙이 적용되어 최종적으로 바뀌게 되는 스위치상태 구하기
// https://www.acmicpc.net/problem/1244
public class BJ_1244 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 스위치 개수
		int N = Integer.parseInt(br.readLine());
		// 스위치 상태 저장 배열
		int[] swchs = new int[N + 1];

		// 스위치 상태 입력
		st = new StringTokenizer(br.readLine());
		for (int nc = 1; nc <= N; nc++) {
			swchs[nc] = Integer.parseInt(st.nextToken());
		}

		// 학생 수
		int stn = Integer.parseInt(br.readLine());
		for (int stc = 0; stc < stn; stc++) {
			st = new StringTokenizer(br.readLine());
			// 학생의 성별
			int S = Integer.parseInt(st.nextToken());

			// 학생이 받은 수
			int I = Integer.parseInt(st.nextToken());

			changeSwichState(swchs, S, I, N);
		}
		
		for (int nc = 1; nc <= N; nc++) {
			System.out.print(swchs[nc]+" ");
			if (nc % 20 == 0)	System.out.println();
		}
	}

	// 학생의 성별(S)과 받은 수(I)에 따라 스위치 상태(swchs)를 바꾸는 함수
	public static void changeSwichState(int[] swchs, int S, int I, int N) {
		// 성별이 남성일 경우
		if (S == 1) {
			// 번호를 다음 배수로 늘리면서 해당 번호의 스위치를 반대값으로 초기화
			// 번호가 범위를 벗어나면 break
			int f = I;
			while (true) {
				swchs[I] = (swchs[I] + 1) % 2;
				I += f;
				if (I > N)	break;
			}
		} 
		// 성별이 여성일 경우
		else {
			int f = 1;
			swchs[I] = (swchs[I] + 1) % 2;
			
			// 좌우 간격(f)를 늘리면서 현재 위치 좌우(I+-f)번호에 상태를 반대값으로 초기화
			// 좌우 간격이 범위를 벗어나거나 좌우 상태가 다를경우 break
			while (true) {
				if (((I - f < 1) || (I + f > N)))	break;
				if (swchs[I - f] != swchs[I + f])	break;
				
				swchs[I - f] = (swchs[I - f] + 1) % 2;
				swchs[I + f] = (swchs[I + f] + 1) % 2;
				f++;
			}
		}
	}
}

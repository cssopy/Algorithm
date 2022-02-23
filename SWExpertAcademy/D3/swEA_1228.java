package Algorithm.SWExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 암호문1 (D3)
// 어떤 암호문에 어떤 연산들을 했을때 최종 암호문을 구하는 문제
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD
public class swEA_1228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		List<Integer> org_text = new LinkedList<>();

		int T = 10;
		int N;
		int x, y;
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), " ");
			for (int nc = 0; nc < N; nc++) {
				org_text.add(Integer.parseInt(st.nextToken()));
			}

			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int nc = 0; nc < N; nc++) {
				st.nextToken();
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				for (int yc = 0; yc < y; yc++) {
					org_text.add(x++, Integer.parseInt(st.nextToken()));
				}
			}

			bw.write("#" + (tc + 1) + " ");
			for (int i = 0; i < 10; i++) {
				bw.write(org_text.get(i) + " ");
			}
			bw.flush();
			org_text.clear();
		}
		bw.close();
	}
}

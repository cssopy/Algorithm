package Algorithm.JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 별삼각형3
// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=608&sca=99&sfl=wr_hit&stx=1329
public class JO_1329 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		if (N % 2 != 0 && 0 <= N && N <= 100) {
			for (int i = 0, k = 1; i <= N / 2; i++, k += 2) {
				sb.append(repeat(' ', i));
				sb.append(repeat('*', k));
				sb.append("\n");
			}
			for (int i = N / 2 - 1, k = N - 2; i >= 0; i--, k -= 2) {
				sb.append(repeat(' ', i));
				sb.append(repeat('*', k));
				sb.append("\n");
			}
		} else {
			sb.append("INPUT ERROR!");
		}

		System.out.println(sb.toString());
	}

	public static String repeat(char c, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(c);
		}
		return sb.toString();
	}
}

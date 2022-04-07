package Algorithm.JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 홀수 마방진
// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1338&sca=99&sfl=wr_hit&stx=2074
public class JO_2074 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		String[][] map = new String[n][n];
		
		int i = 0;
		int j = n / 2;
		int cnt = 0;
		while (true) {
			map[i][j] = Integer.toString(++cnt);

			if (cnt == n * n) {
				break;
			}

			if (cnt % n == 0) {
				i = (i + 1) % n;
			} else {
				i = (i - 1 + n) % n;
				j = (j - 1 + n) % n;
			}
		}

		for (int k = 0; k < n; k++) {
			sb.append(String.join(" ", map[k]));
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
}

package Algorithm.JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 달팽이사각형
// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=980&sca=99&sfl=wr_hit&stx=1707
public class JO_1707 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		String[][] map = new String[n][n];

		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };

		int i = 0, j = 0;
		int dir = 0;
		int cnt = 0;
		while (true) {
			map[i][j] = Integer.toString(++cnt);

			if (cnt == n * n) {
				break;
			}

			int ni = i + di[dir];
			int nj = j + dj[dir];
			if (ni < 0 || ni >= n || nj < 0 || nj >= n || map[ni][nj] != null) {
				dir = (dir + 1) % 4;
				i = i + di[dir];
				j = j + dj[dir];
			} else {
				i = ni;
				j = nj;
			}
		}

		for (int k = 0; k < n; k++) {
			sb.append(String.join(" ", map[k]));
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
}

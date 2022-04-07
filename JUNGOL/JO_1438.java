package Algorithm.JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이(초)
// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=712&sca=99&sfl=wr_hit&stx=1438
public class JO_1438 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 도화지
		boolean[][] map = new boolean[101][101];

		// 색종이의 수
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int nc = 0; nc < N; nc++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			for (int i = r; i < r + 10; i++) {
				for (int j = c; j < c + 10; j++) {
					if (map[i][j] != true) {
						map[i][j] = true;
						ans++;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}

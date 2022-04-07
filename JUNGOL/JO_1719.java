package Algorithm.JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 별삼각형2
// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=992&sca=99&sfl=wr_hit&stx=1719
public class JO_1719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		// 삼각형의 크기
		int n = Integer.parseInt(st.nextToken());
		// 종류
		int m = Integer.parseInt(st.nextToken());

		if (n % 2 != 0 && 1 <= n && n <= 100 && 1 <= m && m <= 4) {
			if (m == 1) {
				for (int i = 0; i <= n / 2; i++) {
					sb.append(repeat('*', i + 1));
					sb.append('\n');
				}
				for (int i = n / 2; i >= 1; i--) {
					sb.append(repeat('*', i));
					sb.append('\n');
				}
			} else if (m == 2) {
				for (int i = n / 2, k = 1; i >= 0; i--, k++) {
					sb.append(repeat(' ', i));
					sb.append(repeat('*', k));
					sb.append('\n');
				}
				for (int i = 1, k = n / 2; i <= n / 2; i++, k--) {
					sb.append(repeat(' ', i));
					sb.append(repeat('*', k));
					sb.append('\n');
				}
			} else if (m == 3) {
				for (int i = 0, k = n; i <= n / 2; i++, k -= 2) {
					sb.append(repeat(' ', i));
					sb.append(repeat('*', k));
					sb.append('\n');
				}
				for (int i = n / 2 - 1, k = 3; i >= 0; i--, k += 2) {
					sb.append(repeat(' ', i));
					sb.append(repeat('*', k));
					sb.append('\n');
				}
			} else if (m == 4) {
				for (int i = 0; i <= n / 2; i++) {
					sb.append(repeat(' ', i));
					sb.append(repeat('*', n / 2 + 1 - i));
					sb.append('\n');
				}
				for (int i = 0, k = 2; i < n / 2; i++, k++) {
					sb.append(repeat(' ', n / 2));
					sb.append(repeat('*', k));
					sb.append('\n');
				}
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

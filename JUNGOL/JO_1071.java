package Algorithm.JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 약수와 배수
// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=351&sca=99&sfl=wr_hit&stx=1071
public class JO_1071 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int[] ns = new int[N];
		for (int nc = 0; nc < N; nc++) {
			ns[nc] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());

		int ans1 = 0;
		int ans2 = 0;
		for (int i = 0; i < N; i++) {
			if (M % ns[i] == 0) {
				ans1 += ns[i];
			}

			if (ns[i] % M == 0) {
				ans2 += ns[i];
			}
		}

		System.out.println(ans1);
		System.out.println(ans2);
	}
}

package Algorithm.JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 냉장고
// N개의 화할물질을 보관할 최소의 냉장고 수를 구하는 문제
// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=99&sfl=wr_hit&stx=1828
public class JO_1828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 화학물질의 수
		int N = Integer.parseInt(br.readLine());

		// 화할물질 저장할 배열
		CheSub[] chesub = new CheSub[N];
		// 화학물질 입력
		for (int nc = 0; nc < N; nc++) {
			st = new StringTokenizer(br.readLine());
			chesub[nc] = new CheSub(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// 화학물질들을 최고 온도를 기준으로 오름차순 정렬, 최고온도가 같다면 최저온도기준 오름차순 정렬
		Arrays.sort(chesub);
		
		// 최소의 냉장고 수를 저장할 변수, 첫 화학물질은 처음에 카운트 하기때문에 1로 초기화
		int ans = 1;
		// 최근의 화학물질의 최고 보관 온도
		int ce = chesub[0].e;
		// 현재 화학물질의 최저 보관 온도가 ce보다 크다면 새로운 냉장고가 필요함
		for (int nc = 1; nc < N; nc++) {
			if(chesub[nc].s > ce) {
				ans++;
				ce = chesub[nc].e;
			}
		}
		
		System.out.println(ans);
	}
	
	// 화학물질 클래스
	static class CheSub implements Comparable<CheSub>{
		// 최저 보관 온도
		int s;
		// 최고 보관 온도
		int e;
		
		public CheSub(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		// 화학물질들을 최고 온도를 기준으로 오름차순 정렬, 최고온도가 같다면 최저온도기준 오름차순 정렬
		@Override
		public int compareTo(CheSub o) {
			return (this.e != o.e) ? (this.e - o.e) : (this.s - o.s);
		}
	}
}

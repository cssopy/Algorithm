import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// x만큼 간격이 있는 n개의 숫자
// x부터 시작해 x씩 증가하여 n개를 지니는 리스트를 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12954
public class lv1_x만큼_간격이_있는_n개의_숫자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		System.out.println(Arrays.toString(solution(x, n)));
	}

	public static long[] solution(int x, int n) {
		long[] answer = new long[n];
		
		// i는 x부터 시작하고 n번 반복하면서 i는 x씩 증가, 그 i값을 answer에 초기화
		for (long i = x, c = 0; c < n; i += x, c++) {
			answer[(int) c] = i;
		}
		return answer;
	}
}

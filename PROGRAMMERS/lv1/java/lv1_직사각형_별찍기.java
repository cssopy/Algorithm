import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 직사각형 별찍기
// n개별의 별을 m개의 줄에 출력하는 문제, n x m 크기의 별사각형을 출력하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12969
public class lv1_직사각형_별찍기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		// 가로 길이
		int n = Integer.parseInt(st.nextToken());
		// 세로 길이
		int m = Integer.parseInt(st.nextToken());
		
		// 가로 길이만큼 *을 찍고 줄을 바꿈, 이것을 세로길이 m만큼 반복
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

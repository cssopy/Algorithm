import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 짝수와 홀수
// num이 짝수인지 홀수인지 판단하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12937
public class lv1_짝수와_홀수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(solution(Integer.parseInt(br.readLine())));
	}

	public static String solution(int num) {
		// num을 2로 나눠서 나머지가 없다면(=짝수라면) "Even" 리턴, 나머지가 있다면(=홀수) "Odd" 리턴
		return (num % 2 == 0) ? "Even" : "Odd";
	}
}

// 약수의 합
// 정수 n을 입력받아 n의 약수를 모두 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12928
public class lv1_약수의_합 {
	public static void main(String[] args) {
		int[] ns = { 2 };

		for (int i = 0; i < ns.length; i++) {
			System.out.println(solution(ns[i]));
		}
	}

	public static int solution(int n) {
		// 약수의 합
		int answer = 0;
		// i값을 1부터 n까지 늘리면서 i가 n의 약수인지 확인
		for (int i = 1; i <= n; i++) {
			// i값이 n의 약수이면
			if (n % i == 0) {
				// n을 i로 나눴을때 몫(=또 하나의 약수)
				int q = n / i;
				
				// 두 약수의 관계가 상하 관계가 맞을때 두 값을 answer에 더해줌
				if (i < q) {
					answer += i + q;
				} 
				// 두 약수의 값이 같다면(=n의 제곱근) 하나만 answer에 더해줌
				else if (i == q) {
					answer += i;
				} 
				// 두 약수의 관계가 역전이 됐다면 해당 i값은 이미 앞전에 고려한 약수이므로 for종료
				else {
					break;
				}
			}
		}
		return answer;
	}
}

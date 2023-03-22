// 소수 찾기
// 1부터 숫자 n사이에 소수가 몇개인지 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12921
public class lv1_소수_찾기 {
	public static void main(String[] args) {
		int[] inp = { 10, 5 };

		for (int i : inp) {
			System.out.println(solution(i));
		}
	}

	public static int solution(int n) {
		// 소수의 수
		int answer = 0;

		// 1은 소수가 아니니 2부터 n까지 소수인지 확인
		for(int i=2; i<=n; i++) {
			// i가 소수이면 answer++
			if(isPrime(i)) {
				answer++;
			}
		}

		return answer;
	}
	
	// 소수 판별 함수
	public static boolean isPrime(int n) {
		// 2부터 n-1까지 약수인 수가 있다면 n은 소수가 아니게 되는것
		// 하지만 2부터 n-1까지 진행하면 시간이 너무 오래걸리니 n^(1/2)까지만 진행하여 시간절약
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
}

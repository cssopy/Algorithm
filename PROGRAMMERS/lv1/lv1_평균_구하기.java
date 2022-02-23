package Algorithm.PROGRAMMERS.lv1;

// 평균 구하기
// 정수를 담고 있는 배열 arr의 평균값을 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12944
public class lv1_평균_구하기 {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 5 } };

		for (int i = 0; i < arr.length; i++) {
			System.out.println(solution(arr[i]));
		}
	}

	public static double solution(int[] arr) {
		// 리턴될 변수
		double answer = 0;
		
		// arr배열의 요소를 모두 더함
		for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		
		// arr배열의 요소 개수만큼 나누기
		answer /= arr.length;
		
		return answer;
	}
}

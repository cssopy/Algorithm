// 행렬의 덧셈
// 두개의 행렬을 덧셈한 새로운 행렬을 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12950
public class lv1_행렬의_덧셈 {
	public static void main(String[] args) {
		int[][] arr1 = { { 1, 2 }, { 2, 3 } };
		int[][] arr2 = { { 3, 4 }, { 5, 6 } };

		int[][] answer = solution(arr1, arr2);
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[0].length; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {
		// 들어온 두 배열의 크기와 같은 크기의 배열 생성
		int[][] answer = new int[arr1.length][arr1[0].length];

		// 두 배열의 각 자리의 수를 더해  answer에 초기화
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}

		return answer;
	}
}

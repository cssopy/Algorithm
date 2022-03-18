package Algorithm.PROGRAMMERS.lv1;

import java.util.Stack;

// 크레인 인형뽑기 게임
// 크레인으로 뽑은 인형을 스택에 넣을때 같은 인형이 연속하여 넣어지면 두 인형을 카운트 했을때 총 카운트 수를 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/92334
public class lv1_크레인_인형뽑기_게임 {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
		// 뽑은 인형을 담을 바구니
		Stack<Integer> seled = new Stack<>();

		// 터트러져 없어진 인형의 수
		int answer = 0;
		// moves배열에 접근
		for (int i = 0; i < moves.length; i++) {
			// moves위치에 있는 인형에 접근
			for (int r = 0; r < board.length; r++) {
				// 해당 칸에 인형이 있다면
				if (board[r][moves[i] - 1] != 0) {
					// 비어있다면 바구니에 바로 담기
					if (seled.isEmpty()) {
						seled.push(board[r][moves[i] - 1]);
					} 
					// 바구니에 인형이 있다면
					else {
						// 방금 뽑은 인형과 바구니에서 제일 위에 있는 인형이 같은 종류의 인형이라면 두 인형을 터트리고 count
						if (board[r][moves[i] - 1] == seled.peek()) {
							seled.pop();
							answer += 2;
						} 
						// 방금 뽑은 인형과 바구니에서 제일 위에 있는 인형이 다른 종류의 인형이라면 바구니에 담기
						else {
							seled.push(board[r][moves[i] - 1]);
						}
					}
					
					// 뽑은 인형의 자리는 빈 자리로 처리
					board[r][moves[i] - 1] = 0;
					// 인형을 뽑았다면 더 이상 크레인이 밑으로 갈 필요없으므로 break
					break;
				}
			}
		}
		return answer;
	}
}

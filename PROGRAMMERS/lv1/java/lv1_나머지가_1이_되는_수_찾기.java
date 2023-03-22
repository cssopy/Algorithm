// 나머지가 1이 되는 수 찾기
// https://programmers.co.kr/learn/courses/30/lessons/87389
public class lv1_나머지가_1이_되는_수_찾기 {
	public static void main(String[] args) {
		int[] inps = { 10, 12 };

		for (int inp : inps) {
			System.out.println(solution(inp));
		}

	}

	public static int solution(int n) {
		int answer = n - 1;
		for (int i = n - 2; i >= 2; i--) {
			if (n % i == 1 && i < answer) {
				answer = i;
			}
		}
		return answer;
	}
}

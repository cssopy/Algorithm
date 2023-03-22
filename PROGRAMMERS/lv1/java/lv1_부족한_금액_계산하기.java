// 부족한 금액 계산하기
// https://programmers.co.kr/learn/courses/30/lessons/82612
public class lv1_부족한_금액_계산하기 {
	public static void main(String[] args) {
		System.out.println(solution(3, 20, 4));
	}

	public static long solution(int price, int money, int count) {
		if ((double) count * (count + 1) / 2 * price > money) {
			return (long) ((double) count * (count + 1) / 2 * price - money);
		} else {
			return 0;
		}
	}
}

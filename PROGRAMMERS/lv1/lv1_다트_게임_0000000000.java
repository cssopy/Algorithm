package Algorithm.PROGRAMMERS.lv1;

// [1차] 다트 게임
// 
// https://programmers.co.kr/learn/courses/30/lessons/17682
public class lv1_다트_게임_0000000000 {
	public static void main(String[] args) {
		System.out.println((int) '0');
		System.out.println((int) '9');
	}

	public int solution(String dartResult) {
		StringBuilder n = new StringBuilder();
		char b;
		char o;

		int ans = 0;
		for (int i = 0; i < dartResult.length(); i++) {
			char ip = dartResult.charAt(i);

			if (ip >= '0' && ip <= '9') {
				n.append(ip);
			} else if (ip == 'S' || ip == 'D' || ip == 'T') {
				b = ip;
			} else {
				o = ip;
			}

			char np = dartResult.charAt(i + 1);
			if (np >= '0' && np <= '9') {
				
			}
		}

		return ans;
	}
}

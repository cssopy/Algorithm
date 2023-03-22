// 하샤드 수
// 해당 숫자가 하샤드 수인지 판별하는 문제(하샤드수는 x의 각 자리수의 합으로 x가 나누어 떨어지면 하샤드 수임) 
// https://programmers.co.kr/learn/courses/30/lessons/12947
public class lv1_하샤드_수 {
	public static void main(String[] args) {
		int[] arr = { 10, 12, 11, 13 };

		for (int i = 0; i < arr.length; i++) {
			System.out.println(solution(arr[i]));
		}
	}

	public static boolean solution(int x) {
		// x의 각 자리수에 접근하기 쉽게 문자열로 변환
		String s = Integer.toString(x);
		
		// x의 각 자리수를 가져와 sum에 더함
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += Integer.parseInt(Character.toString(s.charAt(i)));
		}
		
		// x를 sum으로 나누어 떨어지면 하샤드 수 => true 리턴
		if (x % sum == 0) {
			return true;
		} else {
			return false;
		}
	}
}

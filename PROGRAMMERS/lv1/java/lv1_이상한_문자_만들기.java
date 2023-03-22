// 이상한 문자 만들기
// 문자열 s의 짝수번째 알파벳은 대문자로 홀수번째 알파벳은 소문자로 바꾼 문자열을 구하는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12930
public class lv1_이상한_문자_만들기 {
	public static void main(String[] args) {
		String s = "try hello world";
		
		System.out.println(solution(s));
	}
	
	public static String solution(String s) {
		// 정답
        StringBuilder answer = new StringBuilder();
        
        // 단어마다의 인덱스
        int idx = 0;
        for(int i=0; i<s.length(); i++) {
        	// 공백을 만나면 answer에 공백을 추가하고 공백 다음에는 새로운 단어이기 때문에 idx를 0으로 재초기화
        	if(s.charAt(i)==' ') {
        		answer.append(' ');
        		idx = 0;
        		continue;
        	}
        	
        	// 해당 단어에서의 인덱스를 판별하여 처리
        	if(idx++%2==0) {
        		answer.append(Character.toUpperCase(s.charAt(i)));
        	}else {
        		answer.append(Character.toLowerCase(s.charAt(i)));
        	}
        }
        
        return answer.toString();
    }
}

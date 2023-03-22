// 서울에서 김서방 찾기
// 문자열 배열 seoul에서 "kim"문자열의 위치를 찾는 문제
// https://programmers.co.kr/learn/courses/30/lessons/12919
public class lv1_서울에서_김서방_찾기 {
	public static void main(String[] args) {
		String[] inp = {"Jane", "Kim", "Jane", "Jane", "Jane"};
		
		System.out.println(solution(inp));
	}
	
	public static String solution(String[] seoul) {
		StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<seoul.length; i++) {
        	if(seoul[i].equals("Kim")) {
        		answer.append("김서방은 ");
                answer.append(i);
                answer.append("에 있다");
        		break;
        	}
        }
        
        return answer.toString();
    }
}

package BAEKJOON.SIVER_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        // 입력
        String s = br.readLine();

        // 스택
        int top = -1;
        char[] stack = new char[30];

        // 최종 정답
        int ans = 0;
        // 연산 중간 저장할 값
        int mv = 1;

        // 입력에 하나씩 접근
        for(int cs=0; cs<s.length(); cs++){
            char c = s.charAt(cs);

            // ( [ 기호일 경우 스택에 넣고 대응되는 값 mv에 처리
            if(c=='(' || c=='['){
                stack[++top] = c;
                mv *= c=='('?2:3;
            }else{
                // 접근하다 ) ] 기호가 들어왔을때 스택이 비어있다면 성사될 수 없는 입력이므로 바로 0출력
                if(top== -1){
                    ans = 0;
                    break;
                }else{
                    char cc = stack[top--];

                    if(c==')'){
                        // 스택 위에 있는 기호와 현재 기호가 맞지 않을 경우 연산이 불가능 바로 0 출력
                        if(cc != '('){
                            ans = 0;
                            break;
                        }else{
                            if(s.charAt(cs-1) == '('){
                                ans += mv;
                            }
                            mv /= 2;
                        }
                    }
                    // 위와 같음
                    else{
                        if(cc != '['){
                            ans = 0;
                            break;
                        }else{
                            if(s.charAt(cs-1) == '['){
                                ans += mv;
                            }
                            mv /= 3;
                        }
                    }
                }
            }
        }

        // 입력에 다 접근했는데 스택이 안비어 있으면 잘못된 입력이므로 바로 0 출력
        if(top != -1){
            ans = 0;
        }

        result.append(ans).append('\n');

        System.out.println(result);
    }
}

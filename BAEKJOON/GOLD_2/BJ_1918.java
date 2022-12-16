import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        // 연산자 우선순위
        HashMap<Character, Integer> pr = new HashMap<>(){{
            put('(', 0);
            put('-', 1);
            put('+', 1);
            put('*', 2);
            put('/', 2);
        }};

        // 후위표기식
        String not = br.readLine();

        // 스택
        int top = -1;
        char[] stack = new char[100];

        for(int i=0; i<not.length(); i++){
            char c = not.charAt(i);

            if(c >= 'A' && c <= 'Z'){
                result.append(c);
            }else if(c == '('){
                stack[++top] = c;
            }else if(c == ')'){
                while (stack[top] != '(') {
                    result.append(stack[top--]);
                }
                top--;
            }else {
                while(top != -1 && (pr.get(stack[top]) >= pr.get(c))) {
                    result.append(stack[top--]);
                }
                stack[++top] = c;
            }
        }
        while(top != -1) {
            result.append(stack[top--]);
        }

        System.out.println(result);
    }
}

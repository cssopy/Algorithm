public class lv2_올바른_괄호 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[] inps = {
                "()()",
                "(())()",
                ")()(",
                "(()("
        };

        for (String inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.print(result);
    }

    static boolean solution(String s) {
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 여는 괄호이면 스택에 여는 괄호를 넣었다치고 top++ 수행
            if (c == '(') {
                top++;
                continue;
            }

            if (c == ')') {
                // 닫는 괄호가 나올때 top은 -1이 아니어야 함
                if (top == -1) {
                    return false;
                }

                top--;
            }
        }

        // 정상적으로 진행하다 스택에 여는 괄호가 남아있는 경우가 존재하기에 처리
        return top != -1 ? false : true;
    }
}

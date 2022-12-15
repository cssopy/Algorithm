import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        // 알파벳 대응 수
        int[] crspdNums = new int[N];
        // 후위표기식
        String notation = br.readLine();

        // 알파벳에 대응하는 수 입력 및 설정
        for (int nc=0; nc<N; nc++){
            int v = Integer.parseInt(br.readLine());
            crspdNums[nc] = v;
        }

        // 스택
        int top = -1;
        double[] stack = new double[notation.length()];

        for(int nt =0; nt<notation.length(); nt++){
            char c = notation.charAt(nt);

            if(c >= 'A' && c <= 'Z'){
                stack[++top] = crspdNums[c-'A'];
            }else{
                double v1 = stack[top--];
                double v2 = stack[top];

                if(c == '+'){
                    stack[top] = v2 + v1;
                }else if(c == '-'){
                    stack[top] = v2 - v1;
                }else if(c == '*'){
                    stack[top] = v2 * v1;
                }else if(c == '/'){
                    stack[top] = v2 / v1;
                }
            }
        }

        result.append(String.format("%.2f\n", stack[0]));
        System.out.println(result);
    }
}

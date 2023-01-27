import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        // 암호
        String inp = br.readLine();
        result.append(solve(inp));
        System.out.println(result);
    }

    public static int solve(String inp) {
        // 암호의 처음이 0으로 시작할 경우
        if (inp.charAt(0) == '0') {
            return 0;
        }

        // 사전 준비
        int[] dp = new int[inp.length() + 1];
        dp[0] = 1;

        for (int i = 1; i <= inp.length(); i++) {
            // inp.substring(i-1, i)의 값이 1~9 속하면 dp[i-1]의 경우의 수를 더해줌
            int cn = Integer.parseInt(inp.substring(i - 1, i));
            if (cn >= 1 && cn <= 9) {
                dp[i] += dp[i - 1];
            }

            // i가 1일경우는 이제 첫 자리수의 경우를 고려하는 것이기 때문에 넘어감
            if (i == 1) {
                continue;
            }

            // inp.substring(i-2, i)의 값이 10~26에 속하면 dp[i-2]의 경우의 수를 더해줌
            int pn = Integer.parseInt(inp.substring(i - 2, i));
            // 00처럼 0이 연속 두번 나올 경우
            if (pn == 0) {
                return 0;
            }
            if (pn >= 10 && pn <= 26) {
                dp[i] += dp[i - 2];
            }

            dp[i] %= 1000000;
        }

        return dp[inp.length()];
    }
}

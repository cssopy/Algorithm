import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        result.append(solve(N));
        System.out.println(result);
    }

    public static int solve(int N) {
        if (N == 1) {
            return 9;
        }

        // 자릿수에 해당 숫자가 올수 있는 경우의 수
        int[][] dp = new int[N + 1][10];
        for (int i = 0; i < 10; i++) {
            // 1번째 자리에는 0~9 한개씩만 들어갈 수 있으므로 모두 1가지
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                // 숫자 0은 (i-1)자리에 1이 숫자 9는 (i-1)자리에 8만 들어갈 수 있음
                if (j == 0 || j == 9) {
                    dp[i][j] = j == 0 ? dp[i - 1][j + 1] : dp[i - 1][j - 1];
                    continue;
                }
                // i번째 자리에 j숫자일때 가능한 경우의 수는
                // i-1번째 자리의 j-1숫자의 경우의 수와 i-1번째 자리의 j+1숫자의 경우의 수의 합
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                dp[i][j] %= 1_000_000_000;
            }
        }

        long ans = 0;
        // 0으로 시작하는 수는 제외
        for (int i = 1; i < 10; i++) {
            ans += dp[N][i];
        }

        return (int) (ans % 1_000_000_000);
    }
}

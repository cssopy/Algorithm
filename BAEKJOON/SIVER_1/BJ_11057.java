import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        // 수의 길이
        int N = Integer.parseInt(br.readLine());
        result.append(solve(N));
        System.out.println(result);
    }

    public static int solve(int N) {
        int[][] dp = new int[N + 1][10];

        // 사전 준비
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                // 제일 첫번째 값은 1부터 시작
                if (j == 0) {
                    dp[i][j] = 1;
                }
                // 두번째값부터 이전 값과 이전 행의값의 합으로 dp배열 갱신
                else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
                // 모듈러 법칙에 의해 값마다 나눗셈 연산해도 결과는 같다
                dp[i][j] %= 10007;
            }
        }

        return dp[N][9];
    }
}
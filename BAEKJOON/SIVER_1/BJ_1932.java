import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BJ_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        // 삼각형의 크기
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            int[] is = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 제일 꼭대기 값 및 max 초기화
            if (i == 0) {
                dp[0][0] = is[0];
                max = dp[0][0];
                continue;
            }

            for (int j = 0; j <= i; j++) {
                // 삼각형 양쪽 제일 끝 값들은 경우의 수가 하나 뿐
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + is[j];
                    max = Math.max(max, dp[i][j]);
                    continue;
                }

                // 양쪽 제일 끝 값을 제외한 중앙값들은 경우의 수가 두가지 그 중 최대값으로 초기화
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + is[j];
                max = Math.max(max, dp[i][j]);
            }
        }

        result.append(max);
        System.out.println(result);
    }
}

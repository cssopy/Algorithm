import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BJ_11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        // 행렬 개수
        int N = Integer.parseInt(br.readLine());
        // 행렬 정보 입력
        int[][] rcs = new int[N][];
        for (int i = 0; i < N; i++) {
            rcs[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        result.append(solve(N, rcs));
        System.out.println(result);
    }

    public static int solve(int N, int[][] rcs) {
        int[][] dp = new int[N][N];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                dp[j][j + i] = Integer.MAX_VALUE;

                for (int k = 0; k < i; k++) {
                    int cost = dp[j][j + k] + dp[j + k + 1][j + i] + rcs[j][0] * rcs[j + k][1] * rcs[j + i][1];
                    dp[j][j + i] = Math.min(dp[j][j + i], cost);
                }
            }
        }

        return dp[0][N - 1];
    }
}

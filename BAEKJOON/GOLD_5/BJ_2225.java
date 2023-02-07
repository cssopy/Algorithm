import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        result.append(solve2(N, K));
        System.out.println(result);
    }

    // DP
    public static int solve(int N, int K) {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= K; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                dp[i][j] %= 1_000_000_000;
            }
        }

        return dp[N][K];
    }

    // 조합
    public static int solve2(int N, int K) {
        // N K => N+K-1 C K-1
        K -= 1;
        N += K;
        // n!/(n-k)!k!
        BigInteger bi = BigInteger.valueOf(1);
        for (int i = N; i >= 1; i--) {
            bi = bi.multiply(BigInteger.valueOf(i));
            if (i <= K) {
                bi = bi.divide(BigInteger.valueOf(i));
            }
            if (i <= N - K) {
                bi = bi.divide(BigInteger.valueOf(i));
            }
        }

        return bi.remainder(BigInteger.valueOf(1_000_000_000)).intValue();
    }
}
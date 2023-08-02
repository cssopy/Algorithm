import java.util.Scanner;

public class BJ_1309 {
    public static void main(String[] args) {
        int N;
        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
        }

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 3;

        // 규칙존재 dp[i] = dp[i-1]*2 + dp[i-2]
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901;
        }

        System.out.println(dp[N]);
    }
}

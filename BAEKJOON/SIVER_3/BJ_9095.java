import java.util.Scanner;

public class BJ_9095 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();

            for (int i = 0; i < T; i++) {
                result.append(solution(sc.nextInt())).append('\n');
            }
        }

        System.out.print(result);
    }

    static int solution(int n) {
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }
}

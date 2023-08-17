import java.util.Arrays;
import java.util.Scanner;

public class BJ_9465 {
    public static void main(String[] args) {
        int T;
        int n;
        int[][] scores;
        try (Scanner sc = new Scanner(System.in)) {
            T = Integer.parseInt(sc.nextLine());

            StringBuilder sb = new StringBuilder();
            for (int t = 0; t < T; t++) {
                n = Integer.parseInt(sc.nextLine());
                scores = new int[2][];
                for (int i = 0; i < 2; i++) {
                    scores[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                }

                int[][] dp = new int[n][3];
                dp[0] = new int[]{scores[0][0], scores[1][0], 0};
                for (int i = 1; i < n; i++) {
                    dp[i][0] = Math.max(dp[i - 1][1] + scores[0][i], dp[i - 1][2] + scores[0][i]);
                    dp[i][1] = Math.max(dp[i - 1][0] + scores[1][i], dp[i - 1][2] + scores[1][i]);
                    dp[i][2] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
                }

                sb.append(Math.max(Math.max(dp[n-1][0], dp[n-1][1]), dp[n-1][2])).append('\n');
            }
            
            System.out.print(sb);
        }
    }
}

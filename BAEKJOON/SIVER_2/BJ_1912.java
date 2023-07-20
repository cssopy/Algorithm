import java.util.Scanner;

public class BJ_1912 {
    public static void main(String[] args) {
        int n;
        // i번째 값까지 고려했을때 최대 연속합
        int[] dp;
        int answer;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
            dp = new int[n];

            dp[0] = sc.nextInt();
            answer = dp[0];
            // dp[i]를 정할때 dp[i-1]값이 마이너스면 앞전의 연속합을 고려하지말고 i번째 값만 채택하는 것이 유리
            for (int i = 1; i < n; i++) {
                int inp = sc.nextInt();

                dp[i] = Math.max(inp, dp[i - 1] + inp);
                answer = Math.max(answer, dp[i]);
            }
        }

        System.out.println(answer);
    }
}

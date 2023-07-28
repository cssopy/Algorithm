import java.util.Scanner;

public class BJ_1699 {
    public static void main(String[] args) {
        int N;
        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
        }

        // dp[i] i값을 나타낼 수 있는 제곱수 항의 최소 개수
        int[] dp = new int[N + 1];
        // dp 초기설정 처음엔 1제곱의 개수만큼 설정
        for (int i = 0; i <= N; i++) {
            dp[i] = i;
        }

        // i값 아래의 제곱수들을 탐색하며 최소항의 개수 결정
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}

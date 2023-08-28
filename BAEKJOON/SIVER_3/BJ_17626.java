import java.util.Scanner;

public class BJ_17626 {
    public static void main(String[] args) {
        int n;
        try(Scanner sc = new Scanner(System.in)){
            n = sc.nextInt();
        }

        // dp[i] i값을 나타낼 수 있는 제곱수 항의 최소 개수
        int[] dp = new int[n + 1];
        // dp 초기설정 처음엔 1제곱의 개수만큼 설정
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        // i값 아래의 제곱수들을 탐색하며 최소항의 개수 결정
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}

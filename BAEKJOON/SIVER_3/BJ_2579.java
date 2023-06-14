import java.util.Scanner;

public class BJ_2579 {
    public static void main(String[] args) {
        int N;
        int[] stairs, dp;

        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();

            stairs = new int[N];
            for (int i = 0; i < N; i++) {
                stairs[i] = sc.nextInt();
            }
        }

        // i번째 계단까지 고려했을때의 최대값
        dp = new int[N];
        if (N > 3) {
            dp[0] = stairs[0];
            dp[1] = stairs[0] + stairs[1];
            dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
            // 해당 계단에 도달하는 경우는 전전칸계단에서 한번에 오거나 전칸에서 오는 경우가 존재
            // 전칸에서 오는 경우는 전칸과 지금칸을 밟아야 하기에 3번연속 밟지 못한다는 규칙으로 인해 전전전칸을 밟고 전칸을 밟아야 함
            for (int i = 3; i < N; i++) {
                dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
            }
        }
        // 계단의 수가 3개 이하일 경우
        else if (N == 1) {
            dp[0] = stairs[0];
        } else if (N == 2) {
            dp[1] = stairs[0] + stairs[1];
        } else {
            dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
        }

        System.out.println(dp[N - 1]);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class BJ_10571 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            StringBuilder answer = new StringBuilder();

            int T = Integer.parseInt(sc.nextLine());

            for (int t = 0; t < T; t++) {
                int N = Integer.parseInt(sc.nextLine());

                double[][] wc = new double[N][];
                for (int n = 0; n < N; n++) {
                    wc[n] = Arrays.stream(sc.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
                }

                // i위치까지 고려했을 때 최장의 길이
                int[] dp = new int[N + 1];
                dp[0] = 0;
                int max = 0;
                for (int i = 0; i < N; i++) {
                    dp[i] = 1;

                    for (int j = 0; j < i; j++) {
                        // 무게가 더 크고, 선명도가 더 작을 경우
                        // 첫번째부터 i위치 전까지 최장 길이 중 i위치 최장길이보다 더 큰 값이 가능할 경우 i위치의 최장길이 해당값으로 초기화
                        if (wc[i][0] > wc[j][0] && wc[i][1] < wc[j][1]) {
                            if (dp[i] < dp[j] + 1) {
                                dp[i] = dp[j] + 1;
                            }
                        }
                    }

                    max = Math.max(max, dp[i]);
                }

                answer.append(max).append('\n');
            }

            System.out.print(answer);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BJ_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        // 카드의 개수
        int N = Integer.parseInt(br.readLine());
        // 카드팩들 가격
        int[] P = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        result.append(solve(N, P));
        System.out.println(result);
    }

    public static int solve(int N, int[] P) {
        // i개의 카드를 살때의 최대 금액을 저장할 배열
        int[] dp = new int[N + 1];

        // 1~i개가 들어간 카드백들을 각각 살때의 최대가격을 계산하여 그 중 최대값을 채택
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], P[j - 1] + dp[i - j]);
            }
        }

        return dp[N];
    }
}

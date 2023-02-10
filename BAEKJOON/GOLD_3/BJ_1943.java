import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine());

            Coin[] coins = new Coin[N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                coins[j] = new Coin(v, c);
            }

            result.append(solve(N, coins)).append('\n');
        }

        System.out.println(result);
    }

    public static int solve(int N, Coin[] coins) {
        int total = 0;
        for (Coin coin : coins) {
            total += coin.v * coin.c;
        }
        boolean[][] dp = new boolean[N][total / 2 + 1];

        // 총 금액이 홀수면 불가능
        if (total % 2 != 0) {
            return 0;
        }

        // 어떤 동전이라도 0원은 항상 만들 수 있음
        for (int i = 0; i < N; i++) {
            dp[i][0] = true;
        }
        // 동전 종류별로 접근
        for (int i = 0; i < coins.length; i++) {
            int v = coins[i].v;
            int c = coins[i].c;

            // 첫번째 동전은 참고할 이전 동전이 없으므로 바로 초기화
            if (i == 0) {
                for (int j = 1; j <= c; j++) {
                    if (v * j > total / 2) {
                        break;
                    }
                    dp[0][v * j] = true;
                }
                continue;
            }

            for (int j = v; j <= total/2; j++) {
                if (dp[i - 1][j - v]) {
                    for (int k = 0; k <= c; k++) {
                        if (j - v + v * k > total / 2) {
                            break;
                        }
                        dp[i][j - v + v * k] = true;
                    }
                }
            }
        }

        return dp[N - 1][total / 2] ? 1 : 0;
    }

    public static class Coin {
        int v, c;

        Coin(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}

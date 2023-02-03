import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BJ_7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        int[] NM = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] m = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] c = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        result.append(solve(NM, m, c));
        System.out.println(result);
    }

    public static int solve(int[] NM, int[] m, int[] c) {
        int[][] dp = new int[NM[0] + 1][10001];

        int ans = -1;
        for (int i = 1; i <= NM[0]; i++) {
            // i번째 앱의 메모리와 비용
            int mm = m[i-1];
            int cc = c[i-1];

            for (int j = 0; j < 10001; j++) {
                // i번째까지의 앱을 채택할 때 j비용으로 확보가능한 최대 메모리 크기를 갱신
                dp[i][j] = dp[i - 1][j];
                if (j - c[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j - cc] + mm, dp[i][j]);
                }

                // 어차피 갱신되는 메모리값은 오름차순이기 때문에 문제에서 요구하는 메모리만 넘으면 그때의 비용이 최소비용
                if(dp[i][j] >= NM[1]){
                    ans = j;
                    break;
                }
            }
        }

        return ans;
    }
}
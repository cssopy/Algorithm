import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class BJ_1727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int[] nm = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ns = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ms = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        result.append(solve(nm, ns, ms));
        System.out.println(result);
    }

    public static int solve(int[] nm, int[] ns, int[] ms){
        // 남자 n명과 여자 m명이 최대한 커플을 이룰때 점수차 합의 최소
        int[][] dp = new int[nm[0]+1][nm[1]+1];

        Arrays.sort(ns);
        Arrays.sort(ms);

        for(int i=1; i<=nm[0]; i++){
            for(int j=1; j<=nm[1]; j++){
                if (i == j) {
                    dp[i][j] = dp[i-1][j-1] + Math.abs(ns[i-1] - ms[j-1]);
                }

                // i, j번째 남여가 커플을 이루거나 i번째 남자가 솔로로 남는 경우
                else if (i > j) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1] + Math.abs(ns[i-1] - ms[j-1]));
                }

                // i, j번째 남여가 커플을 이루거나 j번째 여자가 솔로로 남는 경우
                else if (j > i) {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j-1] + Math.abs(ns[i-1] - ms[j-1]));
                }
            }
        }

        return dp[nm[0]][nm[1]];
    }
}

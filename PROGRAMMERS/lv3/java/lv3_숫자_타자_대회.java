import java.util.Arrays;

public class lv3_숫자_타자_대회 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[] inps = {
                "1756",
                "5123",
                "6666"
        };

        for (String inp : inps) {
            result.append(String.format("%d\n", solution(inp)));
        }

        System.out.println(result);
    }

    public static int solution(String numbers) {
        int[][] cost = {
                {1, 7, 6, 7, 5, 4, 5, 3, 2, 3},
                {7, 1, 2, 4, 2, 3, 5, 4, 5, 6},
                {6, 2, 1, 2, 3, 2, 3, 5, 4, 5},
                {7, 4, 2, 1, 5, 3, 2, 6, 5, 4},
                {5, 2, 3, 5, 1, 2, 4, 2, 3, 5},
                {4, 3, 2, 3, 2, 1, 2, 3, 2, 3},
                {5, 5, 3, 2, 4, 2, 1, 5, 3, 2},
                {3, 4, 5, 6, 2, 3, 5, 1, 2, 4},
                {2, 5, 4, 5, 3, 2, 3, 2, 1, 2},
                {3, 6, 5, 4, 5, 3, 2, 4, 2, 1}
        };

        int[][][] dp = new int[numbers.length()][10][10];
        for (int i = 0; i < numbers.length(); i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(cost, dp, numbers, 0, 4, 6);
    }

    static int solve(int[][] cost, int[][][] dp, String number, int depth, int l, int r) {
        // 문자 마지막 숫자까지 도달
        if (depth == number.length()) return 0;

        // 이미 값이 결정되어 있다면 해당 값 재사용 => 시간 절약
        if (dp[depth][l][r] != -1) return dp[depth][l][r];

        int n = number.charAt(depth) - '0';
        int answer = Integer.MAX_VALUE;

        // 왼쪽, 오른쪽 손가락을 움직일 때의 각각의 경우를 수행하며 최소의 가중치로 answer의 값 결정
        if (n != r) answer = Math.min(answer, solve(cost, dp, number, depth + 1, n, r) + cost[l][n]);
        if (n != l) answer = Math.min(answer, solve(cost, dp, number, depth + 1, l, n) + cost[r][n]);

        dp[depth][l][r] = answer;
        return dp[depth][l][r];
    }
}

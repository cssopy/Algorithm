public class lv4_사칙연산 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[][] inps = {
                {"1", "-", "3", "+", "5", "-", "8"},
                {"5", "-", "3", "+", "1", "+", "2", "-", "4"}
        };

        for (String[] inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(String arr[]) {
        // 피연산자 개수
        int oC = arr.length / 2 + 1;

        // i부터 j까지 연산의 최대값과 최소값
        int[][] max_dp = new int[oC][oC];
        int[][] min_dp = new int[oC][oC];
        for (int i = 0; i < oC; i++) {
            for (int j = 0; j < oC; j++) {
                max_dp[i][j] = Integer.MIN_VALUE;
                min_dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // 처음 각 피연산자값이 곧 최대값이며 최소값
        for (int i = 0; i < oC; i++) {
            max_dp[i][i] = Integer.parseInt(arr[i * 2]);
            min_dp[i][i] = Integer.parseInt(arr[i * 2]);
        }

        for (int cnt = 1; cnt < oC; cnt++) {
            for (int i = 0; i < oC - cnt; i++) {
                int j = i + cnt;
                for (int k = i; k < j; k++) {
                    // 덧셈의 경우 최대값은 최대+최대, 최소값은 최소+최소 여야 하고
                    // 뺄셈의 경우 최대값은 최대-최소, 최소값은 최소-최대 여야 함
                    if (arr[k * 2 + 1].equals("+")) {
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] + max_dp[k + 1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] + min_dp[k + 1][j]);
                        continue;
                    }
                    max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] - min_dp[k + 1][j]);
                    min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] - max_dp[k + 1][j]);
                }
            }
        }

        return max_dp[0][oC - 1];
    }
}

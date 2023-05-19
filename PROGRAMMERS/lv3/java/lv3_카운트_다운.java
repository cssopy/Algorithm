public class lv3_카운트_다운 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[] inps = {
                21, 58
        };

        for (int inp : inps) {
            int[] answer = solution(inp);
            for (int v : answer) {
                result.append(String.format("%d ", v));
            }
            result.append('\n');
        }

        System.out.println(result);
    }

    public static int[] solution(int target) {
        // i점수에서의 최소 던진 횟수와 그때의 싱글과 불의 개수를 저장할 배열
        int[][] dp = new int[target + 1][2];
        // 0번째는 최소 값을 계속 갱신해야 하기 때문에 큰 값으로 초기화
        for (int i = 0; i <= target; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }

        dp[0][0] = 0;
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= 20; j++) {
                // 불
                if (i - 50 >= 0) {
                    // i-50점에서 불을 맞출 때의 경우가 기존보다 던지는 횟수가 적은 경우
                    // i-50점에서의 경우에서 던지는 횟수와 싱글,불 횟수를 1씩 증가하여 초기화
                    if (dp[i - 50][0] + 1 < dp[i][0]) {
                        dp[i][0] = dp[i - 50][0] + 1;
                        dp[i][1] = dp[i - 50][1] + 1;
                    }
                    // 횟수가 같은 경우
                    // 불, 싱글을 던지는 횟수가 더 높은 경우로 결정
                    else if (dp[i][0] == dp[i - 50][0] + 1) {
                        dp[i][1] = Math.max(dp[i][1], dp[i - 50][1] + 1);
                    }
                }

                // 싱글
                if (i - j >= 0) {
                    // i-j점에서 불을 맞출 때의 경우가 기존보다 던지는 횟수가 적은 경우
                    // i-j점에서의 경우에서 던지는 횟수와 싱글,불 횟수를 1씩 증가하여 초기화
                    if (dp[i - j][0] + 1 < dp[i][0]) {
                        dp[i][0] = dp[i - j][0] + 1;
                        dp[i][1] = dp[i - j][1] + 1;
                    }
                    // 횟수가 같은 경우
                    // 불, 싱글을 던지는 횟수가 더 높은 경우로 결정
                    else if (dp[i][0] == dp[i - j][0] + 1) {
                        dp[i][1] = Math.max(dp[i][1], dp[i - j][1] + 1);
                    }
                }

                // 더블과 트리플의 경우 싱글과 불을 카운트하는 경우가 아니기 때문에 던지는 횟수만 고려
                // 더블
                if (i - j * 2 >= 0) {
                    if (dp[i - j * 2][0] + 1 < dp[i][0]) {
                        dp[i][0] = dp[i - j * 2][0] + 1;
                        dp[i][1] = dp[i - j * 2][1];
                    }
                }

                // 트리플
                if (i - j * 3 >= 0) {
                    if (dp[i - j * 3][0] + 1 < dp[i][0]) {
                        dp[i][0] = dp[i - j * 3][0] + 1;
                        dp[i][1] = dp[i - j * 3][1];
                    }
                }
            }
        }

        int[] answer = {dp[target][0], dp[target][1]};
        return answer;
    }
}

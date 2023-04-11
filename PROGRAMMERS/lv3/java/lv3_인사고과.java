import java.util.Arrays;

public class lv3_인사고과 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][][] inps = {
                {{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}}
        };

        for (int[][] inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(int[][] scores) {
        int[] wanhoScore = scores[0];
        int wanhoScoreSum = wanhoScore[0] + wanhoScore[1];

        // 근무태도을 기준으로 내림차순 정렬, 근무태도가 같을 시 동료평가를 기준으로 오름차순 정렬
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        // 완호의 등수 (완호보다 점수가 높은 사람의 수 + 1)
        int ans = 1;
        // 근무태도 점수가 높은 사람들의 동료평가 점수의 최대값
        int max = Integer.MIN_VALUE;
        for (int[] score : scores) {
            // 인센티브 받지 못하는 사람
            if (score[1] < max) {
                // 인센티브 받지 못하는 사람이 완호면 -1 반환
                if (score.equals(wanhoScore)) return -1;
                continue;
            }

            // 인센티브 받는 사람
            max = score[1];
            // 인센티브 받는 사람 중 완호보다 총점이 높은 사람 카운트
            if (score[0] + score[1] > wanhoScoreSum) ans++;
        }

        return ans;
    }
}

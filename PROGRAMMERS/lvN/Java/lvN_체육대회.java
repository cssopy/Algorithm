import java.util.Arrays;

public class lvN_체육대회 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][][] inps = {
                new int[][]{{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}},
                new int[][]{{20, 30}, {30, 20}, {20, 30}}
        };

        for (int[][] inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(int[][] ability) {
        int[] ans = {-1};
        findMaxAbility(ability, new boolean[ability.length], 0, 0, ans);

        return ans[0];
    }

    static void findMaxAbility(int[][] ability, boolean[] isSel, int depth, int sum, int[] ans) {
        // 종목마다 학생을 한명씩 골랐다면 종료
        if (depth == ability[0].length) {
            ans[0] = Math.max(ans[0], sum);
            return;
        }

        for (int i = 0; i < ability.length; i++) {
            // 아직 고르지 않은 학생인 경우 depth번째 종목의 선수로 i학생을 고르고 다음 종목의 선수를 고름
            if (!isSel[i]) {
                isSel[i] = true;
                findMaxAbility(ability, isSel, depth + 1, sum + ability[i][depth], ans);
                isSel[i] = false;
            }
        }
    }
}

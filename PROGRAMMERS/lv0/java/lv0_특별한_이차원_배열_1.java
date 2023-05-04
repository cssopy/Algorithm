public class lv0_특별한_이차원_배열_1 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[] inps = {
                3, 6, 1
        };

        for (int inp : inps) {
            int[][] ans = solution(inp);

            for (int[] row : ans) {
                for (int v : row) {
                    result.append(String.format("%d ", v));
                }
                result.append('\n');
            }
            result.append('\n');
        }

        System.out.println(result);
    }

    public static int[][] solution(int n) {
        int[][] answer = new int[n][n];
        for (int i = 0; i < n; i++) {
            answer[i][i] = 1;
        }
        return answer;
    }
}

public class lv0_정수를_나선형으로_배치하기 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[] inps = {
                4, 5
        };

        for (int inp : inps) {
            int[][] r = solution(inp);
            for (int[] row : r) {
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
        int[][] ans = new int[n][n];

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int r = 0, c = -1;
        for (int i = 1, dir = 0; i <= n * n; ) {
            int nr = r + dirs[dir][0];
            int nc = c + dirs[dir][1];

            if (!(0 <= nr && nr < n && 0 <= nc && nc < n) || ans[nr][nc] != 0) {
                dir = (dir + 1) % 4;
            } else {
                ans[nr][nc] = i++;
                r = nr;
                c = nc;
            }
        }

        return ans;
    }
}

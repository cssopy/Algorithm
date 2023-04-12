public class lv2_삼각_달팽이 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[] inps = {
                4, 5, 6
        };

        for (int inp : inps) {
            int[] ans = solution(inp);
            for (int v : ans) {
                result.append(v).append(' ');
            }
            result.append('\n');
        }

        System.out.println(result);
    }

    public static int[] solution(int n) {
        // 달팽이 채우기를 진행할 배열
        int[][] triangle = new int[n][n];
        // 하 우 좌상
        int[][] dirs = {{1, 0}, {0, 1}, {-1, -1}};

        int ci = -1, cj = 0;
        int k = 1;
        for (int i = n, dir = 0; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                ci = ci + dirs[dir][0];
                cj = cj + dirs[dir][1];
                triangle[ci][cj] = k++;
            }
            // 방향 전환
            dir = (dir + 1) % 3;
        }

        int[] ans = new int[k - 1];
        k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (triangle[i][j] == 0) break;
                ans[k++] = triangle[i][j];
            }
        }
        return ans;
    }
}

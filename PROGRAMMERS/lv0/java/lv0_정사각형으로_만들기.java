public class lv0_정사각형으로_만들기 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][][] inps = {
                {{572, 22, 37}, {287, 726, 384}, {85, 137, 292}, {487, 13, 876}},
                {{57, 192, 534, 2}, {9, 345, 192, 999}},
                {{1, 2}, {3, 4}}
        };

        for (int[][] inp : inps) {
            int[][] ans = solution(inp);

            for (int[] row : ans) {
                for (int value : row) {
                    result.append(String.format("%d ", value));
                }
                result.append('\n');
            }
            result.append('\n');
        }

        System.out.println(result);
    }

    public static int[][] solution(int[][] arr) {
        int ml = Math.max(arr.length, arr[0].length);
        int[][] ans = new int[ml][ml];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                ans[i][j] = arr[i][j];
            }
        }

        return ans;
    }
}

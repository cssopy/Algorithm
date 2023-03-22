public class lv2_카펫 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][] inps = {{10, 2}, {8, 1}, {24, 24}};

        for (int[] inp : inps) {
            int[] ans = solution(inp[0], inp[1]);
            result.append(String.format("[%d %d]", ans[0], ans[1])).append('\n');
        }

        System.out.print(result);
    }

    public static int[] solution(int brown, int yellow) {
        // 전체 격자 수
        int w = brown + yellow;

        int[] ans = new int[2];
        for (int i = 3; i <= w; i++) {
            // 가로 및 세로 격자의 합 * 2 - 4 = 갈색 격자의 수
            if (w % i == 0 && (w / i + i) * 2 - 4 == brown) {
                ans[0] = i;
                ans[1] = w / i;
            }
        }

        return ans;
    }
}

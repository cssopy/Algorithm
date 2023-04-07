public class lv4_도둑질 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][] inps = {
                {1, 2, 3, 1}
        };

        for (int[] inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(int[] money) {
        // 원형이기에 첫번째와 끝값은 함께 고련될 수 없기에 각각을 기준으로 두개의 dp배열 생성
        // i집까지 최대로 훔칠 수 있는 값을 저장할 배열
        int[][] dp = new int[2][money.length];
        for (int i = 0; i < 2; i++) {
            dp[i][1] = money[i];
        }

        // i위치의 값을 고려할때 i-1값과 i위치의 집+i-2위치까지의 최대값 중 더 큰 값으로 결정
        for (int i = 2; i < money.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], money[i - 1] + dp[0][i - 2]);
            dp[1][i] = Math.max(dp[1][i - 1], money[i] + dp[1][i - 2]);
        }

        // 각각의 최대값 중 더 큰값 선택
        return Math.max(dp[0][dp[0].length - 1], dp[1][dp[1].length - 1]);
    }
}

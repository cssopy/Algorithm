public class lv3_스티커_모으기_2 {
    public static int solution(int[] money) {
        // 스티커 길이가 1인경우
        if (money.length == 1) return money[0];

        // i번째 까지 고려했을 때 가장 최대가 되도록 뜯는 경우의 합
        // 처음과 끝이 이어져 있기 때문에 첫번째 것을 채택하느냐 안하느냐 두가지의 경우가 존재
        int[][] dp = new int[2][money.length];
        for (int i = 0; i < 2; i++) {
            dp[i][1] = money[i];
        }

        // 바로 직전에서의 경우의 값과 현재 값과 i-2번째에 존재하는 경우의 합의 값을 비교하여 더 큰 값을 채택
        for (int i = 2; i < money.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], money[i - 1] + dp[0][i - 2]);
            dp[1][i] = Math.max(dp[1][i - 1], money[i] + dp[1][i - 2]);
        }

        return Math.max(dp[0][dp[0].length - 1], dp[1][dp[1].length - 1]);
    }
}

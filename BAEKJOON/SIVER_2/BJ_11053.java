import java.util.Scanner;

public class BJ_11053 {
    public static void main(String[] args) {
        int N;
        int[] A;
        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
            A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
        }

        // A[i]값을 마지막으로 하는 가장 긴 수열의 길이를 저장
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        int answer = 1;
        // dp[i] 값을 결정할때 0부터 i-1 위치까지 값중 가장 큰값에서 1의 길이를 더함
        // 단 증가수열을 만족해야한다
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    answer = Math.max(answer, dp[i]);
                }
            }
        }

        System.out.println(answer);
    }
}

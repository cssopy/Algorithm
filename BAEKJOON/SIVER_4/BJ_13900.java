import java.util.Arrays;
import java.util.Scanner;

public class BJ_13900 {
    public static void main(String[] args) {
        int N;
        int[] nums;
        try (Scanner sc = new Scanner(System.in)) {
            N = Integer.parseInt(sc.nextLine());
            nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 부분합
        long[] sums = new long[N];
        sums[0] = nums[0];
        for (int i = 1; i < N; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        long answer = 0;
        for (int i = 0; i < N - 1; i++) {
            answer += (sums[N - 1] - sums[i]) * nums[i];
        }

        System.out.println(answer);
    }
}
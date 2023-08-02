import java.util.Arrays;
import java.util.Scanner;

public class BJ_17128 {
    public static void main(String[] args) {
        int N, Q;
        int[] A, QS;
        try (Scanner sc = new Scanner(System.in)) {
            int[] inp = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N = inp[0];
            Q = inp[1];
            A = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            QS = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 욱제가 장난치기전 S와 4마리의 소 합을 미리구함
        int S = 0;
        int[] sums = new int[N];
        for (int i = 0; i < N; i++) {
            sums[i] = A[i] * A[(i + 1) % N] * A[(i + 2) % N] * A[(i + 3) % N];
            S += sums[i];
        }

        StringBuilder answer = new StringBuilder();
        // 욱제가 장난칠때마다 그때마다 S를 구함
        for (int q : QS) {
            for (int i = 0; i < 4; i++) {
                int nq = (q - 1 - i + N) % N;
                sums[nq] = -sums[nq];
                S += 2 * sums[nq];
            }

            answer.append(S).append('\n');
        }

        System.out.print(answer);
    }
}

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ_1026 {
    public static void main(String[] args) {
        int N;
        int[] A;
        Integer[] B;
        try (Scanner sc = new Scanner(System.in)) {
            N = Integer.parseInt(sc.nextLine());
            A = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            B = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        }

        // 두 배열의 곱의 합이 가장 작아지기 위해서는 곱해져야 하는 두 값이 극단적으로 차이나야 함
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += A[i] * B[i];
        }

        System.out.println(answer);
    }
}

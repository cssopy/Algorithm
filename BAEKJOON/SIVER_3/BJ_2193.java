import java.util.Scanner;

public class BJ_2193 {
    public static void main(String[] args) {
        int N;

        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
        }

        // i번째 이친수의 수
        long[] iPnNum = new long[N + 1];
        iPnNum[1] = 1;
        // 이친수들이 피보나치 수열 형태와 같음
        for (int i = 2; i <= N; i++) {
            iPnNum[i] = iPnNum[i - 1] + iPnNum[i - 2];
        }

        System.out.println(iPnNum[N]);
    }
}

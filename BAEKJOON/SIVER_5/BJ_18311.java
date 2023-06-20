import java.util.Scanner;

public class BJ_18311 {
    public static void main(String[] args) {
        int N;
        long K;
        int[] courseLens;

        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
            K = sc.nextLong();

            courseLens = new int[N];
            for (int i = 0; i < N; i++) {
                courseLens[i] = sc.nextInt();
            }
        }

        System.out.println(solution(N, K, courseLens));
    }

    static int solution(int N, long K, int[] courseLens) {
        // 정방향
        // 1번 코스부터 시작
        if (K <= 0) return 1;
        for (int i = 0; i < N; i++) {
            if (K < courseLens[i]) return i + 1;
            K -= courseLens[i];
            // 코스 사이 처리
            if (i != N - 1 && K <= 0) return i + 2;
        }

        // 역방향
        // N번 코스부터 시작
        if (K <= 0) return N;
        for (int i = N - 1; i >= 0; i--) {
            if (K < courseLens[i]) return i + 1;
            K -= courseLens[i];
            // 코스 사이 처리
            if (i != 0 && K <= 0) return i;
        }

        return 1;
    }
}

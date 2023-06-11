import java.util.Scanner;

public class BJ_15721 {
    public static void main(String[] args) {
        int A, T, slogan;
        try (Scanner sc = new Scanner(System.in)) {
            A = sc.nextInt();
            T = sc.nextInt();
            slogan = sc.nextInt();
        }

        // 게임을 시작하고 진행한 사람 수
        int answer = -1;
        // 뻔, 데기가 외쳐진 횟수
        int[] bndNum = {0, 0};
        for (int N = 1, f = 0; ; N++) {
            // 뻔 데기 뻔 데기
            for (int i = 0; i < 2; i++) {
                answer++;
                bndNum[0]++;
                if (bndNum[slogan] == T) {
                    f = 1;
                    break;
                }

                answer++;
                bndNum[1]++;
                if (bndNum[slogan] == T) {
                    f = 1;
                    break;
                }
            }
            if (f == 1) break;

            // 뻔 x N
            for (int i = 0; i < N + 1; i++) {
                answer++;
                bndNum[0]++;
                if (bndNum[slogan] == T) {
                    f = 1;
                    break;
                }
            }
            if (f == 1) break;

            // 데기 x N
            for (int i = 0; i < N + 1; i++) {
                answer++;
                bndNum[1]++;
                if (bndNum[slogan] == T) {
                    f = 1;
                    break;
                }
            }
            if (f == 1) break;
        }

        System.out.println(answer % A);
    }
}

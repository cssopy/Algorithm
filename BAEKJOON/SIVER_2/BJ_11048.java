import java.util.Scanner;

public class BJ_11048 {
    public static void main(String[] args) {
        int N, M;
        int[][] map;

        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
            M = sc.nextInt();

            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
        }

        // 1행과 1열은 각 이전 행값과 열값에서 현재 좌표값을 더하여 초기화
        // 그 외 좌표는 위의 값과 왼쪽 값을 비교하여 더 큰 값을 더해준 값으로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0 && j != 0) {
                    map[i][j] += map[i][j - 1];
                } else if (j == 0 && i != 0) {
                    map[i][j] += map[i - 1][j];
                } else {
                    map[i][j] += Math.max(map[i - 1][j], map[i][j - 1]);
                }
            }
        }

        System.out.println(map[N - 1][M - 1]);
    }
}

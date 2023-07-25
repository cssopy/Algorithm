import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_15787 {
    public static void main(String[] args) {
        int N, M;
        int[][] trains;
        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
            M = sc.nextInt();

            trains = new int[N][20];
            for (int i = 0; i < M; i++) {
                int[] order = new int[3];
                order[0] = sc.nextInt();
                if (order[0] == 1 || order[0] == 2) {
                    order[1] = sc.nextInt();
                    order[2] = sc.nextInt();
                } else {
                    order[1] = sc.nextInt();
                }

                // 명령에 맞는 동작 수행
                if (order[0] == 1) {
                    trains[order[1] - 1][order[2] - 1] = 1;
                } else if (order[0] == 2) {
                    trains[order[1] - 1][order[2] - 1] = 0;
                } else if (order[0] == 3) {
                    for (int j = 19; j > 0; j--) {
                        trains[order[1] - 1][j] = trains[order[1] - 1][j - 1];
                    }
                    trains[order[1] - 1][0] = 0;
                } else {
                    for (int j = 0; j < 19; j++) {
                        trains[order[1] - 1][j] = trains[order[1] - 1][j + 1];
                    }
                    trains[order[1] - 1][19] = 0;
                }
            }

            // 집합으로 중복되는 승객이 앉은 상태 제외
            Set<String> set = new HashSet<>();
            StringBuilder sb;
            for (int i = 0; i < N; i++) {
                sb = new StringBuilder();
                for (int j = 0; j < 20; j++) {
                    sb.append(trains[i][j]);
                }
                set.add(sb.toString());
            }

            System.out.println(set.size());
        }
    }
}

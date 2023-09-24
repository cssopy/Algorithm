import java.util.Arrays;
import java.util.Scanner;

public class BJ_11403 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = Integer.parseInt(sc.nextLine());

            int[][] graph = new int[N][];
            for (int i = 0; i < N; i++) {
                graph[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            // 플로이드 워샬 알고리즘
            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (graph[i][k] + graph[k][j] == 2) {
                            graph[i][j] = 1;
                        }
                    }
                }
            }

            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    answer.append(graph[i][j]).append(' ');
                }
                answer.append('\n');
            }

            System.out.print(answer);
        }
    }
}

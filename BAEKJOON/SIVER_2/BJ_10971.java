import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_10971 {
    public static void main(String[] args) {
        int N;
        int[][] W;
        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
            W = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    W[i][j] = sc.nextInt();
                }
            }
        }

        int[] answer = {Integer.MAX_VALUE};
        // 모든 지점이 출발지점이 될수있음
        for (int i = 0; i < N; i++) {
            Set<Integer> isVisited = new HashSet<>();
            isVisited.add(i);
            dfs(N, W, i, i, isVisited, 0, answer);
        }

        System.out.println(answer[0]);
    }

    static void dfs(int N, int[][] W, int S, int C, Set<Integer> isVisited, int sum, int[] answer) {
        // 모두 지점을 방문했을때 현재 비용과 새로운 비용 비교후 갱신
        if (isVisited.size() == N) {
            if (W[C][S] != 0) {
                answer[0] = Math.min(answer[0], sum + W[C][S]);
            }
            return;
        }

        // 백트래킹
        if (sum >= answer[0]) {
            return;
        }

        // 방문하지 않았고 갈수있으면 다음 지점으로 방문
        for (int i = 0; i < N; i++) {
            if (!isVisited.contains(i) && W[C][i] != 0) {
                isVisited.add(i);
                dfs(N, W, S, i, isVisited, sum + W[C][i], answer);
                isVisited.remove(i);
            }
        }
    }
}

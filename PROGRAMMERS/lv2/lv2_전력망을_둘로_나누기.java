import java.util.LinkedList;
import java.util.Queue;

public class lv2_전력망을_둘로_나누기 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[] ns = {9, 4, 7};
        int[][][] wiress = {
                {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}},
                {{1, 2}, {2, 3}, {3, 4}},
                {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}
        };

        for (int i = 0; i < 3; i++) {
            result.append(solution(ns[i], wiress[i])).append('\n');
        }

        System.out.print(result);
    }

    public static int solution(int n, int[][] wires) {
        // 인접 행렬
        boolean[][] mat = new boolean[n + 1][n + 1];
        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];

            mat[from][to] = true;
            mat[to][from] = true;
        }

        int[] ans = {Integer.MAX_VALUE};
        // 모든 전선을 하나씩 제외하며 나누어진 두 전력망의 송전탑 차이를 구함
        for (int i = 0; i < wires.length; i++) {
            // n이 짝수이거나 홀수일때 0 또는 1이 나올수 있는 베스트
            // 0 또는 1이 나오면 진행 X
            if ((n % 2 == 0 && ans[0] == 0) || (n % 2 != 0 && ans[0] == 1)) {
                break;
            }

            divideArea(n, mat, wires[i], ans);
        }

        return ans[0];
    }

    public static void divideArea(int n, boolean[][] mat, int[] wire, int[] ans) {
        // 송전탑 방문 여부
        boolean[] isVisited = new boolean[n + 1];

        Queue<Integer> que = new LinkedList<>();
        que.add(1);

        // 1번 송전탑부터 시작하여 방문하는 수
        int vc = 0;
        while (!que.isEmpty()) {
            // 현재 송전탑
            int cn = que.poll();
            // 방문안한 송전탑이면 방문하고 vc값 증가
            if (!isVisited[cn]) {
                isVisited[cn] = true;
                vc++;
            }

            for (int i = 1; i <= n; i++) {
                // 연결안되어 있으면 넘어감
                if ((cn == wire[0] && i == wire[1]) || (cn == wire[1] && i == wire[0])) {
                    continue;
                }

                // 방문안하고 현재 송전탑과 연결되어 있어야 추가
                if (!isVisited[i] && mat[cn][i]) {
                    que.add(i);
                }
            }
        }

        // 송전탑 개수 차이의 최소를 갱신
        ans[0] = Math.min(ans[0], Math.abs(vc * 2 - n));
    }
}

public class lv3_네트워크 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[] ns = {
                3, 3
        };
        int[][][] computerss = {
                {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}},
                {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}
        };

        for (int i = 0; i < ns.length; i++) {
            result.append(solution(ns[i], computerss[i])).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(int n, int[][] computers) {
        // 방문 체크
        boolean[] isVisited = new boolean[n];

        // 네트워크 수
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                DFS(n, computers, isVisited, i);
                ans++;
            }
        }

        return ans;
    }

    public static void DFS(int n, int[][] computers, boolean[] isVisited, int cc) {
        for (int i = 0; i < n; i++) {
            if (!isVisited[i] && computers[cc][i] == 1) {
                isVisited[i] = true;
                DFS(n, computers, isVisited, i);
            }
        }
    }
}

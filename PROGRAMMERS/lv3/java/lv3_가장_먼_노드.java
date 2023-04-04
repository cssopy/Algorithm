import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class lv3_가장_먼_노드 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}})
        };

        for (Inp inp : inps) {
            result.append(solution(inp.n, inp.vertex)).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(int n, int[][] edge) {
        // 그래프 생성
        boolean[][] graph = new boolean[n + 1][n + 1];
        for (int[] e : edge) {
            graph[e[0]][e[1]] = true;
            graph[e[1]][e[0]] = true;
        }

        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.depth));
        boolean[] isVisited = new boolean[n + 1];
        q.add(new Node(1, 0));
        isVisited[1] = true;

        // 가장 멀리 떨어진(깊은) 노드 개수
        int ans = 0;
        // 가장 먼 거리(깊이)
        int md = -1;
        while (!q.isEmpty()) {
            Node cn = q.poll();

            if (cn.depth > md) {
                ans = 0;
                md = cn.depth;
            }
            ans++;

            for (int i = 1; i <= n; i++) {
                if (!isVisited[i] && graph[cn.num][i]) {
                    isVisited[i] = true;
                    q.add(new Node(i, cn.depth + 1));
                }
            }
        }

        return ans;
    }

    static class Node {
        int num;
        int depth;

        Node(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }

    static class Inp {
        int n;
        int[][] vertex;

        Inp(int n, int[][] vertex) {
            this.n = n;
            this.vertex = vertex;
        }
    }
}

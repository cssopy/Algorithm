import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_11724 {
    public static void main(String[] args) {
        int N, M;
        ArrayList<Integer>[] graph;

        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
            M = sc.nextInt();

            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                graph[from].add(to);
                graph[to].add(from);
            }
        }

        int answer = 0;
        // 노드 방문 확인용
        Set<Integer> set = new HashSet<>();
        // 1번노드부터 N번노드까지 차례로 dfs 수행
        // 방문안한 노드면 새로운 연결 요소인 것
        for (int i = 1; i <= N; i++) {
            if (!set.contains(i)) {
                dfs(i, graph, set);
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void dfs(int node, ArrayList<Integer>[] graph, Set<Integer> set) {
        // 노드 방문처리
        set.add(node);

        // 다음 노드 방문
        for (int next : graph[node]) {
            if (!set.contains(next)) {
                dfs(next, graph, set);
            }
        }
    }
}

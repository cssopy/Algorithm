import java.util.*;

public class BJ_1389 {
    public static void main(String[] args) {
        int N, M;
        boolean[][] graph;
        try (Scanner sc = new Scanner(System.in)) {
            String[] inps = sc.nextLine().split(" ");
            N = Integer.parseInt(inps[0]);
            M = Integer.parseInt(inps[1]);

            graph = new boolean[N + 1][N + 1];
            for (int i = 0; i < M; i++) {
                inps = sc.nextLine().split(" ");
                int a = Integer.parseInt(inps[0]);
                int b = Integer.parseInt(inps[1]);

                graph[a][b] = true;
                graph[b][a] = true;
            }
        }

        // 사람별 케빈베이컨지수가 같으면 번호기준 오름차순으로 다르면 케빈베이컨지수기준 오름차순으로 정렬
        Queue<Person> que = new PriorityQueue<>((a, b) -> {
            if (a.kevinBacon == b.kevinBacon) {
                return Integer.compare(a.num, b.num);
            } else {
                return Integer.compare(a.kevinBacon, b.kevinBacon);
            }
        });
        // 사람마다 bfs로 케빈베이컨지수를 구하여 que에 삽입
        for (int i = 1; i <= N; i++) {
            que.add(bfs(N, M, graph, new Person(i, 0, 0)));
        }

        System.out.println(que.poll().num);
    }

    static Person bfs(int N, int M, boolean[][] graph, Person start) {
        Queue<Person> que = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        que.add(start);
        set.add(start.num);

        int kevinBacon = 0;
        while (!que.isEmpty()) {
            Person cp = que.poll();

            kevinBacon += cp.depth;

            for (int i = 1; i <= N; i++) {
                if (cp.num != i && graph[cp.num][i] && !set.contains(i)) {
                    set.add(i);
                    que.add(new Person(i, 0, cp.depth + 1));
                }
            }
        }

        return new Person(start.num, kevinBacon, 0);
    }

    static class Person {
        int num;
        int kevinBacon;
        int depth;

        Person(int num, int kevinBacon, int depth) {
            this.num = num;
            this.kevinBacon = kevinBacon;
            this.depth = depth;
        }
    }
}

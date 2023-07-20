import java.util.*;

public class BJ_2644 {
    public static void main(String[] args) {
        int n;
        int a, b;
        int m;
        boolean[][] xy;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();
            m = sc.nextInt();
            xy = new boolean[n + 1][n + 1];
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                xy[x][y] = true;
                xy[y][x] = true;
            }
        }

        Queue<Person> que = new PriorityQueue<>(Comparator.comparingInt(x -> x.depth));
        Set<Integer> isVisited = new HashSet<>();
        que.add(new Person(a, 0));
        isVisited.add(a);
        int answer = -1;
        while (!que.isEmpty()) {
            Person p = que.poll();

            if (p.number == b) {
                answer = p.depth;
                break;
            }

            for (int i = 1; i <= n; i++) {
                if (!isVisited.contains(i) && xy[p.number][i]) {
                    isVisited.add(i);
                    que.add(new Person(i, p.depth + 1));
                }
            }
        }

        System.out.println(answer);
    }

    static class Person {
        int number;
        int depth;

        Person(int number, int depth) {
            this.number = number;
            this.depth = depth;
        }
    }
}

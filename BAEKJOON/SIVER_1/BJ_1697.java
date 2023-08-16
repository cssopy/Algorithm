import java.util.*;

public class BJ_1697 {
    public static void main(String[] args) {
        int N, K;
        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
            K = sc.nextInt();
        }

        Queue<Point> que = new ArrayDeque<>();
        Set<Integer> isVisited = new HashSet<>();
        que.add(new Point(N, 0));
        isVisited.add(N);

        int answer = 0;
        while (!que.isEmpty()) {
            Point n = que.poll();

            if (n.n == K) {
                answer = n.depth;
                break;
            }

            if (n.n - 1 >= 0 && n.n <= 100000 && isVisited.contains(n.n - 1) == false) {
                isVisited.add(n.n - 1);
                que.add(new Point(n.n - 1, n.depth + 1));
            }
            if (n.n + 1 <= 100000 && n.n >= 0 && isVisited.contains(n.n + 1) == false) {
                isVisited.add(n.n + 1);
                que.add(new Point(n.n + 1, n.depth + 1));
            }
            if (n.n * 2 <= 100000 && n.n >= 0 && isVisited.contains(n.n * 2) == false) {
                isVisited.add(n.n * 2);
                que.add(new Point(n.n * 2, n.depth + 1));
            }
        }

        System.out.println(answer);
    }

    static class Point {
        int n;
        int depth;

        Point(int n, int depth) {
            this.n = n;
            this.depth = depth;
        }
    }
}

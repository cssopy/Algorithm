import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2178 {
    public static void main(String[] args) {
        int N, M;
        char[][] map;
        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
            M = sc.nextInt();
            map = new char[N][];
            for (int i = 0; i < N; i++) {
                String inp = sc.next();
                map[i] = inp.toCharArray();
            }
        }

        Queue<Point> que = new ArrayDeque<>();
        que.add(new Point(0, 0, 1));
        map[0][0] = '0';

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int answer = 0;
        while (!que.isEmpty()) {
            Point cp = que.poll();

            if (cp.i == N - 1 && cp.j == M - 1) {
                answer = cp.depth;
                break;
            }

            for (int dir = 0; dir < dirs.length; dir++) {
                int ni = cp.i + dirs[dir][0];
                int nj = cp.j + dirs[dir][1];

                if (ni < 0 || ni >= N || nj < 0 || nj >= M) {
                    continue;
                }

                if (map[ni][nj] == '1') {
                    map[ni][nj] = '0';
                    que.add(new Point(ni, nj, cp.depth + 1));
                }
            }
        }

        System.out.println(answer);
    }

    static class Point {
        int i, j;
        int depth;

        Point(int i, int j, int depth) {
            this.i = i;
            this.j = j;
            this.depth = depth;
        }
    }
}

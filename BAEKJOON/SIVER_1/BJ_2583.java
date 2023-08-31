import java.util.*;

public class BJ_2583 {
    public static void main(String[] args) {
        int M, N, K;
        int[][] map;
        try (Scanner sc = new Scanner(System.in)) {
            String[] inps = sc.nextLine().split(" ");
            M = Integer.parseInt(inps[0]);
            N = Integer.parseInt(inps[1]);
            K = Integer.parseInt(inps[2]);
            map = new int[N][M];

            // 맵에 사각형 영역 표시
            for (int i = 0; i < K; i++) {
                int[] points = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int x = points[0]; x < points[2]; x++) {
                    for (int y = points[1]; y < points[3]; y++) {
                        map[x][y] = 1;
                    }
                }
            }

            Queue<Integer> pq = new PriorityQueue<>();
            // 사각형이 아닌 칸에서 시작하여 bfs를 통해 영역의 넓이를 구함
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (map[x][y] == 0) {
                        bfs(N, M, map, x, y, pq);
                    }
                }
            }

            System.out.println(pq.size());
            while (!pq.isEmpty()){
                System.out.print(pq.poll() + " ");
            }
            System.out.println();
        }
    }

    static void bfs(int N, int M, int[][] map, int x, int y, Queue<Integer> pq) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x, y));
        map[x][y] = 1;

        int area = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!q.isEmpty()) {
            Point cp = q.poll();

            area++;

            for (int dir = 0; dir < dirs.length; dir++) {
                int nx = cp.x + dirs[dir][0];
                int ny = cp.y + dirs[dir][1];

                if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    q.add(new Point(nx, ny));
                }
            }
        }

        pq.add(area);
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

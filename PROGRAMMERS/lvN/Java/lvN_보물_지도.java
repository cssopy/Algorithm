import java.util.LinkedList;
import java.util.Queue;

public class lvN_보물_지도 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp(4, 4, new int[][]{{2, 3}, {3, 3}}),
                new Inp(5, 4, new int[][]{{1, 4}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {3, 3}, {4, 1}, {4, 3}, {5, 3}}),
                new Inp(5, 4, new int[][]{{1, 4}, {2, 1}, {4, 2}, {2, 3}, {2, 4}, {3, 3}, {4, 1}, {4, 3}, {5, 3}})
        };

        for (Inp inp : inps) {
            result.append(String.format("%d\n", solution(inp.n, inp.m, inp.hole)));
        }

        System.out.println(result);
    }

    public static int solution(int n, int m, int[][] hole) {
        boolean[][] map = initMap(n, m, hole);

        return findTreasure(n, m, map);
    }

    static int findTreasure(int n, int m, boolean[][] map) {
        Queue<Point> que = new LinkedList<>();
        // 더블점프를 사용했고 안했고 구분하여 방문여부를 표시
        // 더블점프를 한 이후의 방문여부를 구분하지 않는다면 더블점프를 하지 않은 경우에서 진행이 안되는 경우가 존재
        boolean[][][] isVisited = new boolean[n][m][2];

        que.add(new Point(0, 0, 0, 0));
        isVisited[0][0][0] = true;

        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        while (!que.isEmpty()) {
            Point p = que.poll();

            for (int dir = 0; dir < dirs.length; dir++) {
                int nx = p.x + dirs[dir][0];
                int ny = p.y + dirs[dir][1];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (!map[nx][ny] && !isVisited[nx][ny][p.isUsedSkill]) {
                        if (nx == n - 1 && ny == m - 1) {
                            return p.depth + 1;
                        }
                        isVisited[nx][ny][p.isUsedSkill] = true;
                        que.add(new Point(nx, ny, p.depth + 1, p.isUsedSkill));
                    }
                }

                // 더블점프를 사용하지 않은 경우
                if (p.isUsedSkill == 0) {
                    nx += dirs[dir][0];
                    ny += dirs[dir][1];

                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (!map[nx][ny] && !isVisited[nx][ny][1]) {
                            if (nx == n - 1 && ny == m - 1) {
                                return p.depth + 1;
                            }
                            isVisited[nx][ny][1] = true;
                            que.add(new Point(nx, ny, p.depth + 1, 1));
                        }
                    }
                }
            }
        }

        return -1;
    }

    static boolean[][] initMap(int n, int m, int[][] hole) {
        boolean[][] map = new boolean[n][m];

        for (int[] h : hole) {
            int x = h[0] - 1;
            int y = h[1] - 1;

            map[x][y] = true;
        }

        return map;
    }

    static class Point {
        int x, y;
        int depth;
        int isUsedSkill;

        Point(int x, int y, int depth, int isUsedSkill) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.isUsedSkill = isUsedSkill;
        }
    }

    static class Inp {
        int n, m;
        int[][] hole;

        Inp(int n, int m, int[][] hole) {
            this.n = n;
            this.m = m;
            this.hole = hole;
        }
    }
}

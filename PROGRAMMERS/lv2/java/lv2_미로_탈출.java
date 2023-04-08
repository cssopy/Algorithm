import java.util.LinkedList;
import java.util.Queue;

public class lv2_미로_탈출 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[][] inps = {
                {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"},
                {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}
        };

        for (String[] inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(String[] maps) {
        char[][] map = new char[maps.length][];
        initMap(maps, map);
        Point[] sle = new Point[3];
        initSLE(map, sle);

        int ans = 0;
        // 출발지에서 레버로 이동 시도하여 갈 수 없으면 -1리턴, 갈 수 있으면 레버까지 걸리는 시간 더해줌
        int c = goDestination(map, sle[0], sle[1]);
        if (c == -1) return -1;
        ans += c;

        // 레버위치에서 도착지까지 시도하여 갈 수 없으면 -1리턴, 갈 수 있으면 도착지까지 걸리는 시간 더해줌
        c = goDestination(map, sle[1], sle[2]);
        if (c == -1) return -1;
        ans += c;

        return ans;
    }

    static void initMap(String[] maps, char[][] map) {
        for (int i = 0; i < map.length; i++) {
            map[i] = maps[i].toCharArray();
        }
    }

    static void initSLE(char[][] map, Point[] sle) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                char c = map[i][j];

                if (c != 'X' && c != 'O') {
                    if (c == 'S') {
                        sle[0] = new Point(i, j, 0);
                    }
                    if (c == 'L') {
                        sle[1] = new Point(i, j, 0);
                    }
                    if (c == 'E') {
                        sle[2] = new Point(i, j, 0);
                    }
                }

                if (sle[0] == null || sle[1] == null || sle[2] == null) continue;
                return;
            }
        }
    }

    static int goDestination(char[][] map, Point start, Point end) {
        int H = map.length;
        int W = map[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<Point> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[H][W];
        q.add(start);
        isVisited[start.i][start.j] = true;

        while (!q.isEmpty()) {
            Point cp = q.poll();

            for (int dir = 0; dir < dirs.length; dir++) {
                int ni = cp.i + dirs[dir][0];
                int nj = cp.j + dirs[dir][1];

                if (ni < 0 || ni >= H || nj < 0 || nj >= W) continue;

                if (ni == end.i && nj == end.j) return cp.depth + 1;

                if (map[ni][nj] != 'X' && !isVisited[ni][nj]) {
                    isVisited[ni][nj] = true;
                    q.add(new Point(ni, nj, cp.depth + 1));
                }
            }
        }

        return -1;
    }

    static class Point {
        int i, j, depth;

        Point(int i, int j, int depth) {
            this.i = i;
            this.j = j;
            this.depth = depth;
        }
    }
}

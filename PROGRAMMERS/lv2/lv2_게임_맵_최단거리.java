import java.util.LinkedList;
import java.util.Queue;

public class lv2_게임_맵_최단거리 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][][] maps = {
                {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}},
                {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}
        };

        for (int[][] map : maps) {
            result.append(solution(map)).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(int[][] map) {
        // 도달가능 체크 (출발지와 도착지가 막혔는지 여부)
        if (!isReachable(map)) return -1;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(0, 0, 1));
        map[0][0] = 0;

        int ans = -1;
        while (!q.isEmpty()) {
            Point cp = q.poll();

            // 도착하면 종료
            if (cp.i == map.length - 1 && cp.j == map[0].length - 1) {
                ans = cp.d;
                break;
            }

            // 사방 탐색
            for (int dir = 0; dir < dirs.length; dir++) {
                // 다음 좌표들
                int ni = cp.i + dirs[dir][0];
                int nj = cp.j + dirs[dir][1];

                // 다음 좌표가 맵을 안 벗어났는지
                if (0 <= ni && ni < map.length && 0 <= nj && nj < map[0].length) {
                    // 다음 좌표가 통로인지
                    if (map[ni][nj] == 1) {
                        q.add(new Point(ni, nj, cp.d + 1));
                        map[ni][nj] = 0;
                    }
                }
            }
        }

        return ans;
    }

    static boolean isReachable(int[][] map) {
        if (map.length == 1 && map[0].length >= 3) {
            if (map[0][map[0].length - 2] == 0) return false;
            if (map[0][1] == 0) return false;
            return true;
        }

        if (map.length >= 3 && map[0].length == 1) {
            if (map[map.length - 2][0] == 0) return false;
            if (map[1][0] == 0) return false;
            return true;
        }

        if (map.length >= 2 && map[0].length >= 2) {
            if (map[map.length - 2][map[0].length - 1] == 0 && map[map.length - 1][map[0].length - 2] == 0) return false;
            if (map[0][1] == 0 && map[1][0] == 0) return false;
            return true;
        }

        return true;
    }

    static class Point {
        int i, j;
        int d;

        Point(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }
}

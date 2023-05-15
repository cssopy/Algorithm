import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class lv3_경주로_건설 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][][] inps = {
                {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}},
                {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}},
                {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}}
        };

        for (int[][] inp : inps) {
            result.append(String.format("%d\n", solution(inp)));
        }

        System.out.println(result);
    }

    public static int solution(int[][] board) {
        Queue<Point> q = new LinkedList<>();
        int[][][] costTable = new int[4][board.length][board.length];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < board.length; j++) {
                Arrays.fill(costTable[i][j], Integer.MAX_VALUE);
            }
        }

        q.add(new Point(0, 0, 0, -1));

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            Point cp = q.poll();

            for (int dir = 0; dir < dirs.length; dir++) {
                int nr = cp.r + dirs[dir][0];
                int nc = cp.c + dirs[dir][1];

                // 다음 좌표가 맵 밖이거나 벽이면 continue
                if (!(0 <= nr && nr < board.length && 0 <= nc && nc < board.length)) continue;
                if (board[nr][nc] == 1) continue;

                // 다음 좌표 비용 계산
                int ncost = cp.cost;
                if (dir == cp.dir || cp.dir == -1) ncost += 100;
                else ncost += 600;

                // 앞전에 비용이 결정된 것보다 더 큰 비용이 들어왔을 때는 무시, 방문여부의 역할도 가능
                if (ncost > costTable[dir][nr][nc]) continue;

                costTable[dir][nr][nc] = ncost;
                q.add(new Point(nr, nc, ncost, dir));
            }
        }

        // 모든 방향에서 도착지에 들어온 비용 중 최소비용을 구함
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, costTable[i][board.length - 1][board.length - 1]);
        }
        return answer;
    }

    static class Point {
        int r, c;
        int cost;
        int dir;

        Point(int r, int c, int cost, int dir) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.dir = dir;
        }
    }
}

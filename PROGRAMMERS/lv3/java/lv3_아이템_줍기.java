import java.util.LinkedList;
import java.util.Queue;

public class lv3_아이템_줍기 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp(new int[][]{{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}}, 1, 3, 7, 8),
                new Inp(new int[][]{{1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}}, 9, 7, 6, 1),
                new Inp(new int[][]{{1, 1, 5, 7}}, 1, 1, 4, 7),
                new Inp(new int[][]{{2, 1, 7, 5}, {6, 4, 10, 10}}, 3, 1, 7, 10),
                new Inp(new int[][]{{2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6}}, 1, 4, 6, 3)
        };

        for (Inp inp : inps) {
            result.append(solution(inp.rectangle, inp.characterX, inp.characterY, inp.itemX, inp.itemY)).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = makeMap(rectangle);

        return move(map, characterX, characterY, itemX, itemY);
    }

    static int[][] makeMap(int[][] rectangle) {
        int[][] map = new int[102][102];

        // 테두리 표시
        for (int rn = 0; rn < rectangle.length; rn++) {
            int[] rp = rectangle[rn];

            for (int i = rp[1]; i <= rp[3]; i++) {
                for (int j = rp[0]; j <= rp[2]; j++) {
                    if (i == rp[1] || i == rp[3] || j == rp[0] || j == rp[2]) {
                        // 주요 포인트 채우기
                        map[i * 2][j * 2] = 1;
                        // 주요 포인트 사이의 빈 공간 채우기
                        if ((i == rp[1] || i == rp[3]) && j != rp[2]) map[i * 2][j * 2 + 1] = 1;
                        if ((j == rp[0] || j == rp[2]) && i != rp[3]) map[i * 2 + 1][j * 2] = 1;
                    }
                }
            }
        }

        // 속 비우기
        for (int rn = 0; rn < rectangle.length; rn++) {
            int[] rp = rectangle[rn];

            for (int i = rp[1]; i <= rp[3]; i++) {
                for (int j = rp[0]; j <= rp[2]; j++) {
                    if (i != rp[1] && i != rp[3] && j != rp[0] && j != rp[2]) {
                        map[i * 2][j * 2] = 0;
                    }
                    if (j != rp[0] && j != rp[2] && i != rp[3]) {
                        map[i * 2 + 1][j * 2] = 0;
                    }
                    if (i != rp[1] && i != rp[3] && j != rp[2]) {
                        map[i * 2][j * 2 + 1] = 0;
                    }
                    if (j != rp[2] && i != rp[3]) {
                        map[i * 2 + 1][j * 2 + 1] = 0;
                    }
                }
            }
        }

        return map;
    }

    static int move(int[][] map, int characterX, int characterY, int itemX, int itemY) {
        // 상하좌우
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(characterY * 2, characterX * 2, 0));
        map[characterY * 2][characterX * 2] = 0;
        int ans = 0;
        while (!q.isEmpty()) {
            Point cp = q.poll();

            if (cp.i == itemY * 2 && cp.j == itemX * 2) {
                ans = cp.depth / 2;
                break;
            }

            for (int dir = 0; dir < dirs.length; dir++) {
                int ni = cp.i + dirs[dir][0];
                int nj = cp.j + dirs[dir][1];

                if (0 <= ni && ni < map.length && 0 <= nj && nj < map.length) {
                    if (map[ni][nj] == 1) {
                        map[ni][nj] = 0;
                        q.add(new Point(ni, nj, cp.depth + 1));
                    }
                }
            }
        }

        return ans;
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

    static class Inp {
        int[][] rectangle;
        int characterX, characterY, itemX, itemY;

        Inp(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            this.rectangle = rectangle;
            this.characterX = characterX;
            this.characterY = characterY;
            this.itemX = itemX;
            this.itemY = itemY;
        }
    }
}

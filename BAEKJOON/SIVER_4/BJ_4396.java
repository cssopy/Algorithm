import java.util.Scanner;

public class BJ_4396 {
    public static void main(String[] args) {
        int N;
        char[][] map1, map2;
        boolean isClickedBomb = false;

        // 입력
        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();

            map1 = new char[N][N];
            map2 = new char[N][N];
            for (int i = 0; i < N; i++) {
                String row = sc.next();
                for (int j = 0; j < row.length(); j++) {
                    map1[i][j] = row.charAt(j);
                }
            }
            for (int i = 0; i < N; i++) {
                String row = sc.next();
                for (int j = 0; j < row.length(); j++) {
                    map2[i][j] = row.charAt(j);
                    if (!isClickedBomb && map2[i][j] == 'x' && map1[i][j] == '*') {
                        isClickedBomb = true;
                    }
                }
            }
        }

        char[][] result = solution(N, map1, map2, isClickedBomb);

        StringBuilder sb = new StringBuilder();
        for (char[] row : result) {
            for (char v : row) {
                sb.append(v);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static char[][] solution(int N, char[][] map1, char[][] map2, boolean isClickedBomb) {
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        // 누른 곳 기준 팔방탐색을 통해 폭탄 개수 카운트하여 숫자 결정
        char[][] result = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map2[i][j] == 'x') {
                    int bombNum = 0;
                    for (int dir = 0; dir < dirs.length; dir++) {
                        int ni = i + dirs[dir][0];
                        int nj = j + dirs[dir][1];

                        if (ni < 0 || ni >= N || nj < 0 || nj >= N) {
                            continue;
                        }

                        if (map1[ni][nj] == '*') {
                            bombNum++;
                        }
                    }

                    result[i][j] = (char) ('0' + bombNum);
                } else {
                    result[i][j] = '.';
                }
            }
        }

        // 누른 곳중 폭탄이 있었다면 누른 곳 포함 모든 폭탄을 표시
        if (isClickedBomb) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map1[i][j] == '*') {
                        result[i][j] = '*';
                    }
                }
            }
        }

        return result;
    }
}

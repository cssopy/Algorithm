import java.math.BigInteger;

public class lv3_등굣길 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp(4, 3, new int[][]{{2, 2}})
        };

        for (Inp inp : inps) {
            result.append(String.format("%d\n", solution2(inp.m, inp.n, inp.puddles)));
        }

        System.out.println(result);
    }

    public static int solution(int m, int n, int[][] puddles) {
        BigInteger[][] map = new BigInteger[n][m];

        // 수몰지역 표시
        for (int[] puddle : puddles) {
            map[puddle[1] - 1][puddle[0] - 1] = BigInteger.valueOf(0);
        }

        // 기초작업
        for (int i = 0, f = 0; i < m; i++) {
            if (map[0][i] != null && map[0][i].equals(BigInteger.ZERO)) f = 1;

            if (f == 0) {
                map[0][i] = BigInteger.ONE;
            } else {
                map[0][i] = BigInteger.ZERO;
            }
        }
        for (int i = 0, f = 0; i < n; i++) {
            if (map[i][0] != null && map[i][0].equals(BigInteger.ZERO)) f = 1;

            if (f == 0) {
                map[i][0] = BigInteger.ONE;
            } else {
                map[i][0] = BigInteger.ZERO;
            }
        }

        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                if (map[r][c] != null && map[r][c].equals(BigInteger.ZERO)) {
                    map[r][c] = BigInteger.ZERO;
                    continue;
                }
                map[r][c] = map[r - 1][c].add(map[r][c - 1]);
            }
        }

        return map[n - 1][m - 1].remainder(BigInteger.valueOf(1_000_000_007)).intValue();
    }

    static int solution2(int m, int n, int[][] puddles) {
        int[][] map = new int[m][n];

        // 수몰지역 표시
        for (int[] puddle : puddles) {
            map[puddle[0] - 1][puddle[1] - 1] = -1;
        }

        // 기초작업
        for (int i = 0, f = 0; i < m; i++) {
            if (map[i][0] == -1) f = 1;

            if (f == 0) {
                map[i][0] = 1;
            } else {
                map[i][0] = 0;
            }
        }
        for (int i = 0, f = 0; i < n; i++) {
            if (map[0][i] == -1) f = 1;

            if (f == 0) {
                map[0][i] = 1;
            } else {
                map[0][i] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = (map[i - 1][j] + map[i][j - 1]) % 1_000_000_007;
            }
        }

        return map[m - 1][n - 1];
    }

    static class Inp {
        int m, n;
        int[][] puddles;

        Inp(int m, int n, int[][] puddles) {
            this.m = m;
            this.n = n;
            this.puddles = puddles;
        }
    }
}

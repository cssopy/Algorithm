public class lv3_합승_택시_요금 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}),
                new Inp(7, 3, 4, 1, new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}),
                new Inp(6, 4, 5, 6, new int[][]{{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}})
        };

        for (Inp inp : inps) {
            result.append(String.format("%d\n", solution(inp.n, inp.s, inp.a, inp.b, inp.fares)));
        }

        System.out.println(result);
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        // 플로이드 워셜 테이블 생성
        int[][] table = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    table[i][j] = 0;
                    continue;
                }
                table[i][j] = 20_000_000;
            }
        }

        // 간선 정보 테이블에 입력
        for (int[] fare : fares) {
            table[fare[0]][fare[1]] = fare[2];
            table[fare[1]][fare[0]] = fare[2];
        }

        // 플로이드 워셜
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k) continue;

                for (int j = 1; j <= n; j++) {
                    if (j == i) continue;

                    table[i][j] = Math.min(table[i][j], table[i][k] + table[k][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        // 시작지점에서 i지점, i지점에서 a, i지점에서 b까지 합이 최소인 값을 찾음
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, table[s][i]+table[i][a]+table[i][b]);
        }

        return answer;
    }

    static class Inp {
        int n, s, a, b;
        int[][] fares;

        Inp(int n, int s, int a, int b, int[][] fares) {
            this.n = n;
            this.s = s;
            this.a = a;
            this.b = b;
            this.fares = fares;
        }
    }
}

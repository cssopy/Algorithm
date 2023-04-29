public class lv0_이차원_배열_대각선_순회하기 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp(new int[][]{{0, 1, 2}, {1, 2, 3}, {2, 3, 4}, {3, 4, 5}}, 2)
        };

        for (Inp inp : inps) {
            result.append(String.format("%d\n", solution(inp.board, inp.k)));
        }

        System.out.println(result);
    }

    public static int solution(int[][] board, int k) {
        int ans = 0;
        for (int i = 0; i < board.length && i <= k; i++) {
            for (int j = 0; j < board[0].length && j <= k; j++) {
                if (i + j <= k) ans += board[i][j];
            }
        }

        return ans;
    }

    static class Inp {
        int[][] board;
        int k;

        Inp(int[][] board, int k) {
            this.board = board;
            this.k = k;
        }
    }
}

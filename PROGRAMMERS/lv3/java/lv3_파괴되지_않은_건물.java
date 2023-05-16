public class lv3_파괴되지_않은_건물 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}}, new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}}),
                new Inp(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}})
        };

        for (Inp inp : inps) {
            result.append(String.format("%d\n", solution(inp.board, inp.skill)));
        }

        System.out.println(result);
    }

    public static int solution(int[][] board, int[][] skills) {
        int[][] st = new int[board.length + 1][board[0].length + 1];
        for (int[] skill : skills) {
            if (skill[0] == 1) {
                st[skill[1]][skill[2]] -= skill[5];
                st[skill[3] + 1][skill[4] + 1] -= skill[5];
                st[skill[1]][skill[4] + 1] += skill[5];
                st[skill[3] + 1][skill[2]] += skill[5];
            } else {
                st[skill[1]][skill[2]] += skill[5];
                st[skill[3] + 1][skill[4] + 1] += skill[5];
                st[skill[1]][skill[4] + 1] -= skill[5];
                st[skill[3] + 1][skill[2]] -= skill[5];
            } 
        }

        // st 행렬 누적합 계산
        for (int i = 1; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                st[i][j] += st[i - 1][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                st[i][j] += st[i][j - 1];
            }
        }

        // board와 누적합 테이블을 연산하며 파고되지 않는 건물 카운트
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] += st[i][j];
                if (board[i][j] > 0) answer++;
            }
        }

        return answer;
    }

    static class Inp {
        int[][] board;
        int[][] skill;

        Inp(int[][] board, int[][] skill) {
            this.board = board;
            this.skill = skill;
        }
    }
}

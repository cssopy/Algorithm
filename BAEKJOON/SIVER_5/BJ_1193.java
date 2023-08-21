import java.util.Scanner;

public class BJ_1193 {
    public static void main(String[] args) {
        int X;
        try (Scanner sc = new Scanner(System.in)) {
            X = sc.nextInt();
        }

        // 1, 1부터 시작
        Point p = new Point(1, 1, X);
        // k : 대각선으로 이동하는 횟수
        for (int k = 1; ; ) {
            // 오른쪽 한칸 이동
            p.move(0);

            if (p.moveDone) {
                break;
            }

            // 왼쪽아래 대각선 k번 이동
            for (int i = 0; i < k; i++) {
                p.move(1);

                if (p.moveDone) {
                    break;
                }
            }
            k++;

            // 아래 한칸 이동
            p.move(2);

            if (p.moveDone) {
                break;
            }

            // 오른쪽위 대각선 k번 이동
            for (int i = 0; i < k; i++) {
                p.move(3);

                if (p.moveDone) {
                    break;
                }
            }
            k++;
        }

        System.out.println(p.r + "/" + p.c);
    }

    static class Point {
        int r, c;
        int moveCount = 1;
        int maxMove;
        boolean moveDone = false;
        private int[][] dirs = {{0, 1}, {1, -1}, {1, 0}, {-1, 1}};

        Point(int r, int c, int maxMove) {
            this.r = r;
            this.c = c;
            this.maxMove = maxMove;
        }

        void move(int dir) {
            if (this.moveCount >= this.maxMove) {
                this.moveDone = true;
                return;
            }

            this.r += dirs[dir][0];
            this.c += dirs[dir][1];
            this.moveCount++;

            if (this.moveCount >= this.maxMove) {
                this.moveDone = true;
            }
        }
    }
}

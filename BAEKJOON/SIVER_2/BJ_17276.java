import java.util.Scanner;

public class BJ_17276 {
    public static void main(String[] args) {
        int T;
        int n, d;
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(System.in)) {
            T = sc.nextInt();

            for (int t = 0; t < T; t++) {
                n = sc.nextInt();
                d = sc.nextInt();

                int[][] arr = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        arr[i][j] = sc.nextInt();
                    }
                }

                // ex) -45 = 360-45
                if (d < 0) {
                    d += 360;
                }
                d /= 45;

                // 45도씩 회전
                for (int i = 0; i < d; i++) {
                    arr = rotateArr(arr);
                }

                for (int[] row : arr) {
                    for (int v : row) {
                        sb.append(v).append(' ');
                    }
                    sb.append('\n');
                }
            }
        }

        System.out.print(sb);
    }

    static int[][] rotateArr(int[][] arr) {
        int n = arr.length;

        // arr의 원소를 45도회전하여 t배열에 저장
        int[][] t = new int[n][n];
        for (int i = 0; i < n; i++) {
            t[i][n / 2] = arr[i][i];
            t[i][i] = arr[n / 2][i];
            t[n / 2][i] = arr[n - i - 1][i];
            t[n - i - 1][i] = arr[n - i - 1][n / 2];
        }

        // arr배열에서 회전하지 않은 값 추가저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (t[i][j] == 0) {
                    t[i][j] = arr[i][j];
                }
            }
        }

        return t;
    }
}

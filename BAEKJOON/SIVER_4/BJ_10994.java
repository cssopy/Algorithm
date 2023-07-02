import java.util.Scanner;

public class BJ_10994 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            solution(N);
        }
    }

    static void solution(int N) {
        char[][] stars = new char[4 * (N - 1) + 1][4 * (N - 1) + 1];

        // 제일 바깥부터 안쪽으로 테두리만 별을 찍음
        // 안쪽으로 들어갈때는 한칸씩이 아닌 두칸씩 이동
        for (int i = 0; i < 2 * N; i += 2) {
            for (int r = i; r < 4 * (N - 1) + 1 - i; r++) {
                stars[i][r] = '*';
                stars[4 * (N - 1) - i][r] = '*';
                stars[r][i] = '*';
                stars[r][4 * (N - 1) - i] = '*';
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stars.length; i++) {
            for (int j = 0; j < stars.length; j++) {
                if (stars[i][j] == '*') {
                    result.append('*');
                } else {
                    result.append(' ');
                }
            }
            result.append('\n');
        }

        System.out.print(result);
    }
}

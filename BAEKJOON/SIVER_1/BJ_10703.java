import java.util.Scanner;

public class BJ_10703 {
    public static void main(String[] args) {
        int R, S;
        char[][] photo;
        try (Scanner sc = new Scanner(System.in)) {
            R = sc.nextInt();
            S = sc.nextInt();

            photo = new char[R][];
            for (int i = 0; i < R; i++) {
                photo[i] = sc.next().toCharArray();
            }
        }

        // 모든 열에 대해 운석이 최대로 내려올 수 있는 거리 중 최소 거리 구함
        int min = getMinDistance(R, S, photo);

        // 구한 최소 거리만큼 운석 이동
        move(R, S, photo, min);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < R; i++) {
            answer.append(new String(photo[i])).append('\n');
        }

        System.out.print(answer);
    }

    static int getMinDistance(int R, int S, char[][] photo) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < S; i++) {
            int c = 0;

            for (int j = R - 1, f = 0; j >= 0; j--) {
                if(photo[j][i] == '#'){
                    c = 0;
                }

                if (photo[j][i] == '.') {
                    c++;
                }

                if (photo[j][i] == 'X') {
                    min = Math.min(min, c);
                }
            }
        }

        return min;
    }

    static void move(int R, int S, char[][] photo, int min) {
        for (int i = 0; i < S; i++) {
            for (int j = R - 1; j >= 0; j--) {
                if (photo[j][i] == 'X') {
                    photo[j + min][i] = 'X';
                    photo[j][i] = '.';
                }
            }
        }
    }
}
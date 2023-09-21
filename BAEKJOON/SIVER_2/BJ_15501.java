import java.util.Arrays;
import java.util.Scanner;

public class BJ_15501 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());

            // 길이가 1이면 무조건 good puzzle
            if (n == 1) {
                System.out.println("good puzzle");
                return;
            }

            int[] seq1 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] seq2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 시작 위치 찾기
            int si = 0;
            for (int i = 0; i < n; i++) {
                if (seq2[i] == seq1[0]) {
                    si = i;
                    break;
                }
            }

            // 방향 찾기
            int dir = 0;
            if (seq2[(si + 1) % n] == seq1[1]) {
                dir = 1;
            } else if (seq2[(si - 1 + n) % n] == seq1[1]) {
                dir = -1;
            }

            // 방향 못찾으면 끝
            if (dir == 0) {
                System.out.println("bad puzzle");
                return;
            }

            for (int i = 0; i < n; i++) {
                if (seq1[i] != seq2[si]) {
                    System.out.println("bad puzzle");
                    return;
                }

                si = (si + dir + n) % n;
            }

            System.out.println("good puzzle");
        }
    }
}

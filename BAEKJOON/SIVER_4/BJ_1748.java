import java.util.Scanner;

public class BJ_1748 {
    public static void main(String[] args) {
        int N;
        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
        }

        int answer = 0;
        // 1의 자리수부터 k자리수까지 각 자리수가 등장하는 횟수를 더해줌
        for (int i = 1; i <= N; i *= 10) {
            answer += N - i + 1;
        }

        System.out.println(answer);
    }
}
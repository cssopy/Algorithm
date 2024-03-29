import java.util.Scanner;

public class BJ_19947 {
    public static void main(String[] args) {
        int H, Y;
        try (Scanner sc = new Scanner(System.in)) {
            H = sc.nextInt();
            Y = sc.nextInt();
        }

        int[] answer = {0};
        dfs(H, Y, answer);

        System.out.println(answer[0]);
    }

    static void dfs(int H, int Y, int[] answer) {
        // 최종 이득 중 가장 큰값을 채택
        if (Y == 0) {
            answer[0] = Math.max(answer[0], H);
        }

        // Y값에 따라 1,3,5년으로 할 수 있는 투자가 있다면 수행
        if (Y - 1 >= 0) {
            dfs((int) (H * 1.05), Y - 1, answer);
        }
        if (Y - 3 >= 0) {
            dfs((int) (H * 1.2), Y - 3, answer);
        }
        if (Y - 5 >= 0) {
            dfs((int) (H * 1.35), Y - 5, answer);
        }
    }
}

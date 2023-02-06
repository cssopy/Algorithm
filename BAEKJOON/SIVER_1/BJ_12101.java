import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        result.append(solve(n, k));
        System.out.println(result);
    }

    public static String solve(int n, int k) {
        int[] ns = {1, 2, 3};
        // k번째 식, 현재까지 찾은 식 개수을 나타내는 배열
        Object[] ans = {"", 0};

        GS(n, k, ns, ans, 0, "");

        // 찾았으면 맨 앞 +를 삭제후 반환, 못찾으면 -1 반환
        return ans[0].toString() != "" ? ans[0].toString().substring(1) : "-1";
    }

    // 전수 탐색
    public static void GS(int n, int k, int[] ns, Object[] ans, int sum, String f) {
        if (sum == n) {
            ans[1] = (int) ans[1] + 1;
            if ((int) ans[1] == k) {
                ans[0] = f;
            }
            return;
        }

        for (int i = 0; i < ns.length; i++) {
            // 합이 문제에서 요구하는 n을 넘으면 탐색할 이유 없음
            if (sum + ns[i] <= n) {
                GS(n, k, ns, ans, sum + ns[i], f + "+" + ns[i]);
            }
        }
    }
}

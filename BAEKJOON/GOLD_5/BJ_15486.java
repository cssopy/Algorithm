import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        // 남은 상담일
        int N = Integer.parseInt(br.readLine());
        // 입력될 t,p 저장할 배열
        TP[] tps = new TP[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            tps[i] = new TP(T, P);
        }

        int max = 0;
        // i번째 상담을 수행하거나 못할경우 받을 수 있는 최대 페이
        int[] ans = new int[N + 1];
        for (int i = N - 1; i >= 0; i--) {
            // i일의 상담을 받을 수 있다면
            // i일의 상담페이와 (i+i일의상담기간)일에 최대로 받을 수 있는 페이의 합과
            // i+1일의 페이중 더 높은 페이를 채택
            if (i + tps[i].T <= N) {
                ans[i] = ans[i + tps[i].T] + tps[i].P;
            }
            ans[i] = Math.max(ans[i + 1], ans[i]);
            max = Math.max(max, ans[i]);
        }

        result.append(max);
        System.out.println(result);
    }

    // 상담 기간과 페이를 저장할 클래스
    public static class TP {
        int T, P;

        TP(int T, int P) {
            this.T = T;
            this.P = P;
        }
    }
}

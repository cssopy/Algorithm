import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder[] result;

        int K = Integer.parseInt(br.readLine());
        String[] inps = br.readLine().split(" ");

        // 층 수만큼 크기 할당
        result = new StringBuilder[K];
        for (int i = 0; i < K; i++) {
            result[i] = new StringBuilder();
        }

        solve(0, K, 0, inps.length - 1, result, inps);

        // 첫 층부터 출력
        for (int i = 0; i < K; i++) {
            System.out.println(result[i]);
        }
    }

    public static void solve(int k, int K, int start, int end, StringBuilder[] result, String[] inps) {
        if (k == K) {
            return;
        }

        int middle = (start + end) / 2;
        result[k].append(inps[middle]).append(' ');

        solve(k + 1, K, start, middle - 1, result, inps);
        solve(k + 1, K, middle + 1, end, result, inps);
    }
}

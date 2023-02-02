import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        // 전깃줄의 수
        int N = Integer.parseInt(br.readLine());
        ABC[] abcs = new ABC[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            abcs[i] = new ABC(a, b);
        }

        // A전봇대의 숫자순으로 정렬
        Arrays.sort(abcs, Comparator.comparing(o -> o.a));

        result.append(solve(N, abcs));
        System.out.println(result);
    }

    // 최장 증가 부분 수열을 찾아 N에서 빼면 정답
    public static int solve(int N, ABC[] abcs) {
        int ans = 0;
        // i번째 인덱스에서 끝나는 lis의 길이
        int[] lis = new int[N];
        for (int i = 0; i < N; i++) {
            lis[i] = 1;
            for (int j = 0; j < N; j++) {
                if (abcs[j].b < abcs[i].b) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                    ans = Math.max(ans, lis[i]);
                }
            }
        }
        return N - ans;
    }

    public static class ABC {
        int a, b;

        ABC(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}

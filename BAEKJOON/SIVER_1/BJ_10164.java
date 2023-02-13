import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 행
        int N = Integer.parseInt(st.nextToken());
        // 열
        int M = Integer.parseInt(st.nextToken());
        // O칸 번호
        int K = Integer.parseInt(st.nextToken());

        result.append(solve(N, M, K));
        System.out.println(result);
    }

    public static int solve(int N, int M, int K) {
        // ○표시가 처음 또는 마지막 위치에 있을 경우 = 처음에서 끝까지 갈 수 있는 경우의 수
        if (K == 0 || K == N * M) {
            return getNOTH(0, 0, N - 1, M - 1);
        }

        // 중간 지점 좌표
        int mr = (K - 1) / M;
        int mc = (K - 1) % M;

        // 처음에서 중간까지 경우의 수 * 중간에서 끝까지 경우의 수 = 나올 수 있는 모든 경우의 수
        return getNOTH(0, 0, mr, mc) * getNOTH(mr, mc, N - 1, M - 1);
    }

    // 두 좌표 사이에의 경로 수
    public static int getNOTH(int si, int sj, int ei, int ej) {
        int r = ei - si + 1;
        int c = ej - sj + 1;
        int[][] cb = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0) {
                    cb[i][j] = 1;
                    continue;
                }

                if (j == 0) {
                    cb[i][j] = 1;
                    continue;
                }

                cb[i][j] = cb[i][j - 1] + cb[i - 1][j];
            }
        }
        return cb[r - 1][c - 1];
    }
}

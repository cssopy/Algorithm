import java.util.Scanner;

public class BJ_2503 {
    public static void main(String[] args) {
        int N;
        int[][] mhInps;

        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
            mhInps = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    mhInps[i][j] = sc.nextInt();
                }
            }
        }

        System.out.println(solution(N, mhInps));
    }

    static int solution(int N, int[][] mhInps) {
        int answer = 0;
        for (int i = 123; i <= 987; i++) {
            int h = i / 100;
            int t = i / 10 % 10;
            int o = i % 10;

            // 중복된 숫자가 등장하면 제외
            // 숫자 0이 등장하면 제외
            if (h == t || h == o || t == o) continue;
            if (t == 0 || o == 0) continue;

            boolean f = false;
            for (int[] mhInp : mhInps) {
                int ih = mhInp[0] / 100;
                int it = mhInp[0] / 10 % 10;
                int io = mhInp[0] % 10;

                int strike = 0, ball = 0;

                // 스트라이크 카운트
                if (h == ih) strike++;
                if (t == it) strike++;
                if (o == io) strike++;

                // 볼 카운트
                if (h == it || h == io) ball++;
                if (t == ih || t == io) ball++;
                if (o == ih || o == it) ball++;

                // 스트라이크, 볼 카운트가 민혁이가 내놓은 모든 답의 스트라이크, 볼 카운트와 같아야 함
                if (strike != mhInp[1] || ball != mhInp[2]) {
                    f = true;
                    break;
                }
            }

            if (!f) answer++;
        }

        return answer;
    }
}

import java.util.HashSet;
import java.util.Set;

public class lv3_N으로_표현 {
    public static void main(String[] args) {
        Inp[] inps = {
                new Inp(5, 12),
                new Inp(2, 11)
        };

        for(Inp inp : inps){
            System.out.println(String.format("%d", solution(inp.N, inp.number)));
        }
    }

    public static int solution(int N, int number) {
        // N을 i번 사용하여 만들 수 있는 수들의 집합
        Set<Integer>[] dp = new Set[9];
        for (int i = 0; i < 9; i++) {
            dp[i] = new HashSet<>();
        }

        for (int i = 1; i < 9; i++) {
            int num = 0;

            // N, NN, NNN.. 등의 수들 추가
            for (int j = 0; j < i; j++) {
                num += N * Math.pow(10, j);
            }
            dp[i].add(num);

            // j번 사용하여 만들어진 수들과 i-j번 사용하여 만들어진 수들의 모든 조합에 대하여 만들 수 있는 수들을 집합에 추가
            for (int j = 1; j < i; j++) {
                for (int x : dp[j]) {
                    for (int y : dp[i - j]) {
                        dp[i].add(x + y);
                        dp[i].add(x - y);
                        dp[i].add(x * y);
                        if (y != 0) dp[i].add(x / y);
                    }
                }
            }

            // 해당 과정에서 number을 만들 수 있다면 i를 return
            if (dp[i].contains(number)) return i;
        }

        return -1;
    }

    static class Inp {
        int N;
        int number;

        Inp(int N, int number) {
            this.N = N;
            this.number = number;
        }
    }
}

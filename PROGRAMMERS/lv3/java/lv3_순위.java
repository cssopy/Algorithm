import java.util.HashSet;
import java.util.Set;

public class lv3_순위 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}),
                new Inp(6, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {2, 4}, {2, 6}})
        };

        for (Inp inp : inps) {
            result.append(solution(inp.n, inp.results)).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(int n, int[][] results) {
        // i선수를 이기는 선수들과 지는 선수들
        WL[] wls = new WL[n + 1];
        for (int i = 1; i <= n; i++) {
            wls[i] = new WL();
        }

        for (int i = 0; i < results.length; i++) {
            int[] result = results[i];

            wls[result[0]].ln.add(result[1]);
            wls[result[1]].wn.add(result[0]);
        }

        for (int i = 1; i <= n; i++) {
            WL wl = wls[i];

            // i에게 이기는 선수들은 i에게 지는 모든 선수들을 이긴다
            for (int ws : wl.wn) {
                wls[ws].ln.addAll(wl.ln);
            }
            // i에게 지는 선수들은 i에게 이기는 모든 선수들에게 진다
            for (int ls : wl.ln) {
                wls[ls].wn.addAll(wl.wn);
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            WL wl = wls[i];

            // i선수를 이기는 선수들과 지는 선수들의 합이 n-1이면 i선수는 순위를 결정할 수 있음
            ans += wl.wn.size() + wl.ln.size() == n - 1 ? 1 : 0;
        }

        return ans;
    }

    static class WL {
        Set<Integer> wn, ln;

        WL() {
            this.wn = new HashSet<>();
            this.ln = new HashSet<>();
        }
    }

    static class Inp {
        int n;
        int[][] results;

        Inp(int n, int[][] results) {
            this.n = n;
            this.results = results;
        }
    }
}

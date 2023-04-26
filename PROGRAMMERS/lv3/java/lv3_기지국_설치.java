public class lv3_기지국_설치 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp(11, new int[]{4, 11}, 1),
                new Inp(16, new int[]{9}, 2),
                new Inp(13, new int[]{3, 7, 11}, 1),
                new Inp(6, new int[]{3}, 2)
        };

        for (Inp inp : inps) {
            result.append(String.format("%d\n", solution(inp.N, inp.stations, inp.W)));
        }

        System.out.println(result);
    }

    public static int solution(int n, int[] stations, int w) {
        int ans = 0;
        for (int i = 0, ci = 1; i < stations.length; i++) {
            int station = stations[i];

            // 현재 위치가 기지국 범위 안에 들어오지 않으면
            // 현재 위치부터 기지국 왼쪽 범위 밖까지 설치해야할 기지국 개수 더함
            if (station - ci - w > 0) {
                ans += Math.ceil((station - ci - w) / (2.0 * w + 1));
            }
            // 현재 위치는 기지국 오른쪽 범위 밖으로 설정
            ci = station + w + 1;

            // 남은 기지국이 없고 현재 위치가 끝까지 도달하지 않았을 때
            // 현재 위치가 끝위치가 아니라면 현재 위치부터 끝위치까지 설치해야할 기지국 개수 더함
            // 현재 위치가 끝위치면 끝위치에 기지국 설치
            if (i == stations.length - 1 && ci <= n) {
                if (ci < n) {
                    ans += Math.ceil((n - ci) / (2.0 * w + 1));
                }
                if (ci == n) {
                    ans++;
                }
            }
        }

        return ans;
    }

    static class Inp {
        int N;
        int[] stations;
        int W;

        Inp(int N, int[] stations, int W) {
            this.N = N;
            this.stations = stations;
            this.W = W;
        }
    }
}

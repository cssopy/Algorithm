import java.util.Arrays;

public class lv2_시소_짝꿍 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][] inps = {
                {100, 180, 360, 100, 270}
        };

        for (int[] inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.println(result);
    }

    public static long solution(int[] weights) {
        Arrays.sort(weights);

        long ans = 0;
        for (int i = 0, p = 0; i < weights.length - 1; i++) {
            // 중복 처리
            // i번째가 i-1과 무게가 같다면 i의 짝꿍은 i-1의 짝꿍과 같음 (i-1은 제외)
            if (i != 0 && weights[i] == weights[i - 1]) {
                ans += --p;
                continue;
            }

            // weights[i]의 짝꿍의 수
            p = 0;
            for (int j = i + 1; j < weights.length; j++) {
                // j번째 사람이 i번째보다 2배 초과로 크다면 j번째 이후는 볼필요 없음
                if (weights[j] > weights[i] * 2) break;

                if (weights[i] == weights[j] || weights[i] * 2 == weights[j] || weights[i] * 3 == weights[j] * 2 || weights[i] * 4 == weights[j] * 3)
                    p++;
            }
            ans += p;
        }

        return ans;
    }
}
import java.util.Arrays;
import java.util.Comparator;

public class lv3_단속카메라 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][][] inps = {
                {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}
        };

        for (int[][] inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        // 마지막으로 설치한 카메라 위치
        int lcp = Integer.MIN_VALUE;
        int ans = 0;
        // 차량이 가장 최근 설치한 카메라보다 멀리서 진출한다면 그 위치에 카메라 설치
        for (int[] route : routes) {
            if (route[0] > lcp) {
                ans++;
                lcp = route[1];
            }
        }

        return ans;
    }
}

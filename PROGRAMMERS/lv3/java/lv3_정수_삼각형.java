public class lv3_정수_삼각형 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][][] inps = {
                {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}
        };

        for (int[][] inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(int[][] triangle) {
        // 제일 아래층부터 더해진 숫자 중 최대값들
        int[] t = new int[triangle.length];

        // 제일 아래층부터 접근
        for (int i = triangle.length - 1; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                // 제일 아래층 값들은 그대로 초기화 되도록 처리
                if (j == triangle.length - 1) {
                    t[j] = triangle[i][j];
                    continue;
                }
                // 제일 아래층이 아닌 i층들은 i-1층까지 더해진 값들 중 i층의 값과 더해질 경우 더 큰 경우를 선택
                t[j] = Math.max(t[j] + triangle[i][j], t[j + 1] + triangle[i][j]);
            }
        }

        return t[0];
    }
}

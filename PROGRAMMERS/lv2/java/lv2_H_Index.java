import java.util.Arrays;

public class lv2_H_Index {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][] inps = {
                {3, 0, 6, 1, 5},
                {0, 1, 3, 5, 6, 6, 6, 7, 8, 9},
                {9, 9, 9, 9},
                {100, 100, 100}
        };

        for (int[] inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.print(result);
    }

    public static int solution(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            // 피인용수가 논문수보다 작아지는 지점
            if (i >= citations[citations.length - i - 1]) {
                return i;
            }
        }
        // 만약 for문을 다 돌았다면 모든 논문들의 피인용수가 전체 논문수보다 크다
        // 그래서 과학자의 h-index는 논문의 개수가 된다
        return citations.length;
    }
}

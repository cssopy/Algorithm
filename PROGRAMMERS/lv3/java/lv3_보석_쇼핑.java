import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class lv3_보석_쇼핑 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[][] inps = {
                {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"},
                {"AA", "AB", "AC", "AA", "AC"},
                {"XYZ", "XYZ", "XYZ"},
                {"ZZZ", "YYY", "NNNN", "YYY", "BBB"},
                {"DIA", "EM", "EM", "RUB", "DIA"}
        };

        for (String[] inp : inps) {
            int[] ans = solution(inp);
            result.append(String.format("%d %d\n", ans[0], ans[1]));
        }

        System.out.println(result);
    }

    public static int[] solution(String[] gems) {
        // 해당 보석이 마지막에 등장한 위치
        Map<String, Integer> gemLastIndex = new HashMap<>();
        Map<String, Integer> gemIndex = new HashMap<>();
        // 모든 보석의 종류 개수
        int kindNum = new HashSet<>(Arrays.asList(gems)).size();

        int[] answer = {1, gems.length};
        // 종료위치를 한칸씩 늘리고 시작위치를 최대한 좁히며 모든 보석을 포함하는 구간을 찾음
        for (int start = 0, end = 0, minL = answer[1]; end < gems.length; end++) {
            gemLastIndex.put(gems[end], end);

            // start의 범위를 최대한 좁힘
            while (start != gemLastIndex.get(gems[start])) start++;

            // 모든 보석을 포함하고 더 짧은 구간을 찾았을때, 해당 구간과 구간의 길이를 저장
            if (gemLastIndex.size() == kindNum && end - start < minL) {
                minL = end - start;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }

        return answer;
    }
}

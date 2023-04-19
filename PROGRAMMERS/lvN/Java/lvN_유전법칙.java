import java.util.Stack;

public class lvN_유전법칙 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][][] inps = {
                {{3, 5}},
                {{3, 8}, {2, 2}},
                {{3, 1}, {2, 3}, {3, 9}},
                {{4, 26}}
        };

        for (int[][] inp : inps) {
            String[] rs = solution(inp);
            for (String r : rs) {
                result.append(String.format("%s ", r));
            }
            result.append('\n');
        }

        System.out.println(result);
    }

    public static String[] solution(int[][] queries) {
        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            ans[i] = findCharacteristics(query);
        }

        return ans;
    }

    static String findCharacteristics(int[] query) {
        // 2세대까지 각 조상들이 몇번째인지 조사
        int[] ancestors = getAncestors(query);
        int top = ancestors.length - 1;
        // 조상이 RR 또는 rr이면 자손은 모든 RR 또는 rr만 가능
        while (top != -1) {
            int n = ancestors[top--];

            if (n == 1) return "RR";
            if (n == 0) return "rr";
        }
        // 그 외 모든 경우는 Rr
        return "Rr";
    }

    static int[] getAncestors(int[] query) {
        // 조상들이 각각 몇번째인지 저장할 스택배열
        int top = -1;
        int[] ancestors = new int[query[0] - 1];
        // 현재세대부터 2세대까지 접근
        for (int i = query[0], a = query[1]; i >= 2; i--) {
            ancestors[++top] = a % 4;
            a = (int) Math.ceil(a / 4.0);
        }

        return ancestors;
    }
}

import java.util.ArrayList;
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
        int[] ancestors = getAncestors(query);
        for (int i = 1; i < ancestors.length; i++) {
            if (ancestors[i] == 1) return "RR";
            if (ancestors[i] == 0) return "rr";
        }
        return "Rr";
    }

    static int[] getAncestors(int[] query) {
        ArrayList<Integer> ancestors = new ArrayList<>();
        for (int i = query[0], a = query[1]; i >= 1; i--) {
            ancestors.add(a);
            a = (int) Math.ceil(a / 4.0);
        }

        return ancestors.stream().sorted().mapToInt(i -> i % 4).toArray();
    }

    public static String[] solution2(int[][] queries) {
        String[] ans = new String[queries.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = getGene(queries[i]);
        }

        return ans;
    }

    static String getGene(int[] query) {
        Stack<Integer> stack = new Stack<>();

        // 부모의
        query[1]--;
        while (query[0] > 1) {
            stack.push(query[1] % 4);
            query[0]--;
            query[1] = query[1] / 4;
        }

        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (num == 0) return "RR";
            if (num == 3) return "rr";
        }

        return "Rr";
    }
}

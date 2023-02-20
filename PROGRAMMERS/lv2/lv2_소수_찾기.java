import java.util.HashSet;
import java.util.Set;

public class lv2_소수_찾기 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[] inps = {"5", "17", "011"};

        for (String inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(String numbers) {
        // 문자열 => 문자 배열
        char[] ns = numbers.toCharArray();

        // 소수인 숫자 집합 ( 중복 제거 )
        HashSet<Integer> set = new HashSet<>();
        // 문자 배열에서 1개부터 문자수만큼 선택
        for (int i = 1; i <= ns.length; i++) {
            per(ns, new boolean[ns.length], 0, i, "", set);
        }

        return set.size();
    }

    public static void per(char[] ns, boolean[] isSel, int depth, int r, String s, Set<Integer> set) {
        // r개만큼 선택했다면
        if (depth == r) {
            if (s == "") {
                return;
            }

            // 숫자로 바꿔 소수면 집합에 추가
            int n = Integer.parseInt(s);
            if (isPN(n)) {
                set.add(n);
            }
            return;
        }

        for (int j = 0; j < ns.length; j++) {
            if (!isSel[j]) {
                isSel[j] = true;
                per(ns, isSel, depth + 1, r, s + ns[j], set);
                isSel[j] = false;
            }
        }
    }

    public static boolean isPN(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

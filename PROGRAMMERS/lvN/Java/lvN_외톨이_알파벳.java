import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class lvN_외톨이_알파벳 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[] inps = {
                "edeaaabbccd",
                "eeddee",
                "string",
                "zbzbz"
        };

        for (String inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.println(result);
    }

    public static String solution(String input_string) {
//        // 2회이상 연속으로 반복되는 알파벳 1회로 줄임
//        input_string = input_string.replaceAll("(.)\\1+", "$1");
//
//        // 등장하는 모든 알파벳 집합
//        Set<Character> set = new HashSet<>();
//        // 2번 이상 등장하는 알파벳 집합
//        // TreeSet을 사용함으로 집합이지만 정렬
//        Set<Character> result = new TreeSet<>();
//        for (int i = 0; i < input_string.length(); i++) {
//            char c = input_string.charAt(i);
//
//            if (set.contains(c)) {
//                result.add(c);
//            } else {
//                set.add(c);
//            }
//        }
//
//        // 2번 이상 나타난 알파벳들 ans에 추가
//        StringBuilder ans = new StringBuilder();
//        for (Character c : result) {
//            ans.append(c);
//        }
//
//        return ans.length() == 0 ? "N" : ans.toString();

        Set<Character> set = new HashSet<>();
        Set<Character> result = new TreeSet<>();

        char pc = '.';
        for (int i = 0; i < input_string.length(); i++) {
            char c = input_string.charAt(i);

            if (pc != c) {
                pc = c;

                if (set.contains(c)) {
                    result.add(c);
                    continue;
                }
                set.add(c);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (Character c : result) {
            ans.append(c);
        }

        return ans.length() == 0 ? "N" : ans.toString();
    }
}

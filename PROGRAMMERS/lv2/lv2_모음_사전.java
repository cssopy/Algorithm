import java.util.HashMap;
import java.util.Map;

public class lv2_모음_사전 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[] inps = {"AAAAE", "AAAE", "I", "EIO"};

        for (String inp : inps) {
            result.append(solution2(inp)).append('\n');
        }

        System.out.print(result);
    }

    public static int solution(String word) {
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};

        // 찾는 단어의 순서와 해당 단어를 찾았는지에 대한 배열
        Object[] ans = {0, false};
        for (int i = 0; i < vowels.length; i++) {
            findWord(vowels, word, "" + vowels[i], 0, ans);
        }

        return (int) ans[0];
    }

    // DFS
    public static void findWord(char[] vowels, String word, String s, int depth, Object[] ans) {
        // 5자 넘거나 이미 찾았으면 return
        if (depth == 5 || (boolean) ans[1]) {
            return;
        }

        // 순서 1씩 카운트
        ans[0] = (int) ans[0] + 1;

        // 단어를 찾았으면 찾으면 return
        if (s.equals(word)) {
            ans[1] = true;
            return;
        }

        for (int i = 0; i < vowels.length; i++) {
            findWord(vowels, word, s + vowels[i], depth + 1, ans);
        }
    }

    public static int solution2(String word) {
        // 사전에서의 단어 최대 길이
        int length = 5;
        // 단어 길이별 사전에서 단어의 총 개수
        int[] twc = new int[length + 1];
        for (int i = 1, j = 5; i <= 5; i++, j *= 5) {
            twc[i] = twc[i - 1] + j;
        }

        // 순서대로 인덱스 부여
        Map<Character, Integer> map = new HashMap<>() {{
            put('A', 0);
            put('E', 1);
            put('I', 2);
            put('O', 3);
            put('U', 4);
        }};

        // 찾는 단어의 순서
        int ans = 0;
        // 사전 작업
        twc[length]++;
        for (char c : word.toCharArray()) {
            twc[length]--;
            twc[length] /= 5;
            ans += map.get(c) * twc[length] + 1;
        }

        return ans;
    }
}

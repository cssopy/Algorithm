public class lv3_단어_변환 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[][] bt = {
                {"hit", "cog"},
                {"hit", "cog"}
        };
        String[][] wordss = {
                {"hot", "dot", "dog", "lot", "log", "cog"},
                {"hot", "dot", "dog", "lot", "log"}
        };

        for (int i = 0; i < bt.length; i++) {
            result.append(solution(bt[i][0], bt[i][1], wordss[i])).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(String begin, String target, String[] words) {
        // target이 words안에 있는지 체크
        if (!isInWords(target, words)) return 0;

        int[] ans = {Integer.MAX_VALUE};
        DFS(begin, target, words, new boolean[words.length], 0, ans);

        return ans[0];
    }

    static void DFS(String cw, String target, String[] words, boolean[] isVisited, int depth, int[] ans) {
        // 현재 단어가 내가 찾던 단어면 변환횟수 초기화 후 return
        if (cw.equals(target)) {
            ans[0] = depth;
            return;
        }

        // 현재 변환횟수가 이미 ans[0] 에 저장된 값보다 이상이면 더 진행할 이유 X
        if (depth >= ans[0]) return;

        for (int i = 0; i < words.length; i++) {
            // 변환했던 단어가 아니고 현재 단어에서 변환할 수 있는 단어인지
            if (!isVisited[i] && isChangeable(cw, words[i])) {
                isVisited[i] = true;
                DFS(words[i], target, words, isVisited, depth + 1, ans);
                isVisited[i] = false;
            }
        }
    }

    static boolean isInWords(String target, String[] words) {
        for (String word : words) {
            if (word.equals(target)) return true;
        }

        return false;
    }

    static boolean isChangeable(String before, String after) {
        int dn = 0;
        for (int i = 0; i < before.length(); i++) {
            if (before.charAt(i) != after.charAt(i)) dn++;
        }

        return dn <= 1 ? true : false;
    }
}

public class lv2_큰_수_만들기 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[] numbers = {
                "1924",
                "1231234",
                "4177252841"
        };
        int[] ks = {
                2,
                3,
                4
        };

        for (int i = 0; i < numbers.length; i++) {
            result.append(solution(numbers[i], ks[i])).append('\n');
        }

        System.out.println(result);
    }

    public static String solution(String number, int k) {
        char[] ns = number.toCharArray();

        StringBuilder ans = new StringBuilder();
        for (int ci = 0, mv = 0, mi = 0, kk = k; // ci:현재인덱스, mv:최대값, mi:최대값의인덱스, kk:제거해야하는개수
             ans.length() != number.length() - k; // k개의 수를 제거했으면 종료
             kk -= mi - ci, ci = mi + 1, mv = 0, mi = ci) {
            // 최대값 찾기
            for (int i = ci; i <= ci + kk; i++) {
                if (ns[i] - '0' > mv) {
                    mv = ns[i] - '0';
                    mi = i;
                }

                if (mv == 9) break;
            }

            // 최대값 추가
            ans.append(ns[mi]);
        }

        return ans.toString();
    }

    public static String solution2(String number, int k) {
        char[] ns = number.toCharArray();

        int top = -1;
        char[] stack = new char[1_000_000];

        for (int i = 0, kk=k; i < number.length(); i++) {
            char c = number.charAt(i);
            while (top != -1 && stack[top] < c && kk-- > 0) top--;
            stack[++top] = c;
        }

        char[] ans = new char[number.length() - k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack[i];
        }

        return new String(ans);
    }
}

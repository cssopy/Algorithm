public class lv2_124_나라의_숫자 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[] inps = {1, 2, 3, 4, 13, 14, 15};

        for (int inp : inps) {
            result.append(String.format("%s\n", solution(inp)));
        }

        System.out.println(result);
    }

    public static String solution(int n) {
        StringBuilder ans = new StringBuilder();
        n = n - 1;
        while (n >= 0) {
            if (n % 3 == 2) ans.append(4);
            else ans.append(n % 3 + 1);

            n = n / 3 - 1;
        }

        return ans.reverse().toString();
    }
}

public class lv0_분수의_덧셈 {
    public static void main(String[] args) {
        int[][] inps = { { 1, 2, 3, 4 }, { 9, 2, 1, 3 } };
        for (int i = 0; i < inps.length; i++) {
            int[] ans = solution(inps[i][0], inps[i][1], inps[i][2], inps[i][3]);

            for (int j = 0; j < ans.length; j++) {
                System.out.print(ans[j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int a = numer1 * denom2 + numer2 * denom1;
        int b = denom1 * denom2;

        int gcd = GCD(a, b);
        int[] answer = { a / gcd, b / gcd };
        return answer;
    }

    public static int GCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return GCD(num2, num1 % num2);
    }
}

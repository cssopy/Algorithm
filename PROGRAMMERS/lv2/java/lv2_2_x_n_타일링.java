public class lv2_2_x_n_타일링 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[] inps = {
                4
        };

        for (int inp : inps) {
            result.append(String.format("%d\n", solution(inp)));
        }

        System.out.println(result);
    }

    public static int solution(int n) {
        int[] fibo = new int[n + 1];
        fibo[1] = 1;
        fibo[2] = 2;

        if (n <= 2) return fibo[n];

        for (int i = 3; i <= n; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1_000_000_007;
        }

        return fibo[n];
    }
}

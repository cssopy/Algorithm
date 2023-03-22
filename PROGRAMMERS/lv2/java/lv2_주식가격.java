public class lv2_주식가격 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][] inps = {
                {1, 2, 3, 2, 1},
                {5, 4, 3, 2, 5}
        };

        for (int[] inp : inps) {
            for (int v : solution(inp)) {
                result.append(v).append(' ');
            }
            result.append('\n');
        }

        System.out.print(result);
    }

    public static int[] solution(int[] prices) {
        // 스택
        int top = 0;
        int[] stack = new int[100_000];
        // 첫번째 주식 스택에 push
        stack[0] = 0;

        int[] ans = new int[prices.length];
        for (int i = 1; i < prices.length; ) {
            // 스택이 비어있지 않고 스택의 최상단 값이 현재 값보다 값이 크다면 (=값의 하락이 있다면)
            if (top != -1 && prices[i] < prices[stack[top]]) {
                // 스택의 최상단 값을 꺼내어 현재 인덱스에서 해당 값의 인덱스를 뺌 (=해당 값이 떨어지기까지 버틴 시간)
                int idx = stack[top--];
                ans[idx] = i - idx;
                // 그다음 스택의 최상단 값도 현재 값보다 클수 있으므로 continue로 반복
                continue;
            }

            // 위에 해당하지 않다면 현재 값을 스택에 push
            stack[++top] = i++;
        }

        // 아직까지도 스택에 남은 값들은 끝까지 가격이 떨어지지 않은 것
        while (top != -1) {
            int idx = stack[top--];
            ans[idx] = prices.length - 1 - idx;
        }

        return ans;
    }
}

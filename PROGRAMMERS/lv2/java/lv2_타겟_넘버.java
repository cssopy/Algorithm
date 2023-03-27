public class lv2_타겟_넘버 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        INP[] inps = {
                new INP(new int[]{1, 1, 1, 1, 1}, 3),
                new INP(new int[]{4, 1, 2, 1}, 4)
        };

        for (INP inp : inps) {
            result.append(solution(inp.numbers, inp.target)).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(int[] numbers, int target) {
        // 타켓 넘버를 만드는 방법의 수
        int[] ans = {0};
        DFS(numbers, target, 0, 0, ans);

        return ans[0];
    }

    static void DFS(int[] numbers, int target, int depth, int sum, int[] ans) {
        if (depth == numbers.length) {
            if (sum == target) ans[0]++;
            return;
        }

        // 더하기와 빼기, 두가지의 경우로 분기
        DFS(numbers, target, depth + 1, sum + numbers[depth], ans);
        DFS(numbers, target, depth + 1, sum - numbers[depth], ans);
    }

    static class INP {
        int[] numbers;
        int target;

        INP(int[] numbers, int target) {
            this.numbers = numbers;
            this.target = target;
        }
    }
}

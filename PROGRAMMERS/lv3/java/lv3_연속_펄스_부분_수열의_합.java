public class lv3_연속_펄스_부분_수열의_합 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][] inps = {
                {2, 3, -6, 1, 3, -1, 2, 4}
        };

        for (int[] inp : inps) {
            result.append(String.format("%d\n", solution(inp)));
        }

        System.out.println(result);
    }

    public static long solution(int[] sequence) {
        // 펄스 수열 적용
        for (int i = 0, j = 1; i < sequence.length; i++) {
            sequence[i] *= j;
            j *= -1;
        }

        // 구간합
        long[] sum = new long[sequence.length + 1];

        // 구간합 최대, 최소
        long max = sequence[0], min = sequence[0];
        for (int i = 0; i < sequence.length; i++) {
            sum[i + 1] = sum[i] + sequence[i];

            max = Math.max(max, sum[i + 1]);
            min = Math.min(min, sum[i + 1]);
        }

        // 펄스, 역펄스, 구간, 전체영역에 대해 최대를 반환
        return Math.max(Math.max(max - min, max), Math.abs(min));
    }
}

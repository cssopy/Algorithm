import java.util.Arrays;

public class lv2_가장_큰_수 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][] inps = {
                {6, 10, 2},
                {3, 30, 34, 5, 9},
                {1, 10, 19, 2, 20, 29, 3, 30, 39, 4, 40, 49},
                {1, 10, 100, 1000, 818, 81, 898, 89, 0, 0}
        };

        for (int[] inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.println(result);
    }

    public static String solution(int[] numbers) {
        // sort 함수 사용을 위해
        String[] ns = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            ns[i] = String.valueOf(numbers[i]);
        }

        // 두 숫자중 어떤 숫자가 앞에 올경우 더 큰 수를 만들 수 있는지 판단하여 정렬
        Arrays.sort(ns, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 정렬된 숫자 합치기
        StringBuilder ans = new StringBuilder();
        for (String n : ns) {
            ans.append(n);
        }

        // "0000" 이런거 처리
        return ans.toString().charAt(0) == '0' ? "0" : ans.toString();
    }
}

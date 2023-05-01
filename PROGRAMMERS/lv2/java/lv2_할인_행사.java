import java.util.HashMap;
import java.util.Map;

public class lv2_할인_행사 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}),
                new Inp(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"})
        };

        for (Inp inp : inps) {
            result.append(String.format("%d\n", solution(inp.want, inp.number, inp.discount)));
        }

        System.out.println(result);
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for (int i = 0; i < discount.length - 10 + 1; i++) {
            // i번째부터 i+10번째까지 할인되는 각각 과일들의 개수
            Map<String, Integer> map = new HashMap<>();

            // i번째부터 i+10번째까지 할인되는 각각 과일들의 개수 카운트
            for (int j = i; j < i + 10 && j < discount.length; j++) {
                map.put(discount[j], map.get(discount[j]) == null ? 1 : map.get(discount[j]) + 1);
            }

            // 정현이가 원하는 품목들을 모두 만족하는지 여부
            boolean f = true;
            for (int j = 0; j < want.length; j++) {
                // map에 정현이가 원하는 품목이 없거나 모자라면 만족 X
                if (map.get(want[j]) == null || map.get(want[j]) < number[j]) {
                    f = false;
                    break;
                }
            }

            if (f) answer++;
        }

        return answer;
    }

    static class Inp {
        String[] want;
        int[] number;
        String[] discount;

        Inp(String[] want, int[] number, String[] discount) {
            this.want = want;
            this.number = number;
            this.discount = discount;
        }
    }
}

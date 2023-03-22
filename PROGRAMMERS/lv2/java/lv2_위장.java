import java.util.HashMap;

public class lv2_위장 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[][][] inps = {
                {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}},
                {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}},
        };

        for (String[][] inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.print(result);
    }

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        // 옷 종류마다 개수 카운트
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.get(cloth[1]) == null ? 1 : map.get(cloth[1]) + 1);
        }

        int ans = 1;
        // 나올 수 있는 의상 착용 가지수 계산
        for (String k : map.keySet()) {
            ans *= map.get(k) + 1;
        }

        // 모든 옷을 안 입는 경우는 제외
        return ans - 1;
    }
}

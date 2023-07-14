import java.util.*;

public class BJ_20291 {
    public static void main(String[] args) {
        int N;
        Map<String, Integer> map = new HashMap<>();
        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
            // 확장자 카운트
            for (int i = 0; i < N; i++) {
                String et = sc.next().split("[.]")[1];
                map.put(et, map.getOrDefault(et, 0) + 1);
            }
        }

        // 확장자 사전순 정렬
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key).append(' ').append(map.get(key)).append('\n');
        }

        System.out.print(sb);
    }
}

import java.util.*;

public class BJ_5766 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                int N = sc.nextInt();
                int M = sc.nextInt();

                // 종료 조건
                if (N == 0 && M == 0) break;

                // 각 숫자를 세기 위한 map
                Map<Integer, Integer> numCount = new HashMap<>();
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        int n = sc.nextInt();
                        numCount.put(n, numCount.getOrDefault(n, 1) + 1);
                    }
                }

                // 모든 숫자를 리스트에 넣고 개수로 내림차순 및 숫자 크기순 정렬
                List<Integer> ary = new ArrayList<>(numCount.keySet());
                Collections.sort(ary, (a, b) -> numCount.get(a) == numCount.get(b) ? a - b : numCount.get(b).compareTo(numCount.get(a)));
                int second = numCount.get(ary.get(1));

                // 두 번째로 많은 숫자들 출력
                for (int i = 1; i < ary.size(); i++) {
                    if (second == numCount.get(ary.get(i))) {
                        sb.append(ary.get(i)).append(" ");
                    }
                }
                sb.append('\n');
            }

            System.out.print(sb);
        }
    }
}

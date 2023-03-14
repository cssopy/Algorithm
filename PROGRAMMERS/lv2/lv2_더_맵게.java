import java.util.Comparator;
import java.util.PriorityQueue;

public class lv2_더_맵게 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][] scoviles = {
                {1, 2, 3, 9, 10, 12}
        };
        int[] KS = {
                7
        };

        for (int i = 0; i < scoviles.length; i++) {
            result.append(solution(scoviles[i], KS[i])).append('\n');
        }

        System.out.print(result);
    }

    public static int solution(int[] scoville, int K) {
        // 오름차순 우선순위큐에 모든 음식의 스코빌지수 추가
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int scv : scoville) {
            pq.add(scv);
        }

        // 섞는 횟수
        int ans = 0;
        while (pq.peek() < K) {
            // 만들 수 없는 경우
            if (pq.size() < 2) return -1;

            // 스코빌 지수가 가장 낮은 두 음식 섞고 우선순위큐에 삽입
            pq.add(pq.poll() + pq.poll() * 2);
            ans++;
        }

        return ans;
    }
}

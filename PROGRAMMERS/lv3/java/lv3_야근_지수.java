import java.util.PriorityQueue;

public class lv3_야근_지수 {
    public long solution(int n, int[] works) {
        // 모든 작업을 저장할 배열, 큰 작업부터 내림차순으로 졍렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        // 모든 작업의 작업량 합
        int total = 0;
        for (int work : works) {
            pq.offer(work);
            total += work;
        }

        // 모든 작업의 작업량보다 n이 같거나 크다면 남은 작업이 없으므로 0 반환
        if (total <= n) return 0;

        // 작업량이 제일 큰 작업을 하나 꺼내어 1만큼의 작업 후 다시 우선순위큐에 삽입
        while (n > 0) {
            int num = pq.poll();
            num--;
            pq.offer(num);
            n--;
        }

        long answer = 0;
        while (!pq.isEmpty()) answer += Math.pow(pq.poll(), 2);

        return answer;
    }
}

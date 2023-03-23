import java.util.Comparator;
import java.util.PriorityQueue;

public class lv3_이중우선순위큐 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[][] inps = {
                {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"},
                {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}
        };

        for (String[] inp : inps) {
            int[] rp = solution(inp);
            for (int v : rp) {
                result.append(v).append(' ');
            }
            result.append('\n');
        }

        System.out.println(result);
    }

    public static int[] solution(String[] operations) {
        // 두개의 우선순위큐를 합쳐 양방향 이중우선순위큐를 표현
        PriorityQueue<Integer> q = new PriorityQueue<>();
        PriorityQueue<Integer> rq = new PriorityQueue<>(Comparator.reverseOrder());

        for (String op : operations) {
            // 삽입
            if (op.charAt(0) == 'I') {
                String[] sop = op.split(" ");
                if (sop[0].equals("I")) {
                    q.add(Integer.parseInt(sop[1]));
                    rq.add(Integer.parseInt(sop[1]));
                }
                continue;
            }

            // 큐가 비어있으면 삭제 연산 무시
            if (q.isEmpty()) continue;

            // 최댓값 삭제
            if (op.equals("D 1")) {
                if (!q.isEmpty()) q.remove(rq.peek());
                if (!rq.isEmpty()) rq.poll();
            }

            // 최솟값 삭제
            if (op.equals("D -1")) {
                if (!rq.isEmpty()) rq.remove(q.peek());
                if (!q.isEmpty()) q.poll();
            }
        }

        int[] ans = {0, 0};
        // 큐가 비어있지 않으면 최댓값, 최솟값 초기화
        if (!q.isEmpty()) {
            ans[0] = rq.peek();
            ans[1] = q.peek();
        }

        return ans;
    }
}

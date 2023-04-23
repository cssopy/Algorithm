import java.util.Comparator;
import java.util.PriorityQueue;

public class lvN_신입사원_교육 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp(new int[]{10, 3, 7, 2}, 2),
                new Inp(new int[]{1, 2, 3, 4}, 3),
        };

        for (Inp inp : inps) {
            result.append(String.format("%d\n", solution(inp.ability, inp.number)));
        }

        System.out.println(result);
    }

    public static int solution(int[] ability, int number) {
        // 오름차순 우선순위 큐
        PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int a : ability) que.add(a);

        // number 횟수만큼 능력치가 제일 낮은 두명을 뽑아 합쳐서 큐에 넣음
        for (int i = 0; i < number; i++) {
            int n1 = que.poll();
            int n2 = que.poll();

            que.add(n1 + n2);
            que.add(n1 + n2);
        }

        // 모든 사원의 능력치의 합
        int ans = 0;
        while (!que.isEmpty()) ans += que.poll();

        return ans;
    }

    static class Inp {
        int[] ability;
        int number;

        Inp(int[] ability, int number) {
            this.ability = ability;
            this.number = number;
        }
    }
}

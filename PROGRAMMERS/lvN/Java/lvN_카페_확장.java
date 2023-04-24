import java.util.LinkedList;
import java.util.Queue;

public class lvN_카페_확장 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp(new int[]{5, 12, 30}, new int[]{1, 2, 0, 1}, 10),
                new Inp(new int[]{5, 12, 30}, new int[]{2, 1, 0, 0, 0, 1, 0}, 10),
                new Inp(new int[]{5}, new int[]{0, 0, 0, 0, 0}, 5)
        };

        for (Inp inp : inps) {
            result.append(String.format("%d\n", solution(inp.menu, inp.order, inp.k)));
        }

        System.out.println(result);
    }

    public static int solution(int[] menu, int[] order, int k) {
        // 주문 대기 큐
        Queue<Integer> que = new LinkedList<>();
        // 현재 제조하는 음료가 끝나는 시간
        int cOrder = 0;
        // 최대 대기자 수
        int ans = 0;
        // 현재 제조하는 음료가 없고 모든 손님의 주문을 받았고 대기중인 주문이 없을경우 종료
        for (int time = 0, orderIdx = 0; !(time >= cOrder && orderIdx >= order.length && que.isEmpty()); time++) {
            // k초마다 손님들의 주문을 받음
            if (time % k == 0 && orderIdx < order.length) que.add(order[orderIdx++]);

            // 대기중인 주문이 있고 현재 제조하는 음료가 없다면 대기중인 음료를 하나 꺼내어 음료 제조
            if (!que.isEmpty() && cOrder <= time) {
                cOrder = time + menu[que.poll()];
            }

            // 대기 인원 최대치로 갱신 (현재 주문 대기자 포함)
            ans = Math.max(ans, que.size() + 1);
        }

        return ans;
    }

    static class Inp {
        int[] menu, order;
        int k;

        Inp(int[] menu, int[] order, int k) {
            this.menu = menu;
            this.order = order;
            this.k = k;
        }
    }
}

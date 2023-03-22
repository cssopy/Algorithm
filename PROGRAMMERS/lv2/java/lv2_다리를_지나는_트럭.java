import java.util.LinkedList;

public class lv2_다리를_지나는_트럭 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][] blw = {
                {2, 10},
                {100, 100},
                {100, 100}
        };
        int[][] tw = {
                {7, 4, 5, 6},
                {10},
                {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}
        };

        for (int i = 0; i < blw.length; i++) {
            result.append(solution(blw[i][0], blw[i][1], tw[i])).append('\n');
        }

        System.out.print(result);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        // 현재 다리에 있는 트럭의 총 무게와 수
        int cw = 0, cl = 0;
        LinkedList<Integer> que = new LinkedList<>();
        for(int i=0; i<bridge_length; i++){
            que.add(0);
        }

        // 모든 트럭이 지나는데 걸린 시간
        int ans = 0;
        for (int i = 0; i < truck_weights.length; ) {
            int c = que.poll();
            // 차량이 다리 끝에 도달하면
            if(c != 0){
                cw -= c;
                cl--;
            }
            ans++;

            // 차량이 끝에 도달하여 나가는 것과 동시에 들어올 수도 있기에 처리
            if(cw + truck_weights[i] <= weight && cl + 1 <= bridge_length){
                que.add(truck_weights[i]);
                cw += truck_weights[i++];
                cl++;
                continue;
            }

            que.add(0);
        }

        // 마지막 트럭 처리
        while (!que.isEmpty()){
            que.poll();
            ans++;
        }

        return ans;
    }
}

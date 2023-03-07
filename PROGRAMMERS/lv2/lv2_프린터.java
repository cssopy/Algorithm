import java.util.LinkedList;
import java.util.Queue;

public class lv2_프린터 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][] prioritiess = {
                {2, 1, 3, 2},
                {1, 1, 9, 1, 1, 1}
        };
        int[] locations = {
                2, 0
        };

        for (int i = 0; i < prioritiess.length; i++) {
            result.append(solution(prioritiess[i], locations[i])).append('\n');
        }

        System.out.print(result);
    }

    public static int solution(int[] priorities, int location) {
        // 작업 대기목록
        Queue<Task> ts = new LinkedList<>();
        // 중요도 개수
        int[] ps = new int[10];
        for (int i = 0; i < priorities.length; i++) {
            ts.add(new Task(priorities[i], i));
            ps[priorities[i]]++;
        }

        // 대기목록에서 나오는 순서
        int ans = 0;
        for (int i = 9; i > 0; ) {
            // 해당 중요도의 문서가 없으면 넘김
            if (ps[i] == 0) {
                i--;
                continue;
            }

            // 맨앞 문서
            Task cp = ts.poll();

            // 해당 중요도의 문서이면
            if(cp.p == i){
                // 해당 중요도의 문서개수 감소
                ps[i]--;
                ans++;

                // 찾는 문서면 for 반복문 종료
                if(cp.i == location){
                    break;
                }
                continue;
            }

            ts.add(cp);
        }

        return ans;
    }

    public static class Task {
        int p, i;

        Task(int p, int i) {
            this.p = p;
            this.i = i;
        }
    }
}

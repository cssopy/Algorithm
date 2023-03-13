import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class lv3_디스크_컨트롤러 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][][] inps = {
                {{0, 3}, {1, 9}, {2, 6}, {20, 1}}
        };

        for (int[][] inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.print(result);
    }

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        // 대기 작업
        PriorityQueue<int[]> readyQue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // 모든 작업이 수행될때까지 각 작업마다 요청부터 종료까지의 시간합
        int ans = 0;
        // 모든 작업이 수행되어야 종료
        // ct:현재시점, dj:완료된 작업의 수
        for (int i = 0, ct = 0, dj = 0; dj < jobs.length; ) {
            // 현재시점에서 요청될 수 있는 모든 작업은 대기큐에 넣음
            while (i < jobs.length && jobs[i][0] <= ct) {
                readyQue.add(jobs[i++]);
            }

            // 대기큐에 작업이 없다면 결국 다음으로 가장 빨리 요청될 작업까지 기다려야함
            if (readyQue.isEmpty()) {
                ct = jobs[i][0];
                continue;
            }

            // 대기하는 작업에서 수행시간이 가장 짧은 작업부터 수행
            int[] cj = readyQue.poll();
            ans += cj[1] + ct - cj[0];
            ct += cj[1];
            dj++;
        }

        return ans / jobs.length;
    }
}

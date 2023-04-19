import java.util.Comparator;
import java.util.PriorityQueue;

public class lvN_운영체제 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][][] inps = {
                {{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}},
                {{3, 6, 4}, {4, 2, 5}, {1, 0, 5}, {5, 0, 5}}
        };

        for (int[][] inp : inps) {
            long[] rs = solution(inp);
            for (long r : rs) {
                result.append(String.format("%d ", r));
            }
            result.append('\n');
        }

        System.out.println(result);
    }

    public static long[] solution(int[][] program) {
        PriorityQueue<int[]> programs = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // 대기큐의 프로그램들은 우선순위에 의해 정렬되고 우선순위가 같다면 대기큐에 들어온 순서대로 정렬
        PriorityQueue<int[]> readyQue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[3] - b[3] : a[0] - b[0]);

        for (int[] p : program) {
            programs.add(p);
        }

        long[] ans = new long[11];
        // 현재 실행중인 프로그램의 정보
        int[] cProgram = {0, 0, 0};
        for (int cTime = 0, i = 0; ; cTime++) {
            // 현재시각에 실행이 가능한 프로그램들 모두 대기큐에 추가
            while (!programs.isEmpty() && programs.peek()[1] <= cTime) {
                int[] pp = programs.poll();

                int[] p = new int[4];
                for (int j = 0; j < 3; j++) {
                    p[j] = pp[j];
                }
                p[3] = i++;

                readyQue.add(p);
            }

            // 대기하는 프로그램이 있고 현재 돌아가는 프로그램이 없다면 대기하는 프로그램을 실행
            if (!readyQue.isEmpty() && cTime >= cProgram[2]) {
                cProgram = readyQue.poll();
                cProgram[2] = cTime + cProgram[2];

                ans[cProgram[0]] += cTime - cProgram[1];
            }

            // 남은 프로그램과 대기하는 프로그램이 없고 실행중이던 프로그램이 종료되면 break
            if (programs.isEmpty() && readyQue.isEmpty() && cTime >= cProgram[2]) {
                ans[0] = cTime;
                break;
            }
        }

        return ans;
    }
}

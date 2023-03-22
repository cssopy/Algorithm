import java.util.LinkedList;

public class lv2_기능개발 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][][] inps = {
                {{93, 30, 55}, {1, 30, 5}},
                {{95, 90, 99, 99, 80, 99}, {1, 1, 1, 1, 1, 1}},
                {{95, 95, 90, 99, 99, 80, 99}, {1, 1, 1, 1, 1, 1, 1}},
                {{95, 94}, {3, 3}},
                {{99, 99, 99, 90, 90, 90}, {1, 1, 1, 1, 1, 1}},
                {{70}, {20}},
                {{20, 20}, {30, 5}},
        };

        for (int[][] inp : inps) {
            int[] ans = solution(inp[0], inp[1]);
            for (int a : ans) {
                result.append(a).append(' ');
            }
            result.append('\n');
        }

        System.out.print(result);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        // 각 작업이 배포되는 날짜 (앞 작업 고려)
        for (int i = 0; i < progresses.length; i++) {
            int cd = (int) Math.ceil(((double) 100 - progresses[i]) / speeds[i]);
            progresses[i] = i == 0 ? cd : cd > progresses[i - 1] ? cd : progresses[i - 1];
        }

        // 각 배포마다 배포되는 작업의 수
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = 0, c = 1; i < progresses.length; i++) {
            if (i == progresses.length - 1) {
                ans.add(c);
                continue;
            }

            if (progresses[i] != progresses[i + 1]) {
                ans.add(c);
                c = 1;
                continue;
            }

            c++;
        }

        return ans.stream().mapToInt(v -> v).toArray();
    }
}

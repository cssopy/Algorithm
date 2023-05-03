import java.util.*;

public class lv2_과제_진행하기 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[][][] inps = {
                {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}},
                {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}},
                {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}}
        };

        for (String[][] inp : inps) {
            String[] ans = solution(inp);
            for (String v : ans) {
                result.append(String.format("%s ", v));
            }
            result.append('\n');
        }

        System.out.println(result);
    }

    public static String[] solution(String[][] plans) {
        // 시간 순서로 정렬
        Arrays.sort(plans, Comparator.comparing(a -> a[1]));

        // 실행을 한적 없는 대기중인 과제들
        Queue<Plan> readyPlans = new LinkedList<>();
        // 실행을 했고 실행 중 멈춘 과제들
        Stack<Plan> pausePlans = new Stack<>();

        for (String[] plan : plans) {
            readyPlans.add(new Plan(plan[0], plan[1], plan[2]));
        }

        String[] answer = new String[plans.length];
        int ansIndex = 0;
        // 현재 시각
        int cTime = -1;
        // 대기중이거나 멈춘 과제가 없을 때까지 반복
        while (!(pausePlans.isEmpty() && readyPlans.isEmpty())) {
            // 대기중인 과제가 있고 현재 진행중인 과제가 없을 경우
            // 대기중인 과제 하나를 진행
            if (!readyPlans.isEmpty() && pausePlans.isEmpty()) {
                cTime = readyPlans.peek().startTime;
                pausePlans.push(readyPlans.poll());
            }

            // 현재 진행중인 과제가 끝나는 시각보다 일찍 진행되어야 하는 과제가 있다면 현재 과제를 멈추고 대기중인 과제 하나를 진행
            while (!readyPlans.isEmpty() && cTime + pausePlans.peek().playtime > readyPlans.peek().startTime) {
                pausePlans.peek().playtime = cTime + pausePlans.peek().playtime - readyPlans.peek().startTime;
                pausePlans.add(readyPlans.poll());
                cTime = pausePlans.peek().startTime;
            }

            // 현재 진행중인 과제를 완료함
            cTime += pausePlans.peek().playtime;
            answer[ansIndex++] = pausePlans.pop().name;
        }

        return answer;
    }

    static class Plan {
        String name;
        int startTime;
        int playtime;

        Plan(String name, String HM, String playtime) {
            this.name = name;
            String[] hm = HM.split(":");
            this.startTime = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
            this.playtime = Integer.parseInt(playtime);
        }
    }
}

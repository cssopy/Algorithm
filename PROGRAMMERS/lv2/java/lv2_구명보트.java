import java.util.Arrays;

public class lv2_구명보트 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        INP[] inps = {
                new INP(new int[]{70, 50, 80, 50}, 100),
                new INP(new int[]{70, 80, 50}, 100),
                new INP(new int[]{40, 50, 150, 160}, 200),
                new INP(new int[]{100, 500, 500, 900, 950}, 1000),
        };

        for (INP inp : inps) {
            result.append(solution(inp.people, inp.limit)).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int ans = 0;
        int left = 0, right = people.length - 1;
        // 양쪽 끝 인덱스에서 제일 큰값과 제일 작은값의 합이 limit 아래면 보트에 태움
        // limit보다 크다면 제일 큰값만 보트에 태워 보냄
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }

            right--;
            ans++;
        }

        return ans;
    }

    static class INP {
        int[] people;
        int limit;

        INP(int[] people, int limit) {
            this.people = people;
            this.limit = limit;
        }
    }
}

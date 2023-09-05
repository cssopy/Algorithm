import java.util.Scanner;

public class BJ_1475 {
    public static void main(String[] args) {
        String N;
        int[] nums = new int[10];
        try (Scanner sc = new Scanner(System.in)) {
            N = sc.next();
        }

        int answer = 0;
        for (int i = 0; i < N.length(); i++) {
            int n = Integer.parseInt(Character.toString(N.charAt(i)));

            // 6 또는 9의 경우 서로 바꿔 사용
            if (n == 6 && nums[6] <= 0 && nums[9] > 0) {
                nums[9]--;
                continue;
            } else if (n == 9 && nums[9] <= 0 && nums[6] > 0) {
                nums[6]--;
                continue;
            }
            // 6, 9 가 아닌 경우 숫자가 없으면 다음 세트를 가져와 사용하고 있으면 그냥 사용
            else if ((n != 6 || n != 9) && nums[n] <= 0) {
                for (int j = 0; j < 10; j++) {
                    nums[j]++;
                }
                answer++;
            }
            nums[n]--;
        }

        System.out.println(answer);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2659 {
    public static void main(String[] args) {
        int[] inps;
        try (Scanner sc = new Scanner(System.in)) {
            inps = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int clockNum = findclockNum(inps);

        int answer = 0;
        for (int i = 1111; i <= clockNum; i++) {
            int temp = i;

            int[] is = new int[4];
            is[3] = temp % 10;
            temp /= 10;
            is[2] = temp % 10;
            temp /= 10;
            is[1] = temp % 10;
            temp /= 10;
            is[0] = temp % 10;

            if (findclockNum(is) == i) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static int findclockNum(int[] inps) {
        int num = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            StringBuilder numStr = new StringBuilder();

            for (int j = i; j < i + 4; j++) {
                numStr.append(inps[j % 4]);
            }

            num = Math.min(num, Integer.parseInt(numStr.toString()));
        }

        return num;
    }
}

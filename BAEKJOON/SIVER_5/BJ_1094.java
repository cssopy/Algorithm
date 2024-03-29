import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1094 {
    public static void main(String[] args) {
        int X;
        try (Scanner sc = new Scanner(System.in)) {
            X = sc.nextInt();
        }

        // 막대들 저장 변수, 길이기준 오름차순
        Queue<Integer> que = new PriorityQueue<>(Comparator.naturalOrder());
        que.add(64);
        int sum = 64;

        while (true) {
            if (sum == X) {
                break;
            }

            // 가지고 있는 가장 짧은 막대 반으로 자름
            int minLen = que.poll();
            int sharedStick = minLen / 2;

            // 자른 막대 하나를 제외한 나머지의 합이 X보다 크거나 같으면 자른 막대 중 하나는 버림
            if (sum - sharedStick >= X) {
                que.add(sharedStick);
                sum -= sharedStick;
            } else {
                que.add(sharedStick);
                que.add(sharedStick);
            }
        }

        System.out.println(que.size());
    }
}

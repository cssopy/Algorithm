package BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ_18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");
        Deque<Integer> deque = new ArrayDeque<>();
        for (int nc = 0; nc < N; nc++) {
            // 땅에 놓인 카드를 가져옴
            int a = nc + 1;
            // 땅에서 가져온 카드에 해당하는 기술
            char x = A[N - nc - 1].charAt(0);

            // 규칙대로 적용
            // 내 손 가장 위에 카드를 가져옴
            if (x == '1') {
                deque.addFirst(a);
            }
            // 내 손 가장 위에서 두번째에 카드를 가져옴
            else if (x == '2') {
                int pop = deque.pollFirst();
                deque.addFirst(a);
                deque.addFirst(pop);
            }
            // 내 손 가장 바닥에 카드를 가져옴
            else {
                deque.addLast(a);
            }
        }

        while (!deque.isEmpty()) {
            result.append(deque.poll()).append(" ");
        }
        System.out.println(result);
    }
}

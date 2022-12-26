package BAEKJOON.SIVER_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        // 우선순위 큐 (내림차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 입력
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());

                pq.add(n);
            }
        }

        // N번째 수 출력
        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                result.append(pq.poll()).append('\n');
            }
            pq.poll();
        }

        System.out.println(result);
    }
}

package BAEKJOON.GOLD_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st = null;

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            // 수열의 크기
            int N = Integer.parseInt(br.readLine());

            result.append((N+1)/2).append('\n');

            PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();

            for(int nc=0; nc<N; nc++){
                // 줄마다 입력받기 위함
                if(nc % 10 == 0){
                    st = new StringTokenizer(br.readLine());
                }

                int v = Integer.parseInt(st.nextToken());

                // 사이즈를 통해 두개의 큐에 번갈아 가며 값을 넣어줌
                if(pq1.size() == pq2.size()){
                    pq1.add(v);
                }else{
                    pq2.add(v);
                }

                // pq2가 나중에 값이 들어가기 때문에 pq2만 안비어있다면 값의 교환을 시도
                // pq1은 내림차순, pq2는 오름차순이고 pq1의 첫번째값이 pq2의 첫번째값보다 클때 두 값을 계속 교환
                // 그렇게 되면 pq1에는 중앙값보다 작은값이, pq2에는 중앙값보다 큰값들이 존재
                // 내림차순인 pq1의 첫번째값은 자연스럽게 중앙값이 된다
                if(!pq2.isEmpty()){
                    if(pq1.peek() > pq2.peek()){
                        int tp = pq1.poll();

                        pq1.add(pq2.poll());
                        pq2.add(tp);
                    }
                }

                if(nc%2==0){
                    // nc가 0일때 줄바꿈이 있으면 안되고 10개 출력하거나 끝까지 다 출력할경우 줄바꿈
                    if(nc!=0&&(nc%9==0 || nc == N-1)){
                        result.append(pq1.peek()).append('\n');
                    }else{
                        result.append(pq1.peek()).append(' ');
                    }
                }
            }
        }

        System.out.println(result);
    }
}

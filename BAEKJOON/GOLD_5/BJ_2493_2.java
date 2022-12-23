package BAEKJOON.GOLD_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_2493_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        // 입력
        int N = Integer.parseInt(br.readLine());
        String[] towers = br.readLine().split(" ");

        // 결과 저장을 위한 배열
        int[] rtowers = new int[N];

        // 타워 정보를 저장할 우선순위 큐
        PriorityQueue<TIF> pq = new PriorityQueue<>(new Comparator<TIF>() {
            @Override
            public int compare(TIF o1, TIF o2) {
                return o1.value-o2.value;
            }
        });
        // 가장 오른쪽 타워를 큐에 넣음
        pq.add(new TIF(towers.length-1, Integer.parseInt(towers[towers.length-1])));
        // 오른쪽에서 두번째 타워부터 고려
        for(int i=towers.length-2; i>=0; i--){
            // 현재 위치의 타워 높이
            int v = Integer.parseInt(towers[i]);

            // 현재 고려되는 타워보다 오른쪽에 있는 수신탑 위치가 확정안된 타워들에 접근
            while(true){
                // 위치가 확정안된 타워들 중 높이가 제일 낮은 타워
                TIF peek = pq.peek();

                // 현재 위치의 타워에 수신될 수 있다면 peek 타워의 수신 타워위치는 현재 위치로 결정
                // 그리고 peek 타워는 큐에서 제외
                if(peek.value <= v){
                    rtowers[peek.index] = i+1;
                    pq.poll();
                }else{
                    break;
                }

                if(pq.isEmpty()){
                    break;
                }
            }

            // 현재 위치의 타워 큐에 넣음
            pq.add(new TIF(i, Integer.parseInt(towers[i])));
        }

        for(int i=0; i<N; i++){
            result.append(rtowers[i]).append(" ");
        }
        System.out.println(result);

//        // 스택
//        int top = -1;
//        TIF[] stack = new TIF[500000];
//
//        int N = Integer.parseInt(br.readLine());
//        String[] towers = br.readLine().split(" ");
//
//        // 입력된 타워 첫번째부터 접근
//        for (int i = 0; i < N; i++) {
//            int inp = Integer.parseInt(towers[i]);
//
//            // 스택이 빌때까지 반복
//            while (top != -1) {
//                // 스택에 가장 상단의 있는 타워가 현재 타워보다 높다면 가장 상단의 타워의 꺼내어 출력
//                // 또한 다음 타워에서도 수신될 가능성이 있으니 break로 while문을 빠져나와 스택에 남겨둠
//                if (stack[top].value >= inp) {
//                    result.append(stack[top].index+1).append(" ");
//                    break;
//                }
//                // 스택 상단의 타워가 현재 타워보다 낮으면 고려될 필요가 없기에 스택에서 제거
//                top--;
//            }
//
//            // 스택이 비어있다면 현재 타워를 감당할 타워가 없다는 의미 0출력
//            if (top == -1)
//                result.append("0 ");
//            // 현재 타워는 스택에 넣음
//            stack[++top] = new TIF(i, inp);
//        }
//
//        System.out.println(result);
    }

    // 타워의 위치와 높이를 나타낼 클래스
    public static class TIF {
        int index;
        int value;

        public TIF(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}

import java.util.*;

public class BJ_2606 {
    public static void main(String[] args) {
        int computerNum, pairNum;
        boolean[][] network;

        // 컴퓨터수, 페어 입력
        // 네트워크 구성
        try (Scanner sc = new Scanner(System.in)) {
            computerNum = sc.nextInt();
            pairNum = sc.nextInt();

            network = new boolean[computerNum + 1][computerNum + 1];
            for (int i = 0; i < pairNum; i++) {
                int c1 = sc.nextInt();
                int c2 = sc.nextInt();

                network[c1][c2] = true;
                network[c2][c1] = true;
            }
        }

        System.out.println(solution(computerNum, network));
    }

    // BFS
    static int solution(int computerNum, boolean[][] network) {
        Queue<Integer> que = new ArrayDeque<>();
        Set<Integer> isVisited = new HashSet<>();
        que.add(1);
        isVisited.add(1);

        int answer = -1;
        while (!que.isEmpty()) {
            int com = que.poll();

            answer++;

            for (int i = 1; i <= computerNum; i++) {
                if(network[com][i] && !isVisited.contains(i)){
                    isVisited.add(i);
                    que.add(i);
                }
            }
        }

        return answer;
    }
}

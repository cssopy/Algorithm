import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_12912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        // 정점의 개수
        int N = Integer.parseInt(br.readLine());

        // 간선 정보 입력
        int[][] lineInfos = new int[N - 1][3];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            lineInfos[i][0] = from;
            lineInfos[i][1] = to;
            lineInfos[i][2] = cost;
        }

        int ans = 0;
        for (int i = 0; i < N - 1; i++) {
            // 인접리스트
            ArrayList<Node>[] list = new ArrayList[N];
            for (int j = 0; j < list.length; j++) {
                list[j] = new ArrayList<>();
            }

            int[] ect = null;
            // 인접리스트 입력
            for (int j = 0; j < N - 1; j++) {
                if(j==i){
                    ect = lineInfos[j];
                }else{
                    int from = lineInfos[j][0];
                    int to = lineInfos[j][1];
                    int cost = lineInfos[j][2];

                    list[from].add(new Node(to, cost));
                    list[to].add(new Node(from, cost));
                }
            }

            int hans = ect[2];
            for(int j=0; j<2; j++){
                boolean[] isVisited = new boolean[N];
                isVisited[ect[j]] = true;
                int[] cn = {0, -1};
                dfs(list, isVisited, ect[j], 0, cn);
                if(cn[1] != -1){
                    isVisited = new boolean[N];
                    isVisited[cn[1]] = true;
                    dfs(list, isVisited, cn[1], 0, cn);
                }

                hans += cn[0];
            }

            ans = Math.max(ans, hans);
        }

        result.append(ans);
        System.out.println(result);
    }

    public static void dfs(ArrayList<Node>[] list, boolean[] isVisited, int crt, int costSum, int[] cn) {
        // 리프노드 도착
        if (list[crt].size() == 1) {
            if (cn[0] < costSum) {
                cn[0] = costSum;
                cn[1] = crt;
            }
        }

        for (Node next : list[crt]) {
            if (!isVisited[next.to]) {
                isVisited[next.to] = true;
                dfs(list, isVisited, next.to, costSum + next.cost, cn);
            }
        }
    }

    public static class Node {
        int to;
        int cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 플로이드-워샬 풀이법 (메모리 초과)
//public class BJ_1967 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder result = new StringBuilder();
//        StringTokenizer st;
//
//        // 노드의 개수
//        int N = Integer.parseInt(br.readLine());
//
//        // 인접 배열
//        int[][] dist = new int[N + 1][N + 1];
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                if (i == j) {
//                    continue;
//                }
//                dist[i][j] = 100_000_000;
//            }
//        }
//
//        // 간선 정보 입력
//        while (true) {
//            st = new StringTokenizer(br.readLine());
//            if (!st.hasMoreTokens()) {
//                break;
//            }
//            // 부모 노드 번호
//            int pn = Integer.parseInt(st.nextToken());
//            // 자식 노드 번호
//            int cn = Integer.parseInt(st.nextToken());
//            // 두 노드 사이의 가중치
//            int weight = Integer.parseInt(st.nextToken());
//
//            dist[pn][cn] = weight;
//            dist[cn][pn] = weight;
//        }
//
//        int mv = 0;
//        for (int k = 1; k <= N; k++) {
//            for (int i = 1; i <= N; i++) {
//                if (i == k) continue;
//                for (int j = 1; j <= N; j++) {
//                    if (j == i) continue;
//                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
//                    if (dist[i][j] != 100_000_000) {
//                        mv = Math.max(mv, dist[i][j]);
//                    }
//                }
//            }
//        }
//
//        result.append(mv);
//        System.out.println(result);
//    }
//}

public class BJ_1967 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        // 노드의 개수
        int N = Integer.parseInt(br.readLine());

        // 인접 리스트 배열
        ArrayList<Node>[] list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            // 부모 노드 번호
            int pn = Integer.parseInt(st.nextToken());
            // 자식 노드 번호
            int cn = Integer.parseInt(st.nextToken());
            // 두 노드 사이의 가중치
            int weight = Integer.parseInt(st.nextToken());

            list[pn].add(new Node(cn, weight));
            list[cn].add(new Node(pn, weight));
        }

        // 거리 최대값, 최대 거리의 노드번호
        int[] mamn = new int[2];
        // 루트노드 1부터 DFS
        boolean[] isVisited = new boolean[N+1];
        isVisited[1] = true;
        solve(mamn, 0, 1, list, isVisited);

        // 최대 거리의 노드부터 DFS
        mamn[0] = 0;
        isVisited = new boolean[N+1];
        isVisited[mamn[1]] = true;
        solve(mamn, 0, mamn[1], list, isVisited);

        result.append(mamn[0]);
        System.out.println(result);
    }

    public static void solve(int[] mamn, int sum, int nodeNum, ArrayList<Node>[] list, boolean[] isVisited){
        if(mamn[0] < sum){
            mamn[0] = sum;
            mamn[1] = nodeNum;
        }

        for(Node node : list[nodeNum]){
            if(isVisited[node.num]){
                continue;
            }

            isVisited[node.num] = true;
            solve(mamn, sum+node.weight, node.num, list, isVisited);
        }
    }

    public static class Node {
        int num;
        int weight;

        Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }
}
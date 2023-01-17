import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_15900 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        // 정점 개수
        int N = Integer.parseInt(br.readLine());

        // 인접 리스트
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        // 노드 방문 여부
        boolean[] isVisited = new boolean[N + 1];
        // 모든 게임말들이 이동할 수 있는 움직임의 합
        int[] totalMoves = new int[1];
        // 1번노드부터 방문하여 DFS
        isVisited[1] = true;
        solve(list, isVisited, 1, 0, totalMoves);

        result.append(totalMoves[0] % 2 == 0 ? "No" : "Yes");
        System.out.println(result);
    }

    // DFS
    public static void solve(ArrayList<Integer>[] list, boolean[] isVisited, int parent, int depth, int[] totalMoves) {
        // 리프 노드에 도착시
        if (list[parent].size() == 1 && parent != 1) {
            totalMoves[0] += depth;
        }

        for (int child : list[parent]) {
            if (!isVisited[child]) {
                isVisited[child] = true;
                solve(list, isVisited, child, depth + 1, totalMoves);
            }
        }
    }
}

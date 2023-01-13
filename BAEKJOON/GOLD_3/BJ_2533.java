import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2533 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        // 정점 수
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][2];
        // 인접 리스트
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        // 관계 입력
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        solve(1, -1, dp, list);

        result.append(Math.min(dp[1][0], dp[1][1]));
        System.out.println(result);
    }

    public static void solve(int node, int p, int[][] dp, ArrayList<Integer>[] list){
        dp[node][0] = 0;
        dp[node][1] = 1;

        for(int c : list[node]){
            if(c != p){
                solve(c, node, dp, list);
                dp[node][0] += dp[c][1];
                dp[node][1] += Math.min(dp[c][0], dp[c][1]);
            }
        }
    }
}

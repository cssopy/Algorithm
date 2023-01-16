import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20364 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        // 땅 개수
        int N = Integer.parseInt(st.nextToken());
        // 오리 수
        int Q = Integer.parseInt(st.nextToken());

        // 땅들 점유됐는지
        boolean[] isOccupied = new boolean[N+1];

        // 오리가 원하는 땅번호 입력
        for(int i=0; i<Q; i++){
            int x = Integer.parseInt(br.readLine());
            int xx = x;
            int t = 0;

            // 땅을 가질 수 있는지 여부
            boolean f = false;
            // 리프노드에서 루트노드까지 탐색
            while(x != 1){
                if(isOccupied[x]){
                    t = x;
                    f = true;
                }
                x = x / 2;
            }

            if(!f){
                result.append(0).append('\n');
                isOccupied[xx] = true;
            }else{
                result.append(t).append('\n');
            }
        }

        System.out.print(result);
    }
}

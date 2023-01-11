import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        // 정점의 개수
        int N = Integer.parseInt(br.readLine());

        // 정점마다 연결된 정점의 개수
        int[] cnts = new int[N+1];

        // 간선 정보 입력
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            cnts[a]++;
            cnts[b]++;
        }

        // 질의의 개수
        int q = Integer.parseInt(br.readLine());
        // 질의 정보 입력
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(t == 1){
                if(cnts[k] >= 2){
                    result.append("yes").append('\n');
                }else{
                    result.append("no").append('\n');
                }
            }else{
                result.append("yes").append('\n');
            }
        }

        System.out.print(result);
    }
}

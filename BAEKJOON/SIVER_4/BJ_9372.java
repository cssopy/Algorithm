import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9372  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            // 국가의 수
            int N = Integer.parseInt(st.nextToken());
            // 비행기의 종류
            int M = Integer.parseInt(st.nextToken());

            for(int mc=0; mc<M; mc++){
                br.readLine();
            }

            // 비행 스케줄은 항상 연결된 그래프를 이루기 때문에 답은 (국가의수-1)
            result.append(N-1).append('\n');
        }

        System.out.println(result);
    }
}

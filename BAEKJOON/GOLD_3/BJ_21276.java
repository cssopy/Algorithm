import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_21276 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        // 사람의 수
        int K = Integer.parseInt(br.readLine());
        // 사람들 이름
        String[] names = br.readLine().split(" ");

        Arrays.sort(names);
        // 이름순 인덱스 부여
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<names.length; i++){
            map.put(names[i], i);
        }

        // 정보의 수
        int M = Integer.parseInt(br.readLine());

        // 조상의 수?
        int[] fths = new int[K];
        // ???
        ArrayList<String>[] list = new ArrayList[K];
        for(int i=0; i<M; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String X = st.nextToken();
            String Y = st.nextToken();

            fths[map.get(X)]++;
            list[map.get(Y)].add(X);
        }

        solve(fths, names, K,list, map, result);

        System.out.print(result);
    }

    public static void solve(int[] fths, String[] names, int K ,ArrayList<String>[] list, HashMap<String, Integer> map, StringBuilder result){
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        int c = 0;
        for(int i=0; i<fths.length; i++){
            if(fths[i] == 0){
                q.add(i);
                sb.append(names[i]).append(' ');
                c++;
            }
        }
        result.append(c).append('\n');
        result.append(sb).append('\n');

        PriorityQueue<String>[] pqs = new PriorityQueue[K];
        for(int i=0; i<K; i++){
            pqs[i] = new PriorityQueue<>();
        }
        boolean[] isVisited = new boolean[K];
        while (!q.isEmpty()){
            int poll = q.poll();

            if(isVisited[poll]){
                continue;
            }
            isVisited[poll] = true;

            for(String s : list[poll]){
                q.add(map.get(s));

                for(String ss : list[map.get(s)]){
                    if(list[poll].contains(ss)){
                        list[poll].add(ss);
                    }
                }
            }
        }

        for(int i=0; i<pqs.length; i++){
            result.append(names[i]).append(' ');
            result.append(pqs[i].size()).append(' ');
            for(String s : pqs[i]){
                result.append(s).append(' ');
            }
            result.append('\n');
        }
    }
}

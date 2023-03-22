import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class lv3_여행경로 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[][][] inps = {
                {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}},
                {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}},
                {{"ICN", "A"}, {"A", "B"}, {"A", "C"}, {"B", "A"}, {"C", "A"}},
                {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}}
        };

        for (String[][] inp : inps) {
            String[] rp = solution(inp);

            for (String s : rp) {
                result.append(s).append(' ');
            }
            result.append('\n');
        }

        System.out.print(result);
    }

    public static String[] solution(String[][] tickets) {
        // 인접 리스트 역할
        Map<String, ArrayList<String>> map = new HashMap<>();
        // 티켓마다 개수
        Map<String, Integer> tn = new HashMap<>();

        for (String[] ticket : tickets) {
            // 인접 리스트 생성
            if (map.get(ticket[0]) == null) {
                map.put(ticket[0], new ArrayList<>());
            }
            map.get(ticket[0]).add(ticket[1]);

            // 티켓 카운트
            tn.put(ticket[0] + " " + ticket[1], tn.get(ticket[0] + " " + ticket[1]) == null ? 1 : tn.get(ticket[0] + " " + ticket[1]) + 1);
        }

        // 출발지마다 목적지를 사전순 정렬
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            Collections.sort(map.get(entry.getKey()));
        }

        // 티켓을 모두 사용했는지와 경로
        Object[] ans = {false, ""};
        DFS(map, tn, 0, tickets.length, "ICN", "", ans);

        return ((String) ans[1]).trim().split(" ");
    }

    public static void DFS(Map<String, ArrayList<String>> map, Map<String, Integer> tn, int depth, int tc, String cap, String vaps, Object[] ans) {
        // 이미 경로 찾았으면 return
        if ((boolean) ans[0]) return;

        vaps += " " + cap;

        // 사용한 티켓수가 총 티켓수와 같다면
        if (depth == tc) {
            ans[0] = true;
            ans[1] = vaps;
            return;
        }

        // cap공항에서 출발하는 항공이 있는지
        if (map.get(cap) != null) {
            for (String nap : map.get(cap)) {
                // 다음 공항으로 갈수있는 티켓이 있으면 다음 공항으로 이동
                if (tn.get(cap + " " + nap) != null && tn.get(cap + " " + nap) > 0) {
                    tn.put(cap + " " + nap, tn.get(cap + " " + nap) - 1);
                    DFS(map, tn, depth + 1, tc, nap, vaps, ans);
                    tn.put(cap + " " + nap, tn.get(cap + " " + nap) + 1);
                }
            }
        }
    }
}

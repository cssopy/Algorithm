import java.util.*;

public class lv3_섬_연결하기 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[] ns = {
                4, 5, 1
        };
        int[][][] costss = {
                {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}},
                {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}},
                {}
        };

        for (int i = 0; i < ns.length; i++) {
            result.append(solution(ns[i], costss[i])).append('\n');
        }

        System.out.print(result);
    }

    public static int solution(int n, int[][] costs) {
        // 인접 리스트 생성
        Map<Integer, ArrayList<Bridge>> graph = new HashMap<>();
        int in = 0;
        for (int[] cost : costs) {
            if (graph.get(cost[0]) == null) {
                graph.put(cost[0], new ArrayList<>());
            }
            graph.get(cost[0]).add(new Bridge(cost[1], cost[2]));

            if (graph.get(cost[1]) == null) {
                graph.put(cost[1], new ArrayList<>());
            }
            graph.get(cost[1]).add(new Bridge(cost[0], cost[2]));
            
            in = cost[0];
        }

        // 선택해야할 다리들 (오름차순)
        PriorityQueue<Bridge> rb = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        rb.add(new Bridge(in, 0));
        Set<Integer> isVisited = new HashSet<>();
        int ans = 0;
        while (true) {
            Bridge cb = rb.poll();

            // 방문할 섬이 이미 방문했다면 continue
            if (isVisited.contains(cb.to)) {
                continue;
            }

            // 섬 방문여부, 방문한 섬 횟수, 다리건설 총 비용 처리
            isVisited.add(cb.to);
            ans += cb.cost;

            // 모든 섬 방문했으면 break
            if (isVisited.size() == n) {
                break;
            }

            // 현재 섬과 연결된 방문 안한 섬의 다리를 모두 추가
            if (graph.get(cb.to) != null) {
                for (Bridge bridge : graph.get(cb.to)) {
                    if (!isVisited.contains(bridge.to)) {
                        rb.add(bridge);
                    }
                }
            }
        }

        return ans;
    }

    static class Bridge {
        int to;
        int cost;

        Bridge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}

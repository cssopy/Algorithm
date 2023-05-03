import java.util.*;

public class lv3_부대복귀 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp(3, new int[][]{{1, 2}, {2, 3}}, new int[]{2, 3}, 1),
                new Inp(5, new int[][]{{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}}, new int[]{1, 3, 5}, 5)
        };

        for (Inp inp : inps) {
            int[] ans = solution(inp.n, inp.roads, inp.sources, inp.destination);
            for (int v : ans) {
                result.append(String.format("%d ", v));
            }
            result.append('\n');
        }

        System.out.println(result);
    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        // 인접리스트 생성
        for (int[] road : roads) {
            if (list[road[0]] == null) list[road[0]] = new ArrayList<>();
            if (list[road[1]] == null) list[road[1]] = new ArrayList<>();
            list[road[0]].add(road[1]);
            list[road[1]].add(road[0]);
        }

        // 목적지부터 각 구역까지 걸리는 시간
        int[] shortRoute = dfs(n, list, destination);

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = shortRoute[sources[i]];
        }

        return answer;
    }

    static int[] dfs(int n, ArrayList<Integer>[] list, int destination) {
        Queue<Area> que = new LinkedList<>();
        Set<Integer> isVisited = new HashSet<>();
        que.add(new Area(destination, 0));
        isVisited.add(destination);

        int[] shortRoute = new int[n + 1];
        Arrays.fill(shortRoute, -1);
        while (!que.isEmpty()) {
            Area c = que.poll();

            // 각 지역마다 도착시, 걸린 시간 기록
            shortRoute[c.number] = c.depth;

            if (list[c.number] != null) {
                for (int next : list[c.number]) {
                    if (!isVisited.contains(next)) {
                        isVisited.add(next);
                        que.add(new Area(next, c.depth + 1));
                    }
                }
            }
        }
        return shortRoute;
    }

    static class Area {
        int number;
        int depth;

        Area(int number, int depth) {
            this.number = number;
            this.depth = depth;
        }
    }

    static class Inp {
        int n;
        int[][] roads;
        int[] sources;
        int destination;

        Inp(int n, int[][] roads, int[] sources, int destination) {
            this.n = n;
            this.roads = roads;
            this.sources = sources;
            this.destination = destination;
        }
    }
}

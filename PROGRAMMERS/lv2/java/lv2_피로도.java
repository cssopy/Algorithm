public class lv2_피로도 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int k = 80;
        int[][] dungeons = {
                {80, 20},
                {50, 40},
                {30, 10}
        };

        result.append(solution(k, dungeons));
        System.out.println(result);
    }

    public static int solution(int k, int[][] dungeons) {
        int[] ans = new int[1];

        // dfs로 최대한 노드를 들어가며 최대 깊이를 계속 갱신
        dfs(k, dungeons, new boolean[dungeons.length], 0, ans);

        return ans[0];
    }

    public static void dfs(int k, int[][] dungeons, boolean[] isVisited, int i, int[] ans) {
        ans[0] = Math.max(ans[0], i);

        for (int j = 0; j < dungeons.length; j++) {
            // 해당 던전을 방문안했고 용사의 피로도가 해당 던전의 최소 요구 피로도 이상이어야 진행
            if (!isVisited[j] && k >= dungeons[j][0]) {
                isVisited[j] = true;
                dfs(k - dungeons[j][1], dungeons, isVisited, i + 1, ans);
                isVisited[j] = false;
            }
        }
    }
}

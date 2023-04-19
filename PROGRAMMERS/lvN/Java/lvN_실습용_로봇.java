public class lvN_실습용_로봇 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[] inps = {
                "GRGLGRG",
                "GRGRGRB"
        };

        for (String inp : inps) {
            int[] rs = solution(inp);
            for (int r : rs) {
                result.append(String.format("%d ", r));
            }
            result.append('\n');
        }

        System.out.println(result);
    }

    public static int[] solution(String command) {
        // 상우하좌
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 방향정보
        int dir = 0;
        // 로켓의 좌표
        int[] ans = {0, 0};
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);

            switch (c) {
                case 'G':
                    ans[0] += dirs[dir][0];
                    ans[1] += dirs[dir][1];
                    break;
                case 'B':
                    ans[0] -= dirs[dir][0];
                    ans[1] -= dirs[dir][1];
                    break;
                case 'L':
                    dir = (dir + 3) % 4;
                    break;
                case 'R':
                    dir = (dir + 1) % 4;
                    break;
            }
        }

        return ans;
    }
}

public class lv0_특별한_이차원_배열_2 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int[][][] inps = {
                {{5, 192, 33}, {192, 72, 95}, {33, 95, 999}},
                {{19, 498, 258, 587}, {63, 93, 7, 754}, {258, 7, 1000, 723}, {587, 754, 723, 81}}
        };

        for (int[][] inp : inps) {
            result.append(String.format("%d\n", solution(inp)));
        }

        System.out.println(result);
    }

    public static int solution(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != arr[j][i]) return 0;
            }
        }
        return 1;
    }
}

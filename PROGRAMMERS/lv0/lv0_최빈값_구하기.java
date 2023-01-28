public class lv0_최빈값_구하기 {
    public static void main(String[] args) {
        int[][] inps = {{1, 2, 3, 3, 3, 4}, {1, 1, 2, 2}, {1}};
        for (int i = 0; i < inps.length; i++) {
            int ans = solution(inps[i]);
            System.out.println(ans);
        }
    }

    public static int solution(int[] array) {
        int[] fqs = new int[1001];
        for (int i = 0; i < array.length; i++) {
            fqs[array[i]]++;
        }

        int max = 0;
        int ans = 0;
        int f = 0;
        for (int i = 0; i < fqs.length; i++) {
            if (max < fqs[i]) {
                max = fqs[i];
                ans = i;
                f = 0;
            } else if (max == fqs[i]) {
                f++;
            }
        }
        return f == 0 ? ans : -1;
    }
}
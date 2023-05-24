public class lv3_입국심사 {
    public long solution(int n, int[] times) {
        long s = 0l, e = 1_000_000_000_000_000_000l;

        // 이분탐색
        while (s + 1 != e) {
            long m = (s + e) / 2;

            // m시간에서 모든 심사관들의 처리할 수 있는 수
            long pn = 0;
            for (int time : times) {
                pn += m / time;
            }

            if (pn >= n) e = m;
            else s = m;

        }

        return e;
    }
}

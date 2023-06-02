public class lv3_징검다리_건너기 {
    public int solution(int[] stones, int k) {
        int l = 1, r = 200_000_000;
        // 이분 탐색
        while (l <= r) {
            int mid = (l + r) / 2;

            // mid 명이 건넌다고 할때 한번에 건너뛰어야 하는 디딤돌수
            int cnt = 0;
            for (int stone : stones) {
                if (stone - mid <= 0) {
                    cnt++;
                } else {
                    cnt = 0;
                }

                // cnt가 k이상이면 현재 mid명이 최대거나 커버할 수 없음
                if (cnt >= k) {
                    break;
                }
            }

            if (cnt >= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}

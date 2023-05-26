public class lv3_최고의_집합 {
    public int[] solution(int n, int s) {
        // 최소 n이 s랑 같으면 {1,1,...,1} 집합이 가능하지만 n이 s보다 크면 불가능
        if (n > s) return new int[]{-1};

        int[] answer = new int[n];
        // 각 원소의 값이 최대한 비슷할수록 집합의 크기가 커짐
        for (int i = 0; n > 0; i++, n--) {
            answer[i] = s / n;
            s -= s / n;
        }

        return answer;
    }
}

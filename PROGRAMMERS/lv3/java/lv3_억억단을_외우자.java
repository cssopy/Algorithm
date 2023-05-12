public class lv3_억억단을_외우자 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp(8, new int[]{1, 3, 7})
        };

        for (Inp inp : inps) {
            int[] answer = solution(inp.e, inp.starts);
            for (int v : answer) {
                result.append(String.format("%d ", v));
            }
            result.append('\n');
        }

        System.out.println(result);
    }

    public static int[] solution(int e, int[] starts) {
        // 각 숫자별 약수의 개수를 동시에 미리 카운트
        int[] counts = new int[e + 1];
        for(int i = 1 ; i<=e ; i++){
            for(int j = 1 ; j<=(e/i) ; j++){
                counts[i*j]++;
            }
        }

        // e범위에서 i범위까지의 제일 많이 등장하는 숫자를 갱신하며
        // i범위까지 고려했을때의 제일 많이 등장하는 숫자를 결정
        int[] numMax = new int[e + 1];
        for (int i = e, mc = 0, mn = 0; i >= 1; i--) {
            mn = counts[i] >= mc ? i : mn;
            mc = counts[i] >= mc ? counts[i] : mc;
            numMax[i] = mn;
        }

        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            int start = starts[i];

            answer[i] = numMax[start];
        }

        return answer;
    }

    static class Inp {
        int e;
        int[] starts;

        Inp(int e, int[] starts) {
            this.e = e;
            this.starts = starts;
        }
    }
}

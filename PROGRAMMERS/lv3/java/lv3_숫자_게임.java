import java.util.Arrays;

public class lv3_숫자_게임 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}),
                new Inp(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1})
        };

        for (Inp inp : inps) {
            result.append(String.format("%d\n", solution(inp.A, inp.B)));
        }

        System.out.println(result);
    }

    public static int solution(int[] A, int[] B) {
        // 나오는 순서는 상관없이 A팀을 최대한 이기는 경우를 찾아야 하기에 비교하기 수월하게 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        int ans = 0;
        for (int ai = 0, bi = 0; bi < B.length; ) {
            // B팀원이 A팀원을 이기면 카운트, A,B 팀 둘다 다음 팀원으로 넘어감
            if (A[ai] < B[bi]) {
                ai++;
                bi++;
                ans++;
            }
            // A팀원이 더 크면 B팀만 다음 선수 고려
            else {
                bi++;
            }
        }

        return ans;
    }

    static class Inp {
        int[] A, B;

        Inp(int[] A, int[] B) {
            this.A = A;
            this.B = B;
        }
    }
}

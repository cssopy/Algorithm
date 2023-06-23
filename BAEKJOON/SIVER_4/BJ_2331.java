import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_2331 {
    public static void main(String[] args) {
        int A, P;

        try (Scanner sc = new Scanner(System.in)) {
            A = sc.nextInt();
            P = sc.nextInt();
        }

        System.out.println(solution(A, P));
    }

    static int solution(int A, int P) {
        Set<Integer> set = new HashSet<>();
        boolean fi = false, di = false;

        // 두번째 싸이클까지 반복
        while (true) {
            if (fi && di) break;

            // 첫 싸이클에 처음 들어오는 값들
            if (!fi && !set.contains(A)) {
                set.add(A);
            }
            // 두번째 싸이클에 한번더 들어오는 처음 값 삭제
            // 첫번째 싸이클은 끝났다는 의미 부여
            else if (!fi && !di && set.contains(A)) {
                set.remove(A);
                fi = true;
            }
            // 두번째 싸이클에 한번더 들어오는 값들 삭제
            else if (fi && set.contains(A)) {
                set.remove(A);
            }
            // 세번째 싸이클에 또 반복되는 숫자가 나온 경우
            // 두번째 싸이클이 끝났다는 의미 부여
            else if (fi && !set.contains(A)) {
                di = true;
            }

            A = getNV(A, P);
        }

        return set.size();
    }

    static int getNV(int A, int P) {
        String s = String.valueOf(A);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += Math.pow(Integer.parseInt(Character.toString(s.charAt(i))), P);
        }

        return result;
    }
}
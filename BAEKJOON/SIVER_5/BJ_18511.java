import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_18511 {
    public static void main(String[] args) {
        int N, K;
        Set<Character> set = new HashSet<>();

        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
            K = sc.nextInt();
            for (int i = 0; i < K; i++) {
                set.add((char) (sc.nextInt() + '0'));
            }
        }

        // N부터 1까지 접근
        for (int i = N, c = 0; i > 0; i--, c = 0) {
            String num = String.valueOf(i);
            // 자리수마다 K안에 해당하는 수인지 판단
            for (int j = 0; j < num.length(); j++) {
                if (!set.contains(num.charAt(j))) {
                    break;
                }
                c++;
            }
            // 해당 숫자가 K로만 구성된 숫자이면 출력하고 반복 종료
            if (c == num.length()) {
                System.out.println(i);
                break;
            }
        }
    }
}

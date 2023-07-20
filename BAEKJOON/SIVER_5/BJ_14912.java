import java.util.Scanner;

public class BJ_14912 {
    public static void main(String[] args) {
        int n, d;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
            d = sc.nextInt();
        }

        String ds = Integer.toString(d);
        char dc = (char) ('0' + d);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            String is = Integer.toString(i);

            // i가 d를 포함하면 d가 몇개인지 카운트
            if (is.contains(ds)) {
                char[] ns = is.toCharArray();

                for (int j = 0; j < ns.length; j++) {
                    if (ns[j] == dc) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_5568 {
    public static void main(String[] args) {
        int n, k;
        int[] ns;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
            k = sc.nextInt();

            ns = new int[n];
            for (int i = 0; i < n; i++) {
                ns[i] = sc.nextInt();
            }
        }

        // 만들 수 있는 정수 집합 (중복 제거)
        Set<String> set = new HashSet<>();
        dfs(n, k, ns, new boolean[n], 0, "", set);

        System.out.println(set.size());
    }

    static void dfs(int n, int k, int[] ns, boolean[] isSel, int depth, String sum, Set<String> set) {
        if (depth == k) {
            set.add(sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isSel[i]) {
                isSel[i] = true;
                dfs(n, k, ns, isSel, depth + 1, sum + String.valueOf(ns[i]), set);
                isSel[i] = false;
            }
        }
    }
}

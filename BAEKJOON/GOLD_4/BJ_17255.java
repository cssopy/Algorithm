package BAEKJOON.GOLD_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 메모리  : 12456 KB
 * 시간   : 80 ms
 */

public class BJ_17255 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        String N = br.readLine();

        // 중복을 제거하기 위한 집합
        HashSet<String> set = new HashSet<>();

        // 입력의 각 자리수부터 시작
        for (int i = 0; i < N.length(); i++) {
            solve(i, i, N, set, "" + N.charAt(i), "" + N.charAt(i));
        }

        result.append(set.size());
        System.out.println(result);
    }

    static void solve(int l, int r, String N, HashSet<String> set, String s, String p) {
        // 왼쪽, 오른쪽 모두 도달했으면 중단
        if (l == 0 && r == N.length() - 1) {
            set.add(p);
            return;
        }
        // 왼쪽으로 갈 수 있으면 왼쪽이동
        if (l - 1 >= 0) {
            solve(l - 1, r, N, set, N.charAt(l - 1) + s, p + N.charAt(l - 1) + s);
        }
        // 오른쪽으로 갈 수 있으면 오른쪽이동
        if (r + 1 < N.length()) {
            solve(l, r + 1, N, set, s + N.charAt(r + 1), p + s + N.charAt(r + 1));
        }
    }
}

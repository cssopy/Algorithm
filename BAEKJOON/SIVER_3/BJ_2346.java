package BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 풍선 정보 입력
        ArrayList<TTFS> list = new ArrayList<>();
        for (int nc = 0; nc < N; nc++) {
            TTFS ttfs = new TTFS();
            ttfs.index = nc;
            ttfs.value = Integer.parseInt(st.nextToken());
            list.add(ttfs);
        }

        int idx = 0;
        while (true) {
            TTFS ttfs = list.get(idx);

            // 풍선 제거
            list.remove(idx);

            // 제거된 풍선 번호 출력
            result.append(ttfs.index + 1);
            result.append(" ");

            // 풍선 없으면 스탑
            if (list.size() == 0) {
                break;
            }

            // 오른쪽 방향의 경우
            if (ttfs.value > 0) {
                idx = (idx + ttfs.value - 1) % list.size();
            }
            // 왼쪽 방향의 경우
            else if (ttfs.value < 0) {
                idx = (idx + list.size() + (ttfs.value % list.size())) % list.size();
            }
        }

        System.out.println(result);
    }

    public static class TTFS {
        int index;
        int value;
    }
}

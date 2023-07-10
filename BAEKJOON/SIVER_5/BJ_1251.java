import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BJ_1251 {
    public static void main(String[] args) {
        String s;

        try (Scanner sc = new Scanner(System.in)) {
            s = sc.next();
        }

        // 조건에 의해 만들어질 단어 리스트
        List<String> list = new ArrayList<>();
        for (int i = 1; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                // 세개의 구간 단어를 뒤집고 합쳐서 리스트에 추가
                list.add(new StringBuilder(s.substring(0, i)).reverse()
                        .append(new StringBuilder(s.substring(i, j)).reverse())
                        .append(new StringBuilder(s.substring(j)).reverse()).toString());
            }
        }
        // 사전순 정렬
        Collections.sort(list);

        System.out.println(list.get(0));
    }
}

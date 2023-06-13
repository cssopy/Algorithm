import java.util.*;

public class BJ_1316 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            // 등장한 알파벳
            Set<Character> set = new HashSet<>();
            int answer = 0;
            for (int i = 0; i < N; i++) {
                // 입력된 단어에서 연속된 알파벳을 1회로 줄임
                String word = sc.next().replaceAll("(.)\\1+", "$1");

                set.clear();
                for (int j = 0; j < word.length(); j++) {
                    // 등장한 적 있는 알파벳이면 해당 단어는 중단
                    if (set.contains(word.charAt(j))) break;
                    set.add(word.charAt(j));

                    if (j == word.length() - 1) answer++;
                }
            }

            System.out.println(answer);
        }
    }
}

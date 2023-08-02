import java.util.*;

public class BJ_1969 {
    public static void main(String[] args) {
        int N, M;
        char[][] dnas;
        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
            M = sc.nextInt();
            dnas = new char[N][];
            for (int i = 0; i < N; i++) {
                dnas[i] = sc.next().toCharArray();
            }
        }

        // 각 열마다 최대 빈도수이며 사전순으로 먼저인 문자를 answer배열에 결정
        char[] answer = new char[M];
        for (int i = 0; i < M; i++) {
            Map<Character, Integer> map = new HashMap<>();

            int m = 0;
            for (int j = 0; j < N; j++) {
                map.put(dnas[j][i], map.getOrDefault(dnas[j][i], 0) + 1);
                m = Math.max(m, map.get(dnas[j][i]));
            }

            List<Character> keyList = new ArrayList<>(map.keySet());
            keyList.sort(Comparator.naturalOrder());
            for (char c : keyList) {
                if (map.get(c) == m) {
                    answer[i] = c;
                    break;
                }
            }
        }

        // 도출된 dna로 모든 dna와의 Hamming Distance의 합을 구함
        int c = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(answer[j] != dnas[i][j]){
                    c++;
                }
            }
        }

        System.out.println(answer);
        System.out.println(c);
    }
}

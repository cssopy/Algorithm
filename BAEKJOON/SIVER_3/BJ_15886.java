import java.util.Scanner;

public class BJ_15886 {
    public static void main(String[] args) {
        int N;
        String map;
        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
            map = sc.next();
        }

        int answer = 0;
        // 구사과는 절대 지도를 벗어나지 않는 조건에 의해 지도에서 EW 구간에 항상 갇히게 됨
        // EW구간의 개수 = 답
        for (int i = 0; i < N - 1; i++) {
            if (map.charAt(i) == 'E' && map.charAt(i + 1) == 'W') {
                answer++;
            }
        }

        System.out.println(answer);
    }
}

import java.util.Scanner;

public class BJ_12933 {
    public static void main(String[] args) {
        char[] inp;

        try (Scanner sc = new Scanner(System.in)) {
            inp = sc.next().toCharArray();
        }

        char[] QUACK = {'q', 'u', 'a', 'c', 'k'};
        // 몇마리든 입력의 길이는 5의 배수여야 함
        if (inp.length % 5 != 0) {
            System.out.println(-1);
        } else {
            // 남은 문자수
            int remain = inp.length;
            // 오리 카운트
            int c = 0;

            // 모든 문자 탐색
            while (remain != 0) {
                int QUACK_idx = 0;
                boolean f = false;

                // c+1번째 오리 순서에 대해 quack 순서에 맞는 문자를 X로 바꿈
                // 순서에 맞으면 remain값도 감소
                // 한번이라도 quack 순서를 모두 지켜 QUACK_idx가 5가 된다면 오리 카운트 및 f=true
                for (int i = 0; i < inp.length; i++) {
                    if (inp[i] == QUACK[QUACK_idx]) {
                        QUACK_idx++;
                        remain--;
                        inp[i] = 'X';
                        if (QUACK_idx == 5) {
                            f = true;
                            QUACK_idx = 0;
                        }
                    }
                }

                if (f) {
                    c++;
                }
                // 중간에 quack 순서에 안맞는 경우 바로 break로 반복문 탈출
                // 그러면 remain값이 남게 되므로 -1출력
                else {
                    break;
                }
            }

            System.out.println(remain == 0 ? c : -1);
        }
    }
}

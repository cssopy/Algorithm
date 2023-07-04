import java.util.Scanner;

public class BJ_1913 {
    public static void main(String[] args) {
        int N, K;

        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();
            K = sc.nextInt();
        }

        // 출력할 맵정보와 좌표
        int[][] map = new int[N][N];
        int[] aPoint = {N / 2+1, N / 2+1};
        // 정중앙 1부터 시작
        map[N / 2][N / 2] = 1;

        // 4방 (상우하좌)
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // 현재 좌표, 방향
        int[] point = {N / 2, N / 2};
        int dir = 0;
        // 채워야 할 숫자, 해당 방향으로 채워야하는 칸수, 회전 횟수
        int n = 2, d = 1, c = 0;
        while (n < N * N) {
            // 현재 방향으로 d칸 만큼 채움
            for (int i = 0; i < d; i++) {
                point[0] += dirs[dir][0];
                point[1] += dirs[dir][1];
                map[point[0]][point[1]] = n++;

                // 찾는 숫자가 나오면 좌표 저장
                if (map[point[0]][point[1]] == K) {
                    aPoint = new int[]{point[0] + 1, point[1] + 1};
                }

                // 최대로 채울 수 있는 숫자 도달 시 종료
                if (map[point[0]][point[1]] == N * N) {
                    break;
                }
            }
            // 회전, 회전카운트 증가
            dir = (dir + 1) % 4;
            c++;

            // 2번 회전하면
            if (c == 2) {
                d++;
                c = 0;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int[] row : map) {
            for (int v : row) {
                result.append(v).append(' ');
            }
            result.append('\n');
        }
        result.append(aPoint[0]).append(' ').append(aPoint[1]);

        System.out.println(result);
    }
}

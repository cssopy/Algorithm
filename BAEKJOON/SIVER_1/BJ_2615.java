import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BJ_2615 {
    public static void main(String[] args) {
        char[][] map = new char[19][];
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < 19; i++) {
                map[i] = sc.nextLine().replaceAll(" ", "").toCharArray();
            }
        }

        int[][] dirs = {{0, 1}, {1, 1}, {1, 0}, {1, -1}};
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] == '1' || map[i][j] == '2') {
                    // 팔방으로 바둘돌 개수 카운트체크
                    for (int dir = 0; dir < dirs.length; dir++) {
                        List<int[]> list = new ArrayList<>();
                        list.add(new int[]{i + 1, j + 1});
                        int c = 1;
                        int ni = i;
                        int nj = j;

                        // 정방향
                        while (true) {
                            ni += dirs[dir][0];
                            nj += dirs[dir][1];

                            // 바둑판 벗어나거나 바둑돌이 없거나 동일한 바둑돌이 아니면 break
                            if (ni < 0 || ni >= 19 || nj < 0 || nj >= 19 || map[ni][nj] == '0' || map[ni][nj] != map[i][j]) {
                                break;
                            }

                            list.add(new int[]{ni + 1, nj + 1});
                            c++;
                        }

                        ni = i;
                        nj = j;

                        // 반대방향
                        while (true) {
                            ni -= dirs[dir][0];
                            nj -= dirs[dir][1];

                            // 바둑판 벗어나거나 바둑돌이 없거나 동일한 바둑돌이 아니면 break
                            if (ni < 0 || ni >= 19 || nj < 0 || nj >= 19 || map[ni][nj] == '0' || map[ni][nj] != map[i][j]) {
                                break;
                            }

                            list.add(new int[]{ni + 1, nj + 1});
                            c++;
                        }

                        if (c == 5) {
                            // 저장했던 바둑돌 좌표들 왼쪽우선 위쪽우선으로 정렬
                            list.sort((o1, o2) -> {
                                if (o1[0] == o2[0]) {
                                    return Integer.compare(o1[0], o2[0]);
                                } else {
                                    return Integer.compare(o1[1], o2[1]);
                                }
                            });
                            System.out.println(map[i][j]);
                            System.out.println(list.get(0)[0] + " " + list.get(0)[1]);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }
}

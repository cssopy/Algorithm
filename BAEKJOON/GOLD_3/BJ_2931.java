package Algorithm.BAEKJOON.GOLD_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가스관
// https://www.acmicpc.net/problem/2931
public class BJ_2931 {
    // 유럽의 세로크기, 가로크기 (행, 열)
    static int R , C;
    // 가스관 종류
    static char[] pipes = {'|', '-', '+', '1', '2', '3', '4'};
    // 상하좌우
    static int[] dirx = {0, 0, -1, 1};
    static int[] diry = {-1, 1, 0, 0};
    // 유럽지도
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        // 유럽의 세로크기 (행)
        R = Integer.parseInt(st.nextToken());
        // 유럽의 가로크기 (열)
        C = Integer.parseInt(st.nextToken());

        // 유럽지도
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String l = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = l.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] != '.'){
                    continue;
                }

                // 상하좌우로 연결할 수 있는 파이프의 개수가 2개 이상인지 확인
                char result = isMoreThanTwo(R, C, i, j);

                if (result != 'F') {
                    sb.append(i + 1);
                    sb.append(' ');
                    sb.append(j + 1);
                    sb.append(' ');
                    sb.append(result);
                    sb.append('\n');
                }
            }
        }

        System.out.println(sb.toString());
    }

    // 해당 좌표의 사방의 연결될 수 있는 파이프의 수가 2개 이상인지 확인하고 그에 맞는 파이프를 반환
    public static char isMoreThanTwo(int R, int C, int i, int j) {
        boolean[] vn = new boolean[4];

        for (int dir = 0; dir < 4; dir++) {
            // 각 방향으로의 좌표
            int ni = i + diry[dir];
            int nj = j + dirx[dir];

            // 세로를 벗어나면 넘김
            if (ni < 0 || ni >= R) {
                continue;
            }
            // 가로를 벗어나면 넘김
            if (nj < 0 || nj >= C) {
                continue;
            }

            // 상
            if (dir == 0) {
                if (map[ni][nj] == pipes[0] || map[ni][nj] == pipes[2] || map[ni][nj] == pipes[3] || map[ni][nj] == pipes[6]) {
                    vn[dir] = true;
                }
            }
            // 하
            if (dir == 1) {
                if (map[ni][nj] == pipes[0] || map[ni][nj] == pipes[2] || map[ni][nj] == pipes[4] || map[ni][nj] == pipes[5]) {
                    vn[dir] = true;
                }
            }
            // 좌
            if (dir == 2) {
                if (map[ni][nj] == pipes[1] || map[ni][nj] == pipes[2] || map[ni][nj] == pipes[3] || map[ni][nj] == pipes[4]) {
                    vn[dir] = true;
                }
            }
            // 우
            if (dir == 3) {
                if (map[ni][nj] == pipes[1] || map[ni][nj] == pipes[2] || map[ni][nj] == pipes[5] || map[ni][nj] == pipes[6]) {
                    vn[dir] = true;
                }
            }
        }

        // 상하 좌우 상하좌우 우하 상우 상좌 하좌
        if (vn[0] == true && vn[1] == true && vn[2] == false && vn[3] == false) {
            return '|';
        } else if (vn[0] == false && vn[1] == false && vn[2] == true && vn[3] == true) {
            return '-';
        } else if (vn[0] == true && vn[1] == true && vn[2] == true && vn[3] == true) {
            return '+';
        } else if (vn[0] == false && vn[1] == true && vn[2] == false && vn[3] == true) {
            return '1';
        } else if (vn[0] == true && vn[1] == false && vn[2] == false && vn[3] == true) {
            return '2';
        } else if (vn[0] == true && vn[1] == false && vn[2] == true && vn[3] == false) {
            return '3';
        } else if (vn[0] == false && vn[1] == true && vn[2] == true && vn[3] == false) {
            return '4';
        }

        return 'F';
    }
}

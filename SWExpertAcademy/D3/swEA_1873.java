package Algorithm.SWExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 상호의 배틀필드 (D3)
// 주어진 맵과 명령어가 있을때 명령어를다 수행한 후의 맵상태를 구하는 문제
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc
public class swEA_1873 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++) {
			int h, w;
			String[] hw = br.readLine().split(" ");
			h = Integer.parseInt(hw[0]);
			w = Integer.parseInt(hw[1]);
	
			int[] pos = new int[2];
			int[] dir = new int[1];
			char[][] map = new char[h][w];
			for (int i = 0; i < h; i++) {
				String inp = br.readLine();
				for (int j = 0; j < w; j++) {
					if (inp.charAt(j) == '<' || inp.charAt(j) == '^' || inp.charAt(j) == 'v' || inp.charAt(j) == '>') {
						if 		(inp.charAt(j) == '<')	dir[0] = 0;
						else if (inp.charAt(j) == '^')	dir[0] = 1;
						else if (inp.charAt(j) == 'v')	dir[0] = 2;
						else if (inp.charAt(j) == '>')	dir[0] = 3;
						pos[0] = i;
						pos[1] = j;
					}
					map[i][j] = inp.charAt(j);
				}
			}
	
			int n = Integer.parseInt(br.readLine());
			String command = br.readLine();
	
			for (int i = 0; i < n; i++) {
				if (command.charAt(i) != 'S')
					move(map, pos, dir, command.charAt(i));
				else
					shoot(map, pos, dir);
			}
			
			System.out.print("#" + (tc + 1) + " ");
			for (int k = 0; k < h; k++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[k][j]);
				}
				System.out.println();
			}
		}
		br.close();
	}
	
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void move(char[][] map, int[] pos, int[] dir, char command) {
		int[] pos_t = new int[2];
		int h = map.length;
		int w = map[0].length;
		
		if		(command == 'L')	dir[0]=0;
		else if (command == 'U')	dir[0]=1;
		else if (command == 'D')	dir[0]=2;
		else if (command == 'R')	dir[0]=3;

		pos_t[0] = pos[0] + dy[dir[0]];
		pos_t[1] = pos[1] + dx[dir[0]];
		if (((pos_t[0] >= 0 && pos_t[0] < h) && (pos_t[1] >= 0 && pos_t[1] < w)) && map[pos_t[0]][pos_t[1]] == '.') {
			map[pos[0]][pos[1]]='.';
			if 		(dir[0] == 0)	map[pos_t[0]][pos_t[1]] = '<';
			else if (dir[0] == 1)	map[pos_t[0]][pos_t[1]] = '^';
			else if (dir[0] == 2)	map[pos_t[0]][pos_t[1]] = 'v';
			else					map[pos_t[0]][pos_t[1]] = '>';
			pos[0] = pos_t[0];
			pos[1] = pos_t[1];
		}
		else {
			if 		(dir[0] == 0)	map[pos[0]][pos[1]] = '<';
			else if (dir[0] == 1)	map[pos[0]][pos[1]] = '^';
			else if (dir[0] == 2)	map[pos[0]][pos[1]] = 'v';
			else					map[pos[0]][pos[1]] = '>';
		}
	}

	public static void shoot(char[][] map, int[] pos, int[] dir) {
		int h = map.length;
		int w = map[0].length;
		int x, y;
		
		int[] pos_bult = new int[2];
		pos_bult[0] = pos[0];
		pos_bult[1] = pos[1];
		
		while (true) {
			x = pos_bult[1] + dx[dir[0]];
			y = pos_bult[0] + dy[dir[0]];

			if (((x >= 0 && x < w) && (y >= 0 && y < h)) && map[y][x] == '*') {
				map[y][x] = '.';
				break;
			} else if (((x < 0 || x >= w) || (y < 0 || y >= h)) || map[y][x] == '#') {
				break;
			}

			pos_bult[0] = y;
			pos_bult[1] = x;
		}
	}
}

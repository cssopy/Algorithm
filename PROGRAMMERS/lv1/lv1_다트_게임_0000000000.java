package Algorithm.PROGRAMMERS.lv1;

// [1차] 다트 게임
// https://programmers.co.kr/learn/courses/30/lessons/17682
public class lv1_다트_게임_0000000000 {
	public static void main(String[] args) {
		String[] inps = { "1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*" };
		
		for(String inp:inps) {
			System.out.println(solution(inp));
		}
	}

	public static int solution(String dartResult) {
		String n = "";
		char b = 'N';
		char o = 'N';

		String[][] ch = new String[3][3];
		for (int i = 0, k=0; i < dartResult.length(); i++) {
			char ip = dartResult.charAt(i);

			if (ip >= '0' && ip <= '9') {
				n += ip;
			} else if (ip == 'S' || ip == 'D' || ip == 'T') {
				b = ip;
			} else {
				o = ip;
			}

			ch[k][0] = n.toString();
			ch[k][1] = "" + b;
			ch[k++][2] = (o == 'N') ? (null) : ("" + o);
			
			n = "";
			b = 'N';
			o = 'N';
		}

		int ans = 0;
		for (int i = 0; i < 3; i++) {
			int sec = 1;
			if (ch[i][1].equals("S")) {
				sec *= Math.pow(Integer.parseInt(ch[i][0]), 1);
			} else if (ch[i][1].equals("D")) {
				sec *= Math.pow(Integer.parseInt(ch[i][0]), 2);
			} else {
				sec *= Math.pow(Integer.parseInt(ch[i][0]), 3);
			}

			if (ch[i][2].equals("*")) {
				if (i == 0) {
					sec *= 2;
				} else if (i - 1 >= 0) {
					if (ch[i - 1][2].equals("*") || ch[i - 1][2].equals("#")) {
						sec *= 2;
					}
				} else if (i + 1 < 3) {
					if (ch[i + 1][2].equals("*")) {
						sec *= 2;
					}
				}
			} else if (ch[i][2].equals("#")) {
				sec *= -1;
				if (i + 1 < 3) {
					if (ch[i + 1][2].equals("*")) {
						sec *= 2;
					}
				}
			}

			ans += sec;
		}
		return ans;
	}
}

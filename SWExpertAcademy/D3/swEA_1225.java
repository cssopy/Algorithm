package Algorithm.SWExpertAcademy.D3;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 암호생성기 (D3)
// 어떠한 규칙에 의해 암호가 생성될때 생성된 암호를 구하는 문제
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD
public class swEA_1225 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> q;
		int T = 10;
		
		int tn;
		for(int tc=0; tc<T; tc++) {
			q = new LinkedList<>();
			tn = sc.nextInt();
			for(int i=0; i<8; i++) {
				q.offer(sc.nextInt());
			}
			swea_1225(tn, q);
		}
		sc.close();
	}
	
	public static void swea_1225(int tn, Queue<Integer> q) {
		
		int m = 1;
		while(true) {
			if(q.peek()-m<=0) {
				q.poll();
				q.offer(0);
				break;
			}else {
				q.offer(q.poll()-m++);
			}
			if(m==6)	m=1;
		}
		System.out.print("#"+tn+" ");
		q.forEach(o->{
			System.out.print(o+" ");
		});
	}
}
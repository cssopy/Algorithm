package Algorithm.BAEKJOON.SIVER_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 요세푸스 문제 (실버 5)
// N명의 사람이 원을 둘러 앉아있고 K번째 사람을 제거하고 그 제거된 위치에서 또 반복하여 제거할때 제거되는 순서를 구하는 문제
// https://www.acmicpc.net/problem/1158
public class BJ_1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		System.out.print("<");
		int i = 1;
		while (!q.isEmpty()) {
			if (i++ == K)	{
				if(q.size()==1)	System.out.print(q.poll());
				else			System.out.print(q.poll()+", ");
				i = 1;
				continue;
			}
			
			q.offer(q.poll());
		}
		System.out.print(">");
	}
}

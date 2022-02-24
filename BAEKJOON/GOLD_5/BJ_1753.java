package Algorithm.BAEKJOON.GOLD_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최단경로 (골드 5)
// 시작점으로부터 모든 각 정점으로의 최단 경로를 출력하는 문제
// https://www.acmicpc.net/problem/1753
public class BJ_1753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		// 정점의 개수
		int V = Integer.parseInt(st.nextToken());
		// 간선의 개수
		int E = Integer.parseInt(st.nextToken());
		// 시작점
		int K = Integer.parseInt(br.readLine());

		// 인접리스트
		Node[] adjList = new Node[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			// 시작점
			int from = Integer.parseInt(st.nextToken());
			// 도착점
			int to = Integer.parseInt(st.nextToken());
			// 가중치
			int weight = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, weight, adjList[from]);
		}

		// 시작점으로부터 본인까지의 최소거리
		int[] minDis = new int[V + 1];
		Arrays.fill(minDis, Integer.MAX_VALUE);
		// 방문했는지
		boolean[] isVisited = new boolean[V + 1];
		PriorityQueue<Vertex> pQue = new PriorityQueue<>();

		// 시작점에서 시작점까지 거리
		minDis[K] = 0;
		pQue.offer(new Vertex(K, minDis[K]));

		while (!pQue.isEmpty()) {
			Vertex current = pQue.poll();

			// 꺼낸 정점이 이미 최소비용이 확정된 정점이라면 넘어가기
			if (isVisited[current.no])	continue;
			
			isVisited[current.no] = true;

			// 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용 갱신
			for (Node j = adjList[current.no]; j != null; j = j.link) {
				if (!isVisited[j.to] && minDis[j.to] > minDis[current.no] + j.V) {
					minDis[j.to] = minDis[current.no] + j.V;
					pQue.offer(new Vertex(j.to, minDis[j.to]));
				}
			}
		}

		for (int i = 1; i < V + 1; i++) {
			if (minDis[i] != Integer.MAX_VALUE) {
				sb.append(minDis[i] + "\n");
			} else {
				sb.append("INF\n");
			}
		}

		System.out.println(sb.toString());
	}

	static class Node {
		int to;
		int V;
		Node link;

		public Node(int to, int v, Node link) {
			super();
			this.to = to;
			V = v;
			this.link = link;
		}
	}
	
	static class Vertex implements Comparable<Vertex> {
		// 정점번호, 출발지에서 자신으로의 최소비용
		int no, minDis;

		public Vertex(int no, int minDis) {
			super();
			this.no = no;
			this.minDis = minDis;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minDis - o.minDis;
		}
	}
}

package Algorithm.BAEKJOON.BRONZE_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

//수 정렬하기
//N개의 수가 주어졌을 때, 이를 오름차순으로 정렬
//https://www.acmicpc.net/problem/2750
public class BJ_2750 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 숫자의 수
		int N = Integer.parseInt(br.readLine());
		
		// 오름차순
		Comparator<Integer> comparator = (s1, s2) -> s1.compareTo(s2);
		Map<Integer, Integer> map = new TreeMap(comparator);
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(map.containsKey(n)) {
				int v = map.get(n);
				
				map.put(n, v+1);
			}else {
				map.put(n, 1);
			}
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			for(int i=0; i<entry.getValue(); i++) {
				sb.append(entry.getKey());
				sb.append("\n");
			}
        }
		
		System.out.println(sb.toString());
	}

}

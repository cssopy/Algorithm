import java.util.*;
import java.util.stream.Collectors;

public class lv3_베스트앨범 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[][] genres = {
                {"classic", "pop", "classic", "classic", "pop"}
        };
        int[][] plays = {
                {500, 600, 150, 800, 2500}
        };

        for (int i = 0; i < genres.length; i++) {
            int[] r = solution(genres[i], plays[i]);

            for (int j = 0; j < r.length; j++) {
                result.append(r[j]).append(' ');
            }
            result.append('\n');
        }

        System.out.println(result);
    }

    public static int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생횟수
        HashMap<String, Integer> map = new HashMap<>();
        // 장르별 고유번호 및 재생횟수
        HashMap<String, PriorityQueue<int[]>> map2 = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.get(genres[i]) == null ? plays[i] : map.get(genres[i]) + plays[i]);

            if (map2.get(genres[i]) == null) {
                map2.put(genres[i], new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]));
                map2.get(genres[i]).add(new int[]{i, plays[i]});
            } else {
                map2.get(genres[i]).add(new int[]{i, plays[i]});
            }
        }

        // map을 총재생횟수 기준 내림차순으로 정렬
        List<Map.Entry<String, Integer>> entries = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).collect(Collectors.toList());
        List<Integer> ans = new ArrayList<>();
        // 총 재생횟수가 높은 장르부터 재생횟수가 높은 노래별로 앞 2개씩 ans 리스트에 추가
        for (Map.Entry<String, Integer> entry : entries) {
            PriorityQueue<int[]> pq = map2.get(entry.getKey());
            for (int i = 0; i < 2; i++) {
                if(!pq.isEmpty()){
                    ans.add(pq.poll()[0]);
                }
            }
        }

        return ans.stream().mapToInt(v -> v).toArray();
    }
}

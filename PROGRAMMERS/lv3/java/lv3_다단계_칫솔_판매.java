import java.util.HashMap;
import java.util.Map;

public class lv3_다단계_칫솔_판매 {
    public static void main(String[] args) {
        Inp[] inps = {
                new Inp(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}, new String[]{"young", "john", "tod", "emily", "mary"}, new int[]{12, 4, 2, 5, 10}),
                new Inp(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}, new String[]{"sam", "emily", "jaimie", "edward"}, new int[]{2, 3, 5, 4})
        };

        for (Inp inp : inps) {
            int[] answer = solution(inp.enroll, inp.referral, inp.seller, inp.amount);
            for (int v : answer) {
                System.out.print(String.format("%d ", v));
            }
            System.out.println();
        }
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 사람 이름별 인덱스
        Map<String, Integer> map = new HashMap<>();
        map.put("-", enroll.length);
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], i);
        }

        // 각 판매자의 조직에 참여시긴 사람의 인덱스
        int[] parent = new int[enroll.length + 1];
        for (int i = 0; i < referral.length; i++) {
            parent[i] = map.get(referral[i]);
        }

        // 각 판매자별 총 발생이익
        int[] answer = new int[enroll.length];
        for (int i = 0; i < seller.length; i++) {
            dfs(parent, map.get(seller[i]), amount[i] * 100, answer);
        }

        return answer;
    }

    static void dfs(int[] parent, int seller, int money, int[] answer) {
        // 현재 판매자가 center면 return
        if (seller == parent.length - 1) return;

        // 발생 이익이 0원이면 return
        if (money == 0) return;

        // 발생이익의 90%
        answer[seller] += money - money / 10;

        dfs(parent, parent[seller], money / 10, answer);
    }

    static class Inp {
        String[] enroll;
        String[] referral;
        String[] seller;
        int[] amount;

        Inp(String[] enroll, String[] referral, String[] seller, int[] amount) {
            this.enroll = enroll;
            this.referral = referral;
            this.seller = seller;
            this.amount = amount;
        }
    }
}

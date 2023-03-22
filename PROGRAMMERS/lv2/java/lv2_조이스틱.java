public class lv2_조이스틱 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[] inps = {
                "JEROEN",
                "JAN",
                "AAAAABBAAAAAAABAAA",
                "BBBBAAAAAB"
        };

        for (String inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(String name) {
        int ans = 0, ml = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            // 상하 조작 횟수
            ans += updown(name.charAt(i));

            // i위치에서 A가아닌 다음 단어의 위치 찾음
            int na = i + 1;
            while (na < name.length() && name.charAt(na) == 'A') na++;

            // i위치마다 정순, 역순중 최소이동값을 계산하며 최소 이동횟수를 구함
            ml = Math.min(ml, i + name.length() - na + Math.min(i, name.length() - na));
        }
        // 최종적으로 구한 최소 이동횟수 더함
        ans += ml;

        return ans;
    }

    public static int updown(char c) {
        return Math.min(c - 'A', 'Z' - c + 1);
    }
}

import java.util.HashSet;
import java.util.Set;

public class lv3_불량_사용자 {
    static void findBannedId(String[] user_id, String[] banned_id, boolean[] isSelected, int bannedIndex, Set<String> bannedCases) {
        // 제재되는 사용자들을 모두 구했다면
        // 제재되는 사용자들의 인덱스를 이어 붙여 bannedCases에 삽입
        if (bannedIndex == banned_id.length) {
            String bc = "";
            for (int i = 0; i < isSelected.length; i++) {
                if (isSelected[i]) bc += i + " ";
            }
            bannedCases.add(bc);
            return;
        }

        // 유저 목록에서 아직 선택되지 않았고 비교하여 제재 아이디가 될 가능성이 있는 아이디면 해당 아이디를 제재 아이디로 간주
        for (int i = 0; i < user_id.length; i++) {
            if (!isSelected[i] && isPossible(user_id[i], banned_id[bannedIndex])) {
                isSelected[i] = true;
                findBannedId(user_id, banned_id, isSelected, bannedIndex + 1, bannedCases);
                isSelected[i] = false;
            }
        }
    }

    // 두 문자열이 같을 가능성이 있는지 판단
    static boolean isPossible(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == '*' || str2.charAt(i) == '*') continue;
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public int solution(String[] user_id, String[] banned_id) {
        // 제재 되는 경우들, 중복 방지를 위해 Set사용
        Set<String> bannedCases = new HashSet<>();
        findBannedId(user_id, banned_id, new boolean[user_id.length], 0, bannedCases);

        return bannedCases.size();
    }
}

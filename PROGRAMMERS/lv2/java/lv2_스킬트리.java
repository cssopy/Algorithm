import java.util.HashSet;
import java.util.Set;

public class lv2_스킬트리 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"})
        };

        for (Inp inp : inps) {
            result.append(solution(inp.skill, inp.skill_trees)).append('\n');
        }

        System.out.println(result);
    }

    public static int solution(String skill, String[] skill_trees) {
        // 선행 스킬 순서에 해당하는 스킬들
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < skill.length(); i++) {
            set.add(skill.charAt(i));
        }

        // 가능한 스킬트리 개수, 선행 스킬 순서
        int ans = 0, ski;
        for (String skill_tree : skill_trees) {
            ski = 0;
            // 해당 스킬트리가 가능한지 여부
            boolean f = true;
            for (int i = 0; i < skill_tree.length(); i++) {
                char sk = skill_tree.charAt(i);

                // 해당 스킬이 선행 스킬에 속하는지
                if (set.contains(sk)) {
                    // 해당 스킬이 선행 스킬 순서상 맞는 순서인지
                    if (sk == skill.charAt(ski)) {
                        // 올바른 순서의 스킬이 맞다면 다음 선행 스킬을 가리킴
                        ski++;
                        continue;
                    }
                    f = false;
                }
            }

            if (f) ans++;
        }

        return ans;
    }

    static class Inp {
        String skill;
        String[] skill_trees;

        Inp(String skill, String[] skill_trees) {
            this.skill = skill;
            this.skill_trees = skill_trees;
        }
    }
}

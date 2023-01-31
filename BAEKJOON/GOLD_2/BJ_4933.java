import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_4933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        // 테스트케이스
        int T = Integer.parseInt(br.readLine());
        // 포스트오더로 주어진 입력으로 각각의 트리를 만듦
        for (int i = 0; i < T; i++) {
            int[] tree1 = makeTree(br.readLine().split(" "));
            int[] tree2 = makeTree(br.readLine().split(" "));

            result.append(compareTrees(tree1, tree2)).append('\n');
        }

        System.out.print(result);
    }

    // 두 트리의 각 노드의 부모 노드가 모두 동일하다면 true 반환
    public static boolean compareTrees(int[] tree1, int[] tree2) {
        for (int i = 0; i < 26; i++) {
            if (tree1[i] != tree2[i]) {
                return false;
            }
        }
        return true;
    }

    // 트리의 각 노드의 부모 노드가 무엇인지 만드는 함수
    public static int[] makeTree(String[] inps) {
        int[] tree = new int[26];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < inps.length - 1; i++) {
            // nil이면 -1 알파벳이면 0~25로 표현
            int c = inps[i].equals("nil") ? -1 : inps[i].charAt(0) - 'A';

            // 알파벳이고 스택에 2개이상 있다면 스택에 있는 알파벳의 부모를 결정
            if (c != -1 && stack.size() >= 2) {
                for (int j = 0; j < 2; j++) {
                    int cc = stack.pop();
                    if (cc == -1) {
                        continue;
                    }
                    tree[cc] = c;
                }
            }
            stack.add(c);
        }
        // 마지막 남은 루트노드의 부모는 자기 자신으로 처리
        int pop = stack.pop();
        tree[pop] = pop;

        return tree;
    }
}

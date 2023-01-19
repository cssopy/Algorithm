import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        // 노드의 개수
        int N = Integer.parseInt(br.readLine());

        // 부모와 자식정보를 저장할 노드배열선언
        Node[] tree = new Node[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new Node();
        }

        // 노드 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            tree[p].left = l == -1 ? 0 : l;
            tree[p].right = r == -1 ? 0 : r;
            tree[l == -1 ? 0 : l].parent = p;
            tree[r == -1 ? 0 : r].parent = p;
        }

        // 루트노드 찾기
        int root = findRoot(tree);

        // 깊이마다 제일 왼쪽 노드와 제일 오른쪽 노드를 저장할 배열
        int[][] dw = new int[N + 1][2];
        for (int i = 0; i < dw.length; i++) {
            dw[i][0] = N;
        }
        // 노드마다 위치를 부여하기 위한 인덱스
        int[] w = {1};
        // 중위순회
        inorder(tree, root, dw, w, 1);

        // 정답 깊이와 너비를 저장할 배열
        int[] ans = new int[2];
        for (int i = 1; i < dw.length; i++) {
            if (dw[i][1] == 0) {
                break;
            }

            if (ans[1] < dw[i][1] - dw[i][0] + 1) {
                ans[0] = i;
                ans[1] = dw[i][1] - dw[i][0] + 1;
            }
        }

        result.append(ans[0] + " " + ans[1]);
        System.out.println(result);
    }

    // 부모가 없으면 해당 노드가 루트노드
    public static int findRoot(Node[] tree) {
        for (int i = 1; i < tree.length; i++) {
            if (tree[i].parent == 0) {
                return i;
            }
        }
        return 0;
    }

    public static void inorder(Node[] tree, int crt, int[][] dw, int[] w, int depth) {
        if (crt == 0) {
            return;
        }

        inorder(tree, tree[crt].left, dw, w, depth + 1);
        dw[depth][0] = Math.min(dw[depth][0], w[0]);
        dw[depth][1] = Math.max(dw[depth][1], w[0]++);
        inorder(tree, tree[crt].right, dw, w, depth + 1);
    }

    public static class Node {
        int parent;
        int left, right;
    }
}

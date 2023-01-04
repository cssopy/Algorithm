import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        Node root = null;

        // 노드의 개수
        int N = Integer.parseInt(br.readLine());
        for(int nc=0; nc<N; nc++){
            st = new StringTokenizer(br.readLine());

            if(nc==0){
                root = new Node(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
            }else{
                root.insert(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
            }
        }

        preSearch(root, result);
        result.append('\n');
        inSearch(root, result);
        result.append('\n');
        postSearch(root, result);

        System.out.println(result);
    }

    // 전위
    public static void preSearch(Node node, StringBuilder result){
        if(node == null){
            return;
        }

        result.append(node.value);
        preSearch(node.n1, result);
        preSearch(node.n2, result);
    }

    // 중위
    public static void inSearch(Node node, StringBuilder result){
        if(node == null){
            return;
        }

        inSearch(node.n1, result);
        result.append(node.value);
        inSearch(node.n2, result);
    }

    // 후위
    public static void postSearch(Node node, StringBuilder result){
        if(node == null){
            return;
        }

        postSearch(node.n1, result);
        postSearch(node.n2, result);
        result.append(node.value);
    }

    public static class Node {
        char value;
        Node n1;
        Node n2;

        Node(char value){
            this.value = value;
        }

        Node(char value, char l, char r){
            this.value = value;
            this.n1 = l=='.'?null:new Node(l);
            this.n2 = r=='.'?null:new Node(r);
        }

        // 재귀 형태
        // p가 현재 노드라면 왼쪽 오른쪽 자식 알맞게 생성
        // p가 현재 노드가 아니라면 왼쪽, 오른쪽 자식으로 또다시 들어가는 형태로 탐색
        void insert(char p, char l, char r){
            if(this.value == p){
                if(l != '.'){
                    this.n1 = new Node(l);
                }
                if(r != '.'){
                    this.n2 = new Node(r);
                }
            }else{
                if(this.n1 != null){
                    this.n1.insert(p, l, r);
                }
                if(this.n2 != null){
                    this.n2.insert(p, l, r);
                }
            }
        }
    }
}

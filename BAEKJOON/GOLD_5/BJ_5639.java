import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        // 루트 노드
        Node root = null;

        int i = 0;
        // 입력 및 노드 삽입
        while(true){
            int s;
            try{
                s = Integer.parseInt(br.readLine());
            }catch (Exception e){
                break;
            }

            if(i++==0){
                root = new Node(s);
            }else{
                root.insert(s);
            }
        }

        // 후위순회
        preSearch(root, result);

        System.out.println(result);
    }

    public static void preSearch(Node n, StringBuilder result){
        if(n == null){
            return;
        }

        preSearch(n.n1, result);
        preSearch(n.n2, result);
        result.append(n.value).append('\n');
    }

    public static class Node {
        int value;
        Node n1;
        Node n2;

        Node(int value){
            this.value = value;
        }

        // 들어온 값과 현재 노드의 값을 비교하고 현재 노드의 자식 여부에 따라 새롭게 자식을 만드거나 재귀를 통해 자식으로 들어가 다시 수행
        void insert(int value){
            if(value < this.value){
                if(this.n1 == null){
                    this.n1 = new Node(value);
                }else{
                    this.n1.insert(value);
                }
            }else{
                if(this.n2 == null){
                    this.n2 = new Node(value);
                }else{
                    this.n2.insert(value);
                }
            }
        }
    }
}
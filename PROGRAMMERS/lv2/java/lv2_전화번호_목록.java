import java.util.Arrays;

public class lv2_전화번호_목록 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[][] inps = {
                {"119", "97674223", "1195524421"},
                {"123", "456", "789"},
                {"12", "123", "1235", "567", "88"}
        };

        for (String[] inp : inps) {
            result.append(solution(inp)).append('\n');
        }

        System.out.print(result);
    }

    public static boolean solution(String[] phone_book) {
        // 사전순 정렬
        Arrays.sort(phone_book);

        // 사전순으로 정렬했기 때문에 인덱스가 1차이 나는 것끼리만 비교하면 됨
        for (int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }

        return true;
    }
}

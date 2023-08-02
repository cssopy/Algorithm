import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_1283 {
    public static void main(String[] args) {
        int N;
        Set<Character> set = new HashSet<>();
        try (Scanner sc = new Scanner(System.in)) {
            N = Integer.parseInt(sc.nextLine());

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < N; i++) {
                String[] inps = sc.nextLine().split(" ");

                // 첫바퀴 처리
                boolean f = false;
                StringBuilder temp = new StringBuilder();
                for (String inp : inps) {
                    if (f == false && set.contains(Character.toUpperCase(inp.charAt(0))) == false) {
                        temp.append('[').append(inp.charAt(0)).append(']');
                        if (inp.length() != 1) {
                            temp.append(inp.substring(1));
                        }

                        f = true;
                        set.add(Character.toUpperCase(inp.charAt(0)));
                        break;
                    } else {
                        temp.append(inp);
                    }
                    temp.append(' ');
                }
                if(f == true){
                    result.append(temp);
                }

                temp = new StringBuilder();
                // 첫바퀴에 못 찾았으면
                if (f == false) {
                    for (String inp : inps) {
                        if (f == false) {
                            for (int j = 0; j < inp.length(); j++) {
                                if (set.contains(Character.toUpperCase(inp.charAt(j))) == false) {
                                    temp.append('[').append(inp.charAt(j)).append(']');
                                    if (j != inp.length() - 1) {
                                        temp.append(inp.substring(j + 1));
                                    }

                                    f = true;
                                    set.add(Character.toUpperCase(inp.charAt(j)));
                                    break;
                                }
                                temp.append(inp.charAt(j));
                            }
                        } else {
                            temp.append(inp);
                        }
                        temp.append(' ');
                    }

                    if(f){
                        result.append(temp);
                    }
                }

                result.append('\n');
            }

            System.out.print(result);
        }
    }
}

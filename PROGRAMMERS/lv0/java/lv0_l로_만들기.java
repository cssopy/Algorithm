public class lv0_l로_만들기 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        String[] inps = {
                "abcdevwxyz",
                "jjnnllkkmm"
        };

        for (String inp : inps) {
            result.append(String.format("%s\n", solution(inp)));
        }

        System.out.println(result);
    }

    public static String solution(String myString) {
        char[] myChars = myString.toCharArray();
        for (int i = 0; i < myChars.length; i++) {
            char c = myChars[i];

            if (c < 'l') {
                myChars[i] = 'l';
            }
        }
        return String.valueOf(myChars);
    }
}

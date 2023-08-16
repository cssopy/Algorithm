public class BJ_4673 {
    public static void main(String[] args) {
        boolean[] isNotSelfNum = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            int genNum = getGenNum(i);
            if (genNum <= 10000) {
                isNotSelfNum[getGenNum(i)] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if (isNotSelfNum[i] == false) {
                sb.append(i).append('\n');
            }
        }

        System.out.print(sb);
    }

    static int getGenNum(int n) {
        int genNum = n;
        while (n != 0) {
            genNum += n % 10;
            n /= 10;
        }
        return genNum;
    }
}

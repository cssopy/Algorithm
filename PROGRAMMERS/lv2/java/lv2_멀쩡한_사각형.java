import java.math.BigInteger;

public class lv2_멀쩡한_사각형 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Inp[] inps = {
                new Inp(8, 12),
                new Inp(5, 13)
        };

        for (Inp inp : inps) {
            result.append(String.format("%d\n", solution(inp.W, inp.H)));
        }

        System.out.println(result);
    }

    public static long solution(int w, int h) {
        int gcd = getGCD(w, h);
        int mw = w / gcd;
        int mh = h / gcd;

        // 절단되는 사각형의 개수
        int notSquare = mw + mh - 1;
//        int notSquare = w + h - gcd;

        return (long) w * h - notSquare * gcd;
    }

    static int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }

    static class Inp {
        int W, H;

        Inp(int W, int H) {
            this.W = W;
            this.H = H;
        }
    }
}

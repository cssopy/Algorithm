import java.util.Scanner;

public class BJ_20546 {
    public static void main(String[] args) {
        int money;
        int[] stocks = new int[14];
        try (Scanner sc = new Scanner(System.in)) {
            money = sc.nextInt();
            for (int i = 0; i < 14; i++) {
                stocks[i] = sc.nextInt();
            }
        }

        Stock jh = new Stock(money, 0);
        Stock sm = new Stock(money, 0);
        for (int i = 0; i < stocks.length; i++) {
            int stock = stocks[i];

            // 준현이의 전략
            if (jh.money >= stock) {
                jh.num += jh.money / stock;
                jh.money = jh.money % stock;
            }

            // 성민이의 전략
            // 3일째 상승
            if (i >= 3 && stocks[i - 3] < stocks[i - 2] && stocks[i - 2] < stocks[i - 1] && stocks[i - 1] < stocks[i]) {
                sm.money += stock * sm.num;
                sm.num = 0;
            }
            // 3일째 하락
            if (i >= 3 && stocks[i - 3] > stocks[i - 2] && stocks[i - 2] > stocks[i - 1] && stocks[i - 1] > stocks[i]) {
                sm.num += sm.money / stock;
                sm.money = sm.money % stock;
            }
        }

        if (getAsset(jh, stocks) > getAsset(sm, stocks)) {
            System.out.println("BNP");
        } else if (getAsset(jh, stocks) < getAsset(sm, stocks)) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    static int getAsset(Stock st, int[] stocks) {
        return st.money + st.num * stocks[stocks.length - 1];
    }

    static class Stock {
        int money;
        int num;

        Stock(int money, int num) {
            this.money = money;
            this.num = num;
        }
    }
}

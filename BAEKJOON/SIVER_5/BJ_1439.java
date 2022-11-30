package Algorithm.BAEKJOON.SIVER_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        new StringBuffer();
        String S = br.readLine();
        int on = 0;
        int zn = 0;
        char cc = '2';

        for(int i = 0; i < S.length(); ++i) {
            if (cc != S.charAt(i)) {
                cc = S.charAt(i);
                if (S.charAt(i) == '0') {
                    ++on;
                } else if (S.charAt(i) == '1') {
                    ++zn;
                }
            }
        }

        System.out.println(on < zn ? on : zn);
    }
}
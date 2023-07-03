import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BJ_20436 {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 각 키의 좌표 및 눌러야 하는 손가락 정의
        Map<Character, Point> map = new HashMap<>();
        map.put('q', new Point(0, 0, 0));
        map.put('w', new Point(0, 1, 0));
        map.put('e', new Point(0, 2, 0));
        map.put('r', new Point(0, 3, 0));
        map.put('t', new Point(0, 4, 0));
        map.put('a', new Point(1, 0, 0));
        map.put('s', new Point(1, 1, 0));
        map.put('d', new Point(1, 2, 0));
        map.put('f', new Point(1, 3, 0));
        map.put('g', new Point(1, 4, 0));
        map.put('z', new Point(2, 0, 0));
        map.put('x', new Point(2, 1, 0));
        map.put('c', new Point(2, 2, 0));
        map.put('v', new Point(2, 3, 0));
        map.put('y', new Point(0, 5, 1));
        map.put('u', new Point(0, 6, 1));
        map.put('i', new Point(0, 7, 1));
        map.put('o', new Point(0, 8, 1));
        map.put('p', new Point(0, 9, 1));
        map.put('h', new Point(1, 5, 1));
        map.put('j', new Point(1, 6, 1));
        map.put('k', new Point(1, 7, 1));
        map.put('l', new Point(1, 8, 1));
        map.put('b', new Point(2, 4, 1));
        map.put('n', new Point(2, 5, 1));
        map.put('m', new Point(2, 6, 1));

        // 왼, 오른 손가락 위치
        Point lp, rp;
        char[] s;
        try (Scanner sc = new Scanner(System.in)) {
            lp = map.get(sc.next().charAt(0)).clone();
            rp = map.get(sc.next().charAt(0)).clone();
            s = sc.next().toCharArray();
        }

        int answer = 0;
        for (char c : s) {
            Point np = map.get(c);
            // 해당 키가 어느 손가락으로 눌러야 하는지 판단하여 answer에 손가락 이동시간과 누르는 시간을 더해줌
            if (np.type == 0) {
                answer += lp.getDistance(np) + 1;
                lp = np.clone();
            } else {
                answer += rp.getDistance(np) + 1;
                rp = np.clone();
            }
        }

        System.out.println(answer);
    }

    static class Point {
        int x, y;
        int type;

        Point(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        @Override
        protected Point clone() {
            return new Point(this.x, this.y, this.type);
        }

        int getDistance(Point op) {
            return Math.abs(this.x - op.x) + Math.abs(this.y - op.y);
        }
    }
}

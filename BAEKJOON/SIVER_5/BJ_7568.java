import java.util.Scanner;

public class BJ_7568 {
    public static void main(String[] args) {
        int N;
        Person[] people;

        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt();

            people = new Person[N];
            for (int i = 0; i < N; i++) {
                // 각 사람마다 체중, 키, 인덱스를 저장
                people[i] = new Person(sc.nextInt(), sc.nextInt(), i, 0);
            }
        }

        int[] result = solution(N, people);
        StringBuilder answer = new StringBuilder();
        for (int v : result) {
            answer.append(v).append(' ');
        }

        System.out.println(answer);
    }

    private static int[] solution(int N, Person[] people) {
        int[] result = new int[N];

        // 완전탐색으로 각 사람마다 덩치가 더 큰 사람의 수를 카운트
        for (int i = 0; i < people.length; i++) {
            int c = 0;
            for (int j = 0; j < people.length; j++) {
                if (people[i].x < people[j].x && people[i].y < people[j].y) c++;
            }
            people[i].c = c;
        }

        // 덩치큰 사람의 수에 따라 등수를 결정
        for (int i = 0; i < people.length; i++) {
            result[people[i].i] = people[i].c + 1;
        }

        return result;
    }

    static class Person {
        int x, y;
        int i, c;

        Person(int x, int y, int i, int c) {
            this.x = x;
            this.y = y;
            this.i = i;
            this.c = c;
        }
    }
}

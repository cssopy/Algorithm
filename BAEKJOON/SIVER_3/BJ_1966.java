package BAEKJOON.SIVER_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 문서 개수
            int N = Integer.parseInt(st.nextToken());
            // 몇 번째
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            // 숫자들 카운트 하기 위한 배열
            int[] arr = new int[10];
            // 문서정보(인덱스와 값)를 리스트 형태로 저장
            ArrayList<DocuInfo> docuInfos = new ArrayList<>();
            for (int nc = 0; nc < N; nc++) {
                int v = Integer.parseInt(st.nextToken());
                arr[v]++;
                docuInfos.add(new DocuInfo(nc, v));
            }

            // 카운트한 숫자들 큰 수부터 확인하기 위해 스택 사용
            int top = -1;
            VNum[] vNums = new VNum[9];
            for (int i = 1; i <= 9; i++) {
                if (arr[i] != 0) {
                    vNums[++top] = new VNum(i, arr[i]);
                }
            }

            // 나오는 순서
            int od = 1;
            while (true) {
                DocuInfo docuInfo = docuInfos.get(0);

                // 리스트의 첫번째 문서가 내가 찾던 문서이고 현재 문서 중 제일 값이 큰 문서라면 꺼내고 종료
                if (docuInfo.index == M && docuInfo.value == vNums[top].value) {
                    result.append(od).append('\n');
                    break;
                }

                // 리스트의 첫번째 문서가 내가 찾던 문서가 아니고 현재 문서 중 제일 값이 큰 문서라면 꺼냄
                if (docuInfo.value == vNums[top].value) {
                    docuInfos.remove(0);
                    if (--vNums[top].count == 0) {
                        top--;
                    }
                    od++;
                }
                // 이도 저도 아니면 리스트 맨뒤로 다시 넣음
                else {
                    docuInfos.remove(0);
                    docuInfos.add(docuInfo);
                }
            }
        }

        System.out.println(result);
    }

    public static class DocuInfo {
        int index;
        int value;

        public DocuInfo(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static class VNum {
        int value;
        int count;

        public VNum(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}

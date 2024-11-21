import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] ints = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }


        // 누적합 배열 생성
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + ints[i - 1];
        }

        // 최대합 계산
        int maxSum = Integer.MIN_VALUE;
        int minPrefix = Integer.MAX_VALUE;

        for (int i = k; i <= n; i++) {
            // 최소 k개의 원소를 포함한 구간합 계산
            minPrefix = Math.min(minPrefix, prefix[i - k]);
            maxSum = Math.max(maxSum, prefix[i] - minPrefix);
        }

        // 결과 출력
        System.out.println(maxSum);

    }
}
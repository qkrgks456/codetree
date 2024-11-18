

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        // 그냥 증가 연속을 구하면 끝이었다 ~
        int[] dp = new int[n];
        dp[0] = 1;
        int max = ints[0];
        int maxResult = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (max > ints[i]) {
                max = ints[i];
                dp[i] = 1;
            } else {
                max = ints[i];
                dp[i] = dp[i - 1] + 1;
            }
            maxResult = Math.max(maxResult, dp[i]);
        }
        // 감소 연속
        int min = ints[0];
        int minResult = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (min < ints[i]) {
                min = ints[i];
                dp[i] = 1;
            } else {
                min = ints[i];
                dp[i] = dp[i - 1] + 1;
            }
            minResult = Math.max(minResult, dp[i]);
        }
        System.out.println(Math.max(maxResult, minResult));


        // 일단 순수 DP로 간다.
        // n^2 시간초과 ㅅㄱㅇ
        /*dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (ints[i] > ints[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }*/


    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] ints = new int[2][n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[0][i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[1][i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[2][n];
        dp[0][0] = ints[0][0];
        dp[1][0] = ints[1][0];
        dp[0][1] = ints[1][0] + ints[0][1];
        dp[1][1] = ints[0][0] + ints[1][1];
        for (int i = 2; i < n; i++) {
            dp[0][i] = Math.max(dp[1][i - 1] + ints[0][i], Math.max(dp[0][i - 2] + ints[0][i], dp[1][i - 2] + ints[0][i]));
            dp[1][i] = Math.max(dp[0][i - 1] + ints[1][i], Math.max(dp[0][i - 2] + ints[1][i], dp[1][i - 2] + ints[1][i]));
        }

        System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));


    }
}
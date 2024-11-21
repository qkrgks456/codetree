import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n][n];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) break;
                if (dp[i][j] == 0) continue;
                // 오른쪽
                if (j + ints[i][j] < n) {
                    dp[i][j + ints[i][j]] = dp[i][j + ints[i][j]] + 1;
                }
                // 아래쪽
                if (i + ints[i][j] < n) {
                    dp[i + ints[i][j]][j] = dp[i + ints[i][j]][j] + 1;
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}
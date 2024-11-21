import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 하 이런문제는 좀 자제했으면 좋겠네요.
        // 이건 잘하는 사람도 저 규칙성 찾기 엄청 힘들겠네
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int i = 4; i <= n; i++) {
            // 1이 끝에 있을때
            dp[i][1] = ((dp[i - 1][2] % 1000000007) + (dp[i - 1][3] % 1000000007)) % 1000000007;
            // 2가 끝에 있을때
            dp[i][2] = ((dp[i - 2][1] % 1000000007) + (dp[i - 2][3] % 1000000007)) % 1000000007;
            // 3이 끝에 있을때
            dp[i][3] = ((dp[i - 3][1] % 1000000007) + (dp[i - 3][2] % 1000000007)) % 1000000007;
        }
        System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % 1000000007);
    }
}
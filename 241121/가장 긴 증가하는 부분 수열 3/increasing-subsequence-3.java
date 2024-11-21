import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            ints[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        int result = 0;
        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(ints[i] > ints[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    result = Math.max(dp[i],result);
                }
            }
        }
        System.out.println(result);
    }
}
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


        // 누적합이 필요하네 빼줘야 되니까 아하
        int[] prefix = new int[n];
        int max = ints[0];
        prefix[0] = ints[0];
        for (int i = 1; i < n; i++) {
            prefix[i] += prefix[i - 1] + ints[i];
            max = Math.max(prefix[i], max);
        }
        if (k == 1) {
            System.out.println(max);
            return;
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            result += ints[i];
        }
        int start = 0;
        for (int i = k; i < n; i++) {
            result = Math.max(result, prefix[i] - prefix[start]);
            start++;
        }
        System.out.println(result);

    }
}
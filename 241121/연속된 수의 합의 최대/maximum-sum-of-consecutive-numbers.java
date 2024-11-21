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
        prefix[0] = ints[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + ints[i];
        }
        if (k == 1) {
            System.out.println(prefix[prefix.length - 1]);
            return;
        }

        int result = prefix[k - 1];
        for (int i = k; i < n; i++) {
            // 최대값 갱신
            result = Math.max(result, prefix[i] - prefix[i - k]);
        }
        System.out.println(result);

    }
}
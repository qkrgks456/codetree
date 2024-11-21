

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


        int result = 0;
        int sum = 0;
        int start = 0;
        // k까지 먼저 섬을 구합시다.
        for (int i = 0; i < k; i++) {
            result += ints[i];
            sum += ints[i];
        }
        for (int i = k; i < n; i++) {
            if (k != 1) {
                sum -= ints[start];
                start++;
            }
            sum += ints[i];
            result = Math.max(sum, result);

        }
        System.out.println(result);

    }
}
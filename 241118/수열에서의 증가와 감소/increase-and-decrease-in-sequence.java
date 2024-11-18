

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        // 이분탐색을 배워왔다 해보자 이거야
        List<Integer> dp = new ArrayList<>();
        dp.add(ints[0]);
        int current = 0;
        for (int i = 1; i < n; i++) {
            int target = ints[i];
            if (dp.get(current) <= target) {
                dp.add(target);
                current++;
                continue;
            }
            int left = 0;
            int right = dp.size() - 1;
            int maxIdx = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (dp.get(mid) <= target) {
                    left = mid + 1;
                    maxIdx = Math.max(mid, maxIdx);
                } else {
                    right = mid - 1;
                }
            }
            dp.set(maxIdx, ints[i]);
        }
        System.out.println(dp.size());

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
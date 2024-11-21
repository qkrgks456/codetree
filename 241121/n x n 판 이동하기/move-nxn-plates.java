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
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        boolean check = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.x == n - 1 && point.y == n - 1) {
                    check = true;
                    continue;
                }
                int x = point.x;
                int y = point.y;
                // 오른쪽
                if (y + ints[x][y] < n) {
                    dp[x][y + ints[x][y]] = dp[x][y + ints[x][y]] + 1;
                    queue.add(new Point(x, y + ints[x][y]));
                }
                // 아래쪽
                if (x + ints[x][y] < n) {
                    dp[x + ints[x][y]][y] = dp[x + ints[x][y]][y] + 1;
                    queue.add(new Point(x + ints[x][y], y));
                }
            }
            if (check) break;
        }

        System.out.println(dp[n - 1][n - 1]);


    }
}
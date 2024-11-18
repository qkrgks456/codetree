import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] color = new int[n][m];
        int colorCount = 0;
        Point start = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
                if (color[i][j] == 1) {
                    start = new Point(i, j);
                    colorCount++;
                }
            }
        }
        int left = 0;
        int right = 1000000000;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (BFS(ints, color, mid, start, colorCount - 1)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    public static boolean BFS(int[][] ints, int[][] color, int mid, Point start, int colorCount) {
        int[] nx = {1, -1, 0, 0};
        int[] ny = {0, 0, 1, -1};
        int[][] check = new int[ints.length][ints[0].length];
        int count = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        check[start.x][start.y] = 1;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dx = point.x + nx[i];
                int dy = point.y + ny[i];
                if (dx >= 0 && dy >= 0 && dx < ints.length && dy < ints[0].length && check[dx][dy] == 0) {
                    if (mid >= Math.abs(ints[point.x][point.y] - ints[dx][dy])) {
                        if (color[dx][dy] == 1) count++;
                        check[dx][dy] = 1;
                        queue.add(new Point(dx, dy));
                    }
                }
            }
        }
        return colorCount == count;
    }
}
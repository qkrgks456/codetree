

import java.util.*;
import java.util.List;
import java.io.*;
import java.awt.*;


public class Main {
    static int[][] markArray;
    static char[][] chars;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        chars = new char[n][m];
        markArray = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] stone = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                chars[i][j] = stone[j];
            }
        }
        marking();
        int n1 = distance(1, 2);
        int n2 = distance(2, 3);
        int n3 = distance(1, 3);
        System.out.println(Math.min(n1 + n2, Math.min(n1 + n3, n2 + n3)));


    }

    public static void marking() {
        int mark = 1;
        for (int i = 0; i < markArray.length; i++) {
            for (int j = 0; j < markArray[0].length; j++) {
                if (chars[i][j] != '.' && markArray[i][j] == 0) {
                    BFS(i, j, mark);
                    mark++;
                }
            }
        }
    }

    public static int distance(int start, int end) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (markArray[i][j] == start) {
                    int dis = disBFS(i, j, start, end);
                    if (dis < 0) continue;
                    result = Math.min(result, dis);
                }
            }
        }
        return result;
    }

    public static int disBFS(int x, int y, int start, int end) {
        int[] nx = {-1, 1, 0, 0};
        int[] ny = {0, 0, 1, -1};
        int[][] dis = new int[markArray.length][markArray[0].length];
        int[][] check = new int[markArray.length][markArray[0].length];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        dis[x][y] = 1;
        check[x][y] = 1;
        int result = 0;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (markArray[point.x][point.y] == end) {
                result = dis[point.x][point.y];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int dx = point.x + nx[i];
                int dy = point.y + ny[i];
                if (dx >= 0 && dy >= 0 && dx < markArray.length && dy < markArray[0].length && check[dx][dy] == 0 && markArray[dx][dy] != start) {
                    dis[dx][dy] = dis[point.x][point.y] + 1;
                    check[dx][dy] = 1;
                    queue.add(new Point(dx, dy));
                }
            }
        }
        return result - 2;
    }

    public static void BFS(int x, int y, int mark) {
        int[] nx = {-1, 1, 0, 0};
        int[] ny = {0, 0, 1, -1};
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        markArray[x][y] = mark;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dx = point.x + nx[i];
                int dy = point.y + ny[i];
                if (dx >= 0 && dy >= 0 && dx < markArray.length && dy < markArray[0].length
                        && markArray[dx][dy] == 0 && chars[dx][dy] == 'X') {
                    markArray[dx][dy] = mark;
                    queue.add(new Point(dx, dy));
                }
            }
        }
    }
}
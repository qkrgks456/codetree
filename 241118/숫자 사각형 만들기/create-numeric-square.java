import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    static int[] dx = {1,0};
    static int[] dy = {0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] ints = new int[n][n];
        int[][] check = new int[n][n];
        ints[0][0] = 9;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        check[0][0] = 1;
        while(!queue.isEmpty()){
            Point point = queue.poll();
            for(int i =0; i<2; i++){
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if(nx < n && ny < n && check[nx][ny] == 0){
                    check[nx][ny] = 1;
                    if(ints[point.x][point.y] > 1){
                        ints[nx][ny] = ints[point.x][point.y] - 1;
                    }else{
                        ints[nx][ny] = 1;
                    }
                    queue.add(new Point(nx,ny));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(ints[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
import java.util.*;
import java.io.*;
import java.awt.*;
public class Main {
    static int[] nx = {1,-1,0,0};
    static int[] ny = {0,0,1,-1};
    static int n,m;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][m];
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
         while(true){
            // 다 0이라서 나누어지지 않는다면
            if(zeroCheck(graph)){
                result = 0;
                break;
            }
            // 주위 0에서 빼는 작업
            graph = minusNum(graph);

            // 집합 부분 갯수 확인 및 올0인 케이스
            int count = BFS(graph);
            result++;
            if(count >= 2) break;
         }
        System.out.println(result);

    }

    public static boolean zeroCheck(int[][] graph){
        boolean check = true;
        for(int i = 0; i< n;i++){
            for(int j = 0; j<m;j++){
                if(graph[i][j] != 0){
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static int[][] minusNum(int[][] graph){
        int[][] newGraph = new int[n][m];
        for(int i = 0; i< n;i++){
            for(int j = 0; j<m;j++){
                if(graph[i][j] != 0){
                    int count = 0;
                    for(int k = 0; k < 4; k++){
                        int dx = i + nx[k];
                        int dy = j + ny[k];
                        if(dx >= 0 && dy >= 0 && dx < n && dy < m && graph[dx][dy] == 0){
                            count++;
                        }
                    }
                    newGraph[i][j] = graph[i][j] - count < 0 ? 0 : graph[i][j] - count;
                }
            }
        }
        return newGraph;
    }

    public static int BFS(int[][] graph){
        int[][] check = new int[n][m];
        int count = 0;
        for(int i = 0; i< n;i++){
            for(int j = 0; j<m;j++){
                if(graph[i][j] != 0 && check[i][j] == 0){
                    count++;
                    check[i][j] = 1;
                    Queue<Point> queue = new LinkedList();
                    queue.add(new Point(i,j));
                    while(!queue.isEmpty()){
                        Point point = queue.poll();
                        for(int k = 0; k < 4; k++){
                            int dx = point.x + nx[k];
                            int dy = point.y + ny[k];
                            if(dx >= 0 && dy >= 0 && dx < n && dy < m && check[dx][dy] ==0 && graph[dx][dy] != 0){
                                check[dx][dy] = 1;
                                queue.add(new Point(dx,dy));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
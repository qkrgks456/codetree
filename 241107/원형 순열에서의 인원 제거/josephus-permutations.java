import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList();
        for(int i =1; i <= N; i++){
            queue.add(i);
        }
        int count = 0;
        List<Integer> list = new ArrayList();
        while(!queue.isEmpty()){
            int next = queue.poll();
            count++;
            if(count != K){
                queue.add(next);
            }else{
                list.add(next);
                count = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int num : list){
            sb.append(num).append(" ");
        }
         System.out.println(sb);
    }
}
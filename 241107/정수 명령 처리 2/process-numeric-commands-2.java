import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList();
        StringBuilder sb= new StringBuilder();
        for(int i=0; i <n; i++){
            String[]strings = br.readLine().split(" ");
            String order = strings[0];
            if(strings.length == 2){
                queue.add(Integer.parseInt(strings[1]));
            }else{
                switch(order){
                    case "pop":
                    sb.append(queue.poll()).append("\n");
                    break;
                    case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                    case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                    case "front":
                    sb.append(queue.peek()).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
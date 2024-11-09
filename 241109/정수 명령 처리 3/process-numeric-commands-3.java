import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque();
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< n; i++){
            String [] strings =br.readLine().split(" ");
            String order = strings[0];
            if(strings.length == 2){
                if(order.equals("push_back")){
                    dq.addLast(Integer.parseInt(strings[1]));
                } else {
                    dq.addFirst(Integer.parseInt(strings[1]));
                }
            }else{
                switch(order){
                    case "pop_front":
                    sb.append(dq.pollFirst()).append("\n");
                    break;
                    case "pop_back":
                    sb.append(dq.pollLast()).append("\n");
                    break;
                    case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                    case "empty":
                    sb.append(dq.isEmpty() ? 1 : 0).append("\n");
                    break;
                    case "front":
                    sb.append(dq.peekFirst()).append("\n");
                    break;
                    case "back":
                    sb.append(dq.peekLast()).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
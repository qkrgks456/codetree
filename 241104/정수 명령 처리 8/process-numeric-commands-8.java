import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< n; i++){
            String [] strings = bufferedReader.readLine().split(" ");
            String order = strings[0];
            if(strings.length == 2){
                int num = Integer.parseInt(strings[1]);
                if(order.equals("push_front")){
                    list.addFirst(num);
                }else if(order.equals("push_back")){
                    list.addLast(num);
                }
            }else{
                switch (order){
                        case "pop_front":
                        sb.append(list.pollFirst());
                        sb.append("\n");
                        break;
                        case "pop_back":
                        sb.append(list.pollLast());
                        sb.append("\n");
                        break;
                        case "size":
                        sb.append(list.size());
                        sb.append("\n");
                        break;
                        case "empty":
                        sb.append(list.isEmpty() ? 1 : 0);
                        sb.append("\n");
                        break;
                        case "front":
                        sb.append(list.peekFirst());
                        sb.append("\n");
                        break;
                        case "back":
                        sb.append(list.peekLast());
                        sb.append("\n");
                        break;
                }
            }       
        }
        System.out.println(sb);
        
    }
}
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] strings = br.readLine().split("");
        List<String> list = new LinkedList();
        for(int i = 0; i < n; i++){
            list.add(strings[i]);
        }
        ListIterator<String> it = list.listIterator(list.size());
        for(int i = 0; i < m; i++){
            String[] orders = br.readLine().split(" ");
            String order = orders[0];
            switch(order){
                case "L":
                if(it.hasPrevious()) it.previous();
                break;
                case "R":
                if(it.hasNext()) it.next();
                break;
                case "D":
                if(it.hasNext()){
                    it.next();
                    it.remove();
                } 
                break;
            }
            if(orders.length == 2){
                it.add(orders[1]);
            }
        }
        // it 원래대로
        while(it.hasPrevious()) it.previous();
        StringBuilder result = new StringBuilder();
        while(it.hasNext()){
            result.append(it.next());
        }
        System.out.println(result);
        
  
    }
}
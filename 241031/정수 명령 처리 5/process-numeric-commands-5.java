import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for(int i= 0; i<n; i++){
            String[] strings = br.readLine().split(" ");
            String s = strings[0];
            int num =0;
            if(strings.length == 2){
                num = Integer.parseInt(strings[1]);
            }
       
            if(s.equals("push_back")){
                list.add(num);
            }else if(s.equals("pop_back")){
                list.remove(list.size() - 1);
            }else if(s.equals("size")){
                sb.append(list.size()).append("\n");
            }else{
                sb.append(list.get(num - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
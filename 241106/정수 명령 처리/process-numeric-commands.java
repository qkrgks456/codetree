import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack st = new Stack();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i ++){
                String[] strings = br.readLine().split(" ");
                String order = strings[0];
                if(strings.length == 2){
                    st.push(strings[1]);
                }else{
                    switch(order){
                        case "pop":
                        sb.append(st.pop()).append("\n");
                        break;
                        case "size":
                        sb.append(st.size()).append("\n");
                        break;
                        case "empty":
                        sb.append(st.isEmpty() ? 1 : 0).append("\n");
                        break;
                        case "top":
                        sb.append(st.peek()).append("\n");
                        break;
                    }
                }
        }
        System.out.println(sb);
    }
}
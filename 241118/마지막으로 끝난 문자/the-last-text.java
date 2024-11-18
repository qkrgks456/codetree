import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList();
        for(int i =0; i<n;i++){
            list.add(br.readLine());
        }   
        String end = br.readLine();
        List<String> result = new ArrayList();
        for(String s : list){
            char stringEnd = s.charAt(s.length() - 1);
            char e = end.charAt(0);
            if(stringEnd == e) result.add(s);
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(result.size());
        for(String s : result){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
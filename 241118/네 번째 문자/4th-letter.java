import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = st.nextToken();
        List<String> result = new ArrayList();
        for(int i =0; i<n;i++){
            String str = br.readLine();
            char ch = str.charAt(3);
            char ch2 = s.charAt(0);
            if(ch == ch2) result.add(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for(String res : result){
            sb.append(res).append("\n");
        }
        System.out.println(sb);

    }
}
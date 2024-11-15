import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str1 = st.nextToken();        
        String str2 = st.nextToken();
        String ch = str2.substring(0,3);
        ch += str1;
        System.out.println(ch);
    }
}
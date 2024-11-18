import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result1 = 0;
        int result2 = 0;
        for(int i =0; i< n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num % 5 == 0) result1++; 
            if(num % 7 == 0) result2++;        
        }
        System.out.println(result1);
        System.out.println(result2);
    }
}
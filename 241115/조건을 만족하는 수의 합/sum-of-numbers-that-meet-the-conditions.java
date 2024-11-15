import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = n; i<=500; i++){
            if(i % 2 == 0){
                result += i;
            }
        }
        System.out.println(result);
    }
}
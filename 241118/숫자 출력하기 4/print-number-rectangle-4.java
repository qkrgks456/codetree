import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        if(k ==1 ){
            for(int i = 1; i<= n;i++){
            for(int j=0; j<n;j++){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            }
        }else if(k==2){
            for(int i= 1; i<=n; i++){
                if(i % 2 ==0){
                    for(int j = n; j >= 1; j--){
                        sb.append(j).append(" ");
                    }
                }else{
                    for(int j = 1; j <= n; j++){
                        sb.append(j).append(" ");
                    }
                }
                sb.append("\n");
            }
        }else{
            for(int i = 1; i<= n;i++){
                for(int j = 1; j <= n; j++){
                    sb.append(i * j).append(" ");
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
        
    }
}
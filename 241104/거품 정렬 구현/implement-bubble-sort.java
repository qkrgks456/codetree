import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i< n; i++){
            ints[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1 - i; j++){
                if(ints[j] > ints[j + 1]){
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< n;i++){
                sb.append(ints[i] + " ");
        }
        System.out.println(sb);

    }
}
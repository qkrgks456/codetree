import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            ints[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n; i++){
            int key = ints[i];
            int j = i - 1;
            while(j >= 0 && key < ints[j]){
                ints[j + 1] = ints[j];
                j--;
            }
            ints[j + 1] = key;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i <n; i++){
            sb.append(ints[i]).append(" ");
        }
        System.out.println(sb);
    }
}
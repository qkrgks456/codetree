import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            int min = ints[i];
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (min > ints[j]) {
                    min = ints[j];
                    index = j;
                }
            }
            int temp = ints[i];
            ints[i] = ints[index];
            ints[index] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ints[i]).append(" ");
        }
        System.out.println(sb);
    }
}
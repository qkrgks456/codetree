import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        // 자 최대힙 형태로 만들었다.
        for(int i = n / 2; i >= 1; i--){
            heapify(ints, n, i);
        }
        
        for(int i = n; i > 1; i--){
            int temp = ints[1];
            ints[1] = ints[i];
            ints[i] = temp; 
            heapify(ints, i - 1, 1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i =1; i<= n; i++){
            sb.append(ints[i]).append(" ");
        }
        System.out.println(sb);

    }

    public static void heapify(int[] arr, int n, int i){
        int max = arr[i];
        int index = i;
        int left = i * 2;
        int right = i * 2 + 1;
        
        if(left <= n && arr[index] < arr[left]) {
            index = left;
        }
        if(right <= n && arr[index] < arr[right]){
            index = right;
        }

        if(index != i){        
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            heapify(arr,n,index);
        }

    }
}
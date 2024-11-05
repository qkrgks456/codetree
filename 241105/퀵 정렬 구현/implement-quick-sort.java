import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i< n; i++){
            ints[i] = Integer.parseInt(st.nextToken());
        }
        quicksort(ints,0, n - 1);
        StringBuilder sb = new StringBuilder();
       for(int i =0; i< n; i++){
            sb.append(ints[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void quicksort(int[] arr,int start,int end){
        if (start < end) { // 종료 조건 체크
            int part = partition(arr, start, end);
            quicksort(arr, start, part - 1);
            quicksort(arr, part + 1, end);
        }
    }

    public static int partition(int[] arr,int start,int end){
        int pivot = arr[start + end / 2];
        while(start <= end){
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if(start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        return start;
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        recursion(ints, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int num : ints) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    public static void recursion(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            recursion(arr, low, mid);
            recursion(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        // 왼쪽과 오른쪽 배열의 크기
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // 임시 배열 생성
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // 임시 배열에 데이터 복사
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[low + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // 임시 배열을 병합
        int i = 0, j = 0;
        int k = low;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // 남은 요소들 복사
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
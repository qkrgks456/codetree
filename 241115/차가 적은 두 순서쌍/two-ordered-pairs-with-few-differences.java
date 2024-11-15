import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> sumList = new ArrayList();
        for(int i =0; i< list.size() - 1; i++){
            for(int j = i + 1; j< list.size(); j++){
                sumList.add(list.get(i) + list.get(j));
            }
        }
        
        Collections.sort(sumList);
        int result = Integer.MAX_VALUE;
        for(int i =0; i< list.size() - 1; i++){
            for(int j = i + 1; j< list.size(); j++){
                result = Math.min(result, Math.abs(sumList.get(i) - sumList.get(j)));
            }
        }
        System.out.println(result);
    }
}
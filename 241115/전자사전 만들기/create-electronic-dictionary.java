import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        Map<String, Integer> locationMap = new HashMap<>();
        List<String> list = new ArrayList();
        for(int i =0; i<n; i++){
            String s = br.readLine();
            locationMap.put(s, i+1);
            list.add(s);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            int start = search(s, list);
            String result = "";
            boolean check = true;
            while(k != 0){
                k--;
                result = list.get(start);
                start++;
                // 만약 찾는것에서 이미 넘어갈경우
                if(!result.startsWith(s)){
                    check = false;
                    break;
                } 
                if(start == list.size()) {
                    check = false;
                    break;
                }
            }
            if(check){
                sb.append(locationMap.get(result));
            }else{
                sb.append("-1");
            }
           sb.append("\n");
        }
        System.out.println(sb);

    }

    // 이분탐색
    public static int search(String s,List<String> list){
        int left = 0;
        int right = list.size() - 1;
        int min_idx = list.size();
        while(left <= right){
            int mid = (right + left) / 2;            
            if(list.get(mid).compareTo(s) >= 0){
                min_idx = Math.min(min_idx, mid);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return min_idx;
    }
}
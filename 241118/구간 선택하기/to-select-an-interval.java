import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Location> list = new ArrayList<>();
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Location(start, end));
        }
        Collections.sort(list);
        int currentEnd = 3;
        int result = 0;
        int index =0;
        while(currentEnd < 220){
            int maxEnd = currentEnd;
            
            // 현재 덮을 수 있는 구간 찾기   
            while (index < list.size() && list.get(index).start <= currentEnd) {
                maxEnd = Math.max(maxEnd, list.get(index).end);
                index++;
            }
            
            if (maxEnd == currentEnd) {
                System.out.println(0);
                return;
            }
            
            currentEnd = maxEnd;
            result++;
        }
        System.out.println(result);
        
    }

     static class Location implements Comparable<Location>{
            int start;
            int end;
            public Location(int start, int end){
                this.start = start;
                this.end = end;
            }
            @Override
            public int compareTo(Location o) {
                if (this.start == o.start) {
                    return o.end - this.end;
                }
                return this.start - o.start;
            }

     }
}
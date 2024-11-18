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
            list.add(new Location(start, end - 1));
        }
        Collections.sort(list);
        int currentEnd = 3;
        int result = 0;
        for(Location location : list){
            if(location.start <= currentEnd && location.end >= currentEnd){
                currentEnd = location.end;
                result++;
            }
            if(currentEnd >= 220) break;
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
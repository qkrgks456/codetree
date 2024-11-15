import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> checkSet = new HashSet();
        List<Node> nodeList = new ArrayList();
        for(int i =0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            nodeList.add(new Node(index,value));
            checkSet.add(value);
        }  
        // 정렬
        Collections.sort(nodeList);
        Map<Integer,Integer> checkMap = new HashMap();
        int result = Integer.MAX_VALUE;
        int start = 0;
        for(int end =0; end < nodeList.size(); end++){
            Node node = nodeList.get(end);
            checkMap.put(node.value,checkMap.getOrDefault(checkMap.get(node.value),0) + 1);
            while(check(checkMap,checkSet)){
                // 현재 시작점이랑 마지막점 구간 최솟값 넣기
                int startIndex = nodeList.get(start).index;
                int endIndex = nodeList.get(end).index;
                result = Math.min(result, endIndex - startIndex);
                // 시작점 증가하기 위해 map에서 자기값 빼기
                checkMap.put(nodeList.get(start).value, checkMap.get(nodeList.get(start).value) - 1);
                start++;
            }
        }
        System.out.println(result);
        
    }
    public static boolean check(Map<Integer,Integer> checkMap,Set<Integer> checkSet){
        for(int n : checkSet){
            if(checkMap.get(n) == null || checkMap.get(n) < 1){
                return false;
            }
        }
        return true;
    }

    static class Node implements Comparable<Node>{
        int index;
        int value;
        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.index, o.index);
        }
        
    }
}
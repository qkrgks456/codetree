import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i< n; i++){
            result.add(Integer.parseInt(st.nextToken()));
        }
       
        for(int i = 5; i >= 0; i--){
            // 번호 담을 리스트 만들기
            List<List<Integer>> list = new ArrayList();
            for(int j =0; j < 10; j++){
                list.add(new ArrayList());
            }
            
            // 배열의 자리수 맨끝자리 안되면 0으로 넣기
            for(int j=0; j< result.size();j++){
                String[] strings = String.valueOf(result.get(j)).split("");
                if(i <= strings.length - 1){
                    list.get(Integer.parseInt(strings[i])).add(result.get(j));
                }else{
                    list.get(0).add(result.get(j));
                }
            }
            // 리스트를 결과값으로
            result.clear();
            for(List<Integer> l : list){
                for(int num : l){
                    result.add(num);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int num : result){
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
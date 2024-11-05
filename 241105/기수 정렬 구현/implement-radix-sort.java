import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i< n; i++){
            result.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < 6; i++){
            // 번호 담을 리스트 만들기
            List<List<Integer>> list = new ArrayList<>();
            for(int j =0; j < 10; j++){
                list.add(new ArrayList<>());
            }

            // 배열의 자리수 맨끝자리 안되면 0으로 넣기
            for (int num : result) {
                // 문자열 뒤집기
                String reversed = new StringBuilder(String.valueOf(num))
                        .reverse()
                        .toString();
                String[] strings = reversed.split("");

                if (i < strings.length) {
                    list.get(Integer.parseInt(strings[i])).add(num);
                } else {
                    list.get(0).add(num);
                }
            }
            // 리스트를 결과값으로
            result.clear();
            for(List<Integer> l : list){
                result.addAll(l);
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int num : result){
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
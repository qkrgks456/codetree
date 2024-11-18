

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] chars = str.toCharArray();
        char[] pattern = {'a', 'b', 'c', 'd', 'e'};
        int[] check = new int[chars.length];
        int result = 0;
        while (true) {
            result++;
            int patternIndex = 0;
            boolean flag = false;
            for (int i = 0; i < chars.length; i++) {
                if(check[i] == 1) continue;
                if (chars[i] == pattern[patternIndex]) {
                    flag = true;
                    check[i] = 1;
                    patternIndex++;
                    if (patternIndex == pattern.length) {
                        patternIndex = 0;
                    }
                }
            }

            // 부분 문자열을 완성하지 못했다면, -1을 출력하고 프로그램을 종료합니다.
            if (patternIndex != 0) {
                System.out.println(-1);
                return;
            }

            if (!flag) break;

            // 모든 문자가 사용되었는지를 확인하기 위한 변수입니다.
            boolean allCharactersUsed = true;

            // 원본 문자열의 모든 문자를 확인합니다.
            for (int i = 0; i < chars.length; i++) {
                // 사용되지 않은 문자가 하나라도 있으면, 모든 문자가 사용된 것이 아닙니다.
                if (check[i] == 0) {
                    allCharactersUsed = false;
                    break;
                }
            }

            // 모든 문자가 사용되었다면, 반복을 종료합니다.
            if (allCharactersUsed) break;
        }
        // 최종적으로 모든 문자가 사용되었는지를 다시 한번 확인합니다.
        boolean allCharactersUsed = true;
        for (int i = 0; i < chars.length; i++) {
            if (check[i] == 0) {
                allCharactersUsed = false;
                break;
            }
        }

        // 모든 문자가 사용되었다면, 필요한 부분 문자열의 개수를 출력합니다.
        if (allCharactersUsed) {
            System.out.println(result);
        }
        // 모든 문자를 사용할 수 없었다면, -1을 출력합니다.
        else {
            System.out.println(-1);
        }

    }
}
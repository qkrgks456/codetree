
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
            int patternIndex = 0;
            boolean flag = false;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == pattern[patternIndex] && check[i] == 0) {
                    check[i] = 1;
                    patternIndex++;
                    if (patternIndex == pattern.length) {
                        flag = true;
                        patternIndex = 0;
                    }
                }
            }
            if (flag) {
                result++;
            } else {
                break;
            }
        }

        System.out.println(result == 0 ? -1 : result);

    }
}
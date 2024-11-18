

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] chars = str.toCharArray();
        int result = 0;
        int count = 0;
        for (char ch : chars) {
            if (count == 0 && ch == 'a') {
                count++;
            } else if (count == 1 && ch == 'b') {
                count++;
            } else if (count == 2 && ch == 'c') {
                count++;
            } else if (count == 3 && ch == 'd') {
                count++;
            } else if (count == 4 && ch == 'e') {
                count++;
            }
            if (count == 5) {
                result++;
                count = 0;
            }
        }
        System.out.println(result == 0 ? -1 : result);

    }
}
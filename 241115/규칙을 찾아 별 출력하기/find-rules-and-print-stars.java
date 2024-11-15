import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int num = (n -1) * 4 + 1;
        char[][] chars = new char[num][num];
        recursion(n,chars,0);
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< num; i++){
            for(int j=0; j<num; j++){
                sb.append(chars[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void recursion(int level, char[][] chars, int start){
        if(level == 0){
            chars[chars.length / 2][chars.length / 2] = '*';
            return;
        }
        int num = (level - 1) * 4 + 1;
        for(int i = start; i< start + num; i++){
            chars[start][i] = '*';
        }
        for(int i = start; i< start + num; i++){
            chars[i][start] = '*';
        }
        for(int i = start; i< start + num; i++){
            chars[i][start + (num - 1)] = '*';
        }
        for(int i = start; i < start + num; i++){
            chars[start + (num - 1)][i] = '*';
        }
        recursion(level - 1, chars, start + 2);
    }
}
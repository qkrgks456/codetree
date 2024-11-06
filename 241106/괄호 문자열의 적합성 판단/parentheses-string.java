import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] strings = s.split("");
        boolean check = true;
        Stack st = new Stack();
        for(int i =0; i< strings.length; i++){
            if(strings[i].equals("(")){
                st.push("(");
            }else{
                if(st.isEmpty()){
                    check = false;
                    break;
                }else{
                    st.pop();
                }
            }
        }
        if(st.size()== 0 && check){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
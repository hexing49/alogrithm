package test;

import java.util.LinkedList;

/**
 * @Author hexing37
 * @Date 2021/11/30 16:09
 * @Description
 */
public class Test {
    public static void main(String[] args) {
   /*     String s1 = "a";
        String s2 = "b";
        String s = "a";
        String s3 = "ab";
        String s4 = new String("a");
       // System.out.println(s1 == s4);
        String intern = s4.intern();
        System.out.println(s1 == intern);*/
        String str = "ab" + "cd" + "ef";
        for (int i = 0; i < 100; i++) {
            str = str + i;
        }
        String s = "1234";

    }
}

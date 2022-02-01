package test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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
      /*  for (int i = 0; i < 100; i++) {
            str = str + i;
        }
        String s = "1234";*/
      /*  ArrayList<String> objects = new ArrayList<>();
        objects.add("11");
        objects.add("22");
        objects.add("33");
        Set<String> set = new HashSet<>();
        set.add("11");
        set.add("22");
        set.add("22");
        System.out.println(set.size());
        String[] words = objects.toArray(new String[0]);

        String s = "123456778900";
        String substring = s.substring(0,6);
        System.out.println(substring);
        BigDecimal bigDecimal = new BigDecimal(20);
        System.out.println(bigDecimal.toString());
        */
        char c = new String("00101001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000").charAt(7);
        int i = c - '0';
        System.out.println(i);

        BigDecimal bigDecimal = new BigDecimal(BigInteger.ZERO);
        double v = bigDecimal.doubleValue();
        System.out.println(v);
        System.out.println(v < 0);

    }
}

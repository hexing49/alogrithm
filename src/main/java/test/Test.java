package test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

/**
 * @Author hexing37
 * @Date 2021/11/30 16:09
 * @Description
 */
public class Test {
    public static void main(String[] args) throws UnknownHostException {
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
        Father father = new Father();
        AoStatusEnum aoStatusEnum = null;
        AoStatusEnum aoStatusEnum1 = father.buildCancelStatus("1");
        System.out.println(aoStatusEnum1.getCode());

        InetAddress addr = InetAddress.getLocalHost();
        String hostname = addr.getHostName();
        System.out.println("Local HostAddress: " + addr.getHostAddress());

        System.out.println("Local host name: " + hostname);

        StringBuilder stringBuilder = new StringBuilder("010K1619628");
        System.out.println(stringBuilder.toString().substring(0,stringBuilder.toString().length()-1));
        BigDecimal monopolizeStockDecimal = BigDecimal.valueOf(36);

        double tempNum = monopolizeStockDecimal.multiply(new BigDecimal(50)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
        System.out.println(tempNum);
        Integer realCalcNum = (int) Math.floor(tempNum);//按比例计算，向下取整的数

        String array = "1234";
        String[] split = array.split(";");
        System.out.println(split[0]);
        String a = "aa" + UUID.randomUUID();
                System.out.println(a );

    }
}

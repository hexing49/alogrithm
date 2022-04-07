package designPartten.singleton;

import designPartten.User;

import java.io.*;

/**
 * @Author hexing37
 * @Version 1.0
 * @Date Created in 2021/12/6 18:00
 * @Description
 */
public class Test {
    private static String file = "D:\\test.txt";
    private static final  Integer b = 100000;
    public static void main(String[] args) throws IOException {
     /*   User user = new User();
        user.setName("hosea");
        user.setGender("男");
        user.setAge("20");*/
        Singleton singleton =  Singleton.getInstance();
        System.out.println(singleton);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(Test.file)));
        objectOutputStream.writeObject(singleton);
        objectOutputStream.close();
        Integer a = Integer.valueOf("10000");
        System.out.println(a < b);
    }
}

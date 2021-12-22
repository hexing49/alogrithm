package designPartten.singleton;

import designPartten.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @Author hexing37
 * @Version 1.0
 * @Date Created in 2021/12/22 15:03
 * @Description
 */
public class Test2 {
    private static String file = "d:\\test.txt";

    public static void main(String[] args) throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(file)));
        User singleton = (User) objectInputStream.readObject();
        System.out.println(singleton);
    }


}

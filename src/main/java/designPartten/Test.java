package designPartten;

import designPartten.singleton.Singleton;

import javax.xml.crypto.Data;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author hexing37
 * @Version 1.0
 * @Date Created in 2021/12/6 18:00
 * @Description
 */
public class Test {
    private static String file = "D:\\test.txt";
    public static void main(String[] args) throws IOException {
        User user = new User("hexing37","1");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(Test.file)));
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
    }
}

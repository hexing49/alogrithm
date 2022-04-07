package concurrent.jmm;

import sun.misc.Unsafe;
import test.SourceEnum;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VisiableTest {

    public volatile int count;
    public  boolean flag = true;

    public void load() {
       // Unsafe
        System.out.println(Thread.currentThread().getName() + "开始执行。。。");
        while (flag) {
            count++;
        }
        System.out.println(Thread.currentThread().getName() + "跳出循环: count" + count);
    }

    public void refresh() {
        flag = false;
        System.out.println(Thread.currentThread().getName() + "修改flag为" + flag);
    }

    public static void main(String[] args) throws InterruptedException {
        Byte b = new Byte("1");
        System.out.println(b == 1);

    }
}

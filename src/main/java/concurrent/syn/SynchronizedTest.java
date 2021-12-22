package concurrent.syn;

/**
 * @Author hexing37
 * @Version 1.0
 * @Date Created in 2021/12/16 15:16
 * @Description
 */
public class SynchronizedTest extends Thread {

    public static synchronized void test1() {
        System.out.println("test1");
    }

    public synchronized void test2() {
        System.out.println("test2");
    }

    public void test3() {
        synchronized (this) {
            System.out.println("test3");
        }
    }

    public static void test4() {
        System.out.println("test4");
    }
}

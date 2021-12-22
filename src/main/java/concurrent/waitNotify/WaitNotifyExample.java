package concurrent.waitNotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author hexing37
 * @Version 1.0
 * @Date Created in 2021/12/15 14:39
 * @Description
 */
public class WaitNotifyExample {
    public synchronized void before() {
        System.out.println("before");
        notifyAll();
    }

    public synchronized void after() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        WaitNotifyExample example = new WaitNotifyExample();
        executorService.execute(() -> example.after());
        executorService.execute(() -> example.before());
    }

}


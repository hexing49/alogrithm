package concurrent.threadL;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author hexing37
 * @Version 1.0
 * @Date Created in 2021/12/13 16:26
 * @Description
 */
public class ThreadLocalExample {
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override
                protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }
            };
    static class aa implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            return 123;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        aa aa = new aa();
        FutureTask<Integer> futureTask = new FutureTask<>(aa);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}

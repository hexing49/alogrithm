package designPartten.singleton;


import java.io.Serializable;

/**
 * @Author hexing37
 * @Version 1.0
 * @Date Created in 2021/12/6 17:48
 * @Description
 */
public class Singleton implements Serializable {
    public volatile transient static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {

        }

    }

    private Object readResolve() {
        return Singleton.getInstance();
    }

}

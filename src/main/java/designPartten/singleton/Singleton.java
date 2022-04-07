package designPartten.singleton;


import designPartten.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @Author hexing37
 * @Version 1.0
 * @Date Created in 2021/12/6 17:48
 * @Description
 */
public class Singleton implements Serializable {

    private static final long serialVersionUID = -1131868478960947804L;

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

  /*  private Object readResolve() {
        Singleton instance = getInstance();
        return instance;
    }*/

}

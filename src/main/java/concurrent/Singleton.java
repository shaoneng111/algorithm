/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package concurrent;

/**
 * 多线程下单例双检锁
 * dcl
 *
 * @author shaoneng
 * @date 2020/7/10 7:50 下午
 */
public class Singleton {

    private static volatile Singleton singleton;

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
}

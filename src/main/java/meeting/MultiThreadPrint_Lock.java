package meeting;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadPrint_Lock {

    private static final Lock lock = new ReentrantLock();

    private static final Condition condition = lock.newCondition();

    private static int count = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> print(1), "threadA");

        Thread t2 = new Thread(() -> print(2), "threadB");

        Thread t3 = new Thread(() -> print(3), "threadC");

        t1.start();
        t2.start();
        t3.start();

    }

    private static void print(int num) {
        while (count <= 30) {
            lock.lock();
            try {
                if (count % 3 != num) {
                    condition.await();
                } else {
                    System.out.println("线程" + Thread.currentThread().getName() + ": " + num);
                    ++count;
                    condition.signalAll();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}

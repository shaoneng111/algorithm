package meeting;

/**
 * 多线程打印
 *
 * 线程1打印1，线程2打印2，线程3打印3，按123123...顺序交替打印500次
 *
 *
 */
public class MultiThreadPrint {

    private final Object lock = new Object();

    private volatile int count = 1;

    public static void main(String[] args) throws InterruptedException {

        MultiThreadPrint f = new MultiThreadPrint();

        Thread t1 = new Thread(() -> f.print(1), "threadA");

        Thread t2 = new Thread(() -> f.print(2), "threadB");

        Thread t3 = new Thread(() -> f.print(3), "threadC");

        t1.start();
        t2.start();
        t3.start();


    }

    private  void print(int num) {
        while (count <= 9) {
            synchronized (lock) {
                if (count % 3 == num % 3) {
                    System.out.println(Thread.currentThread().getName() + "打印：" + num);
                    count++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }






}

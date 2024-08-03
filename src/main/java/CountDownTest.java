import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class CountDownTest {
    public static void main(String[] args) {
        final CountDownLatch down = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    down.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
                String orderNo = sdf.format(new Date());
                System.out.println("订单号是：" + orderNo);
            }).start();
        }
        down.countDown();
    }
}

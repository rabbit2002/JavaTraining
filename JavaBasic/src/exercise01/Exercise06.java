package exercise01;

/**
 * 多线程输出线程名
 *
 * @author RABBIT2002
 * @date 2021/1/16
 */
public class Exercise06 {

    public static void main(String[] args) {
        Runnable runnable =()-> {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread .sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

        Thread thread1= new Thread(runnable);
        Thread thread2= new Thread(runnable);

        thread1.start();
        thread2.start();
    }
}

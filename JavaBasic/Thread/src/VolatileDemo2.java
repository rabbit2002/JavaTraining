/**
 * description TODO
 *
 * @author RABBIT2002
 * @date 2021/1/15
 */
class ThreadDemo2 extends Thread {
    volatile boolean flag = false;
    int i = 1;

    @Override
    public void run() {
        while (flag == false) {
            i++;
        }
    }
}

public class VolatileDemo2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo2 td = new ThreadDemo2();
        td.start();
        Thread.sleep(5);
        td.flag = true;
        System.out.println(td.i);
        System.out.println(td.flag);
    }
}


/**
 * description TODO
 *
 * @author RABBIT2002
 * @date 2021/1/15
 */
class ThreadDemo1 extends Thread {
    boolean flag = false;
    int i = 1;

    @Override
    public void run() {
        while (flag == false) {
            i++;
        }
    }
}

public class VolatileDemo1 {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo1 td = new ThreadDemo1();
        td.start();
        Thread.sleep(5);
        td.flag = true;
        System.out.println(td.i);
        System.out.println(td.flag);
    }
}


/**
 * 多线程 使任务可以 并行执行
 *
 * // TODO 完善
 * 当程序启动时, 会创建一个 主进程, 该 主进程 创建 一个 main线程, 称为 主线程
 *
 * 任何程序都必须在线程内运行,
 * 如果 一个进程 只有 一个线程, 那么称为 单线程进程,
 * 如果 一个进程 存在 多个线程, 那么称为 多线程进程
 *
 *
 * 单线程进程 是串行的,
 * 同一时刻只有一个方法在执行, 不能同时执行多个任务, 无法完成 多任务并行
 * 当 a方法 调用 b方法, a方法的栈帧上进入了 b方法的栈帧,
 * 此时 main方法 和 a方法 都是不运行的,
 * 只有 b方法结束后 a方法 和 main方法 才会继续运行
 * *
 * 并行 与 并发:
 * 并行: 两个任务 在 同一时刻 互不干扰的 同时执行
 * 并发: 两个任务 彼此 轮换进行, 允许两个任务彼此互斥
 *
 * 对于多核CPU, 线程是可以并行运行
 * 单核CPU, 线程是并发运行
 *
 * 多进程 的目的是 同时执行多个 并行任务
 * 所有的线程必须在主线程内创建, 一个进程的线程不宜过多, 太多将导致维护开销过大
 *
 * 进程与线程的关系
 * 进程 是一个正在运行的程序
 * 线程 在 进程 的内部运行, 是正在运行的程序的一个任务
 *
 *
 * 多线程的实现 有两种方式:
 * 1. 继承 java.lang.Thread类
 * 1.1. 重写 run()方法
 * 2. 实现 java.lang.Runnable接口
 * 2.1. 实现 run()方法
 * 2.2. 创建 Thread实例, 将 实现类 作为 构造参数 传入
 *
 * 其中: Thread 是所有线程的父类, 实现了 Runnable接口
 *
 * 多线程的启动:
 * thread.start()
 *
 * 调用 thread.start() 与 thread.run() 的区别:
 * start() 是 启动线程 的方法, 同时会维护线程的状态, 在线程启动后 会调用 run()方法
 * run()   是 普通方法
 *
 * // TODO 操作系统调度算法 ... 时间片轮转...
 * // TODO JVM 处理 如何维护PC等
 * 线程状态, 在任意时间点, 一个线程有且只能拥有其中的一种状态, 并且可以通过特定的方法在 不同状态之间切换:
 * NEW:             A thread that has not yet started is in this state.
 * RUNNABLE:        A thread executing in the Java virtual machine is in this state.
 * BLOCKED:         A thread that is blocked waiting for a monitor lock is in this state.
 * WAITING:         A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
 * TIMED_WAITING:   A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
 * TERMINATED:      A thread that has exited is in this state.
 *
 * 新建: 创建后尚未启动的线程处于这种状态
 * 运行: 包括操作系统线程状态中的 Running 和 Ready, 也就是处于此状态的
 *
 *
 * // 获取当前正在运行的线程
 * Thread.currentThread()
 * // 设置线程名称
 * thread.setName()
 * // 获得线程名称
 * thread.getName()
 *
 * // TODO 完成剩下的
 *
 * @author RABBIT2002
 * @date 2021/1/14
 */
public class ThreadClass {
    public static void main(String[] args) {
        funcDemo();

    }

    // 一个多线程的实例
    private static void funcDemo() {
        // Runnable 是个函数式接口, 可以选择使用 匿名类 或 Lambda表达式 实现
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }
}

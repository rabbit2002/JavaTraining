package encapsulation;

import static java.lang.Math.PI;

/**
 * 静态导入
 * 只能导入静态变量, 导入后调用时可以忽略包名
 *
 * @author RABBIT2002
 * @date 2021/1/11
 */
public class StaticImport {
    public static void main(String[] args) {

    }

    // 静态导入后, 可以忽略类名
    public static void func1() {
        System.out.println(PI);
    }

    // 传统导入时, 需要指定类名
    public static void func2() {
        System.out.println(Math.PI);
    }
}

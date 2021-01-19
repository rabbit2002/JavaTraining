/**
 * Lambda表达式
 * 也称 闭包, 是 JDK8 中的新特性之一
 * <p>
 * Lambda表达式 允许函数作为一个方法的参数(即, 函数作为参数传递到方法中)
 * Lambda表达式 可以简化 函数式接口(只有一个抽象方法的普通接口) 的使用
 * 优点: 简化传统的使用 匿名内部类 的形式 (参见 func1() 与 func2()), 不会产生额外的 .class文件
 * 缺点: 不宜读, 只能用于 函数式接口 中, 不宜调试
 * <p>
 * 使用前提:
 * 必须在 函数式接口(只有一个抽象方法的普通接口) 中,
 * 可以使用 @FunctionalInterface 注解 规范该接口是否为 函数式接口
 * <p>
 * <p>
 * 语法: 使用 "->"(Lambda操作符)
 * ([[T ]args1, [T ]args2, ...]) -> {[方法体]}
 * <p>
 * ([[T ]args1, ...]) 表示抽象方法的参数
 * 只有当 仅有1个 参数时, () 可省略 (2. 可选参数圆括号),
 * 且 参数类型可省略 (1. 可选类型声明)
 * <p>
 * {[方法体]} 表示抽象方法的实现
 * 只有当 仅有1条 语句时, {} 可省略 (3. 可选的大括号),
 * 当 仅有1条 语句时, 可直接书写 返回值 (4. 可选的返回关键字), 但此时 {} 必须省略
 * (1-4为Lambda的4个重要特征)
 *
 * @author RABBIT2002
 * @date 2021/1/11
 */
public class Lambda {
    public static void main(String[] args) {
    }

    private void func1() {
        Interface anInterface = new Interface() {
            @Override
            public int func1(int x, int y) {
                System.out.println("匿名类实现");
                return 1;
            }
        };
    }

    private void func2() {
        // 类型声明
        Interface anInterface1 = (int x, int y) -> {
            System.out.println("Lambda表达式实现");
            return 1;
        };
        // 无需类型声明, 单行返回无需return关键字
        Interface anInterface2 = (x, y) -> 1;
    }

    // Interface 作为参数
    private void funcInterface(int x, int y, Interface inter) {
        int number = inter.func1(x, y);
    }

    private void funcImpl(int x, int y) {
        // 匿名类作为参数
        funcInterface(x, y, new Interface() {
            @Override
            public int func1(int m, int n) {
                System.out.println("内部类作为参数");
                return 1;
            }
        });

        // Lambda表达式作为参数
        funcInterface(x, y, (m, n) -> {
            System.out.println("Lambda表达式作为参数");
            return 1;
        });
    }
}

@FunctionalInterface
interface Interface {
    int func1(int x, int y);
}

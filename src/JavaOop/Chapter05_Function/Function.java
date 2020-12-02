package JavaOop.Chapter05_Function;

/**
 * 方法分为API(Application Programming Interface)和自定义方法
 * <p>
 * [访问限制修饰符] 返回值类型 方法名称([形式参数类型 形式参数名称, ...]){ //方法头
 * //方法体
 * [return;]
 * }
 * return返回值的类型必须与方法声明的返回值类型一致
 * <p>
 * 方法调用：
 * 发出调用的方法称为主调方法，被调用的方法称为被调方法
 * 主调方法中的参数被称为实际参数，被调方法中的参数称为形式参数，两者需要在个数、类型、顺序上一致
 * <p>
 * 方法的设计遵循功能单一原则
 * 方法(method)是类的功能和行为，是用 函数 来表示的
 * 如何判断是函数还是方法，在于它的调用者是谁
 * 如果它的调用者是类，它就是函数；调用者是对象，它就是方法
 * <p>
 * 变量的作用域和生命周期：在块内作用，从分配内存到回收内存存活
 * 当前方法结束时回收栈，不回收堆，堆由GC处理
 * //TODO JVM 常量池 [任何]变量在JVM中的储存及释放
 *
 * @author RABBIT2002
 * @date 2020/11/30
 */
public class Function {
    public static void main(String[] args) {
        int number1 = 123;
        int number2 = 456;

        System.out.println(add(number1, number2));
        System.out.println(multiply(number1, number2));
        System.out.println(maxNumber(number1, number2));
    }

    /**
     * 计算两数之和
     */
    public static int add(int number1, int number2) {
        return number1 + number2;
    }

    /**
     * 计算两数之积
     */
    public static int multiply(int number1, int number2) {
        return number1 * number2;
    }

    /**
     * 求最大值
     */
    public static int maxNumber(int number1, int number2) {
        // if (number1 > number2) {
        //    return number1;
        // } else {
        //     return number2;
        // }
        return Math.max(number1, number2);
    }

}

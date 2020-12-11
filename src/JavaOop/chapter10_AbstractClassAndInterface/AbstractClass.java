package javaOop.chapter10_AbstractClassAndInterface;

/**
 * 被abstract关键字修饰的Class是Abstract Class
 * 被abstract关键字修饰的Func()是Abstract Func()
 * <p>
 * 1.抽象类与普通类一样可以定义实例属性/实例方法/类属性/类方法
 * 2.抽象类独有抽象方法(没有方法体的方法),且只有实例方法可以被抽象,实例属性和类方法/类属性均不能抽象
 * 3.如果一个类包含抽象方法,则该类只能是抽象类,但抽象类不一定包含抽象方法
 * 4.只要是抽象类,就不能实例化
 * 5.private 和 final 关键字不能修饰抽象方法,因为如此做子类将无法实现该方法
 * <p>
 * 抽象类是为了更好的实现多态,
 * 抽象类作为父类,子类继承后如果想实例化,就一定要实现父类的全部抽象方法,或子类自身也是抽象类,
 * 通过抽象方法让子类强制遵守实现(重写)父类的方法,实现多态
 * <p>
 * <p>
 * 嵌套类(Nested Class)共有两种:
 * 1.静态嵌套类(Static Nested Class) 2.非静态嵌套类/内部类(Inner Class)
 * 其中,内部类又分为:
 * 1.成员内部类(Member inner class) 2.局部内部类(Local inner class) 3.匿名内部类(Anonymous inner class)
 * 而包含嵌套类的类,可称为外围类(Enclosing Class)或外部类(Outer Class)
 * // TODO 需要更详细了解内部类
 *
 * @author RABBIT2002
 * @date 2020/12/10
 */
public abstract class AbstractClass {
    int anIntA = 10;
    static int anIntStaticA = 20;

    void func1() {
        System.out.println("1");
    }

    abstract void func2();
}

class Son extends AbstractClass {
    int anIntB = 10;
    static int anIntStaticB = 20;

    @Override
    void func2() {
        System.out.println("2");
    }
}

class Test {
    public static void main(String[] args) {
        Son son = new Son();
        son.func1();
        son.func2();
        System.out.println(son.anIntA);
        System.out.println(son.anIntB);
        System.out.println(AbstractClass.anIntStaticA);
        System.out.println(Son.anIntStaticB);

        AbstractClass abstractClass = new AbstractClass() {
            // 内部匿名类 Anonymous inner class

            int anIntC = 10;
            // static int anIntStaticC = 20;

            @Override
            void func2() {
                System.out.println("2");
            }
        };
        abstractClass.func1();
        abstractClass.func2();
        System.out.println(abstractClass.anIntA);
        System.out.println(AbstractClass.anIntStaticA);
    }
}
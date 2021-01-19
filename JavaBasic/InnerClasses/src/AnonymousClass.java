/**
 * 匿名类常见的使用方式
 * 1. 继承接口, 实现接口方法
 * 2. 继承抽象类, 实现实现抽象方法
 * 3. 继承具体列, 重写类方法
 * <p>
 * 1.
 * 对于接口: new 关键字之后是什么 接口, 匿名类继承 Object类 实现 该接口
 * 对于抽象类: new 关键字之后是什么 抽象类, 匿名类继承 该类, 没有实现
 * 2.
 * 匿名类没有显示构造函数, 只能调用父类构造函数,
 * new 抽象类(parameter){...}, 这个参数决定了调用父类的哪个构造方法
 *
 * @author RABBIT2002
 * @date 2020/12/29
 */
public class AnonymousClass {
    InterfaceDemo interfaceDemo = new InterfaceDemo() {
        @Override
        public void funcInterface(int i) {
        }
    };

    AbstractClassDemo abstractClassDemo = new AbstractClassDemo(20) {
        @Override
        void funcAbstract() {
        }
    };

    ClassDemo classDemo = new ClassDemo() {
        @Override
        void func() {
            super.func();
        }
    };
}

interface InterfaceDemo {
    void funcInterface(int i);
}

abstract class AbstractClassDemo {
    int anInt;

    public AbstractClassDemo(int anInt) {
        this.anInt = anInt;
    }

    abstract void funcAbstract();
}

class ClassDemo {
    void func() {}
}

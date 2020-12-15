package javaOop.chapter10_AbstractClassAndInterface;

/**
 * 接口表示一种约定,也表示一种能力,体现了约定和实现相分离的原则
 * 通过面向接口编程,降低代码之间的耦合性,提高代码的可扩展性和可维护性
 * <p>
 * 定义接口:[访问限制修饰符] [abstract](默认,可省略,不可修改) interface InterfaceName
 * 实现接口:class ClassName implements InterfaceName1[, InterfaceName2]
 * <p>
 * 1.接口可用的访问限制修饰符有两种:public / (default)
 * 2.接口可以包含属性,但属性默认是 [public] [static] [final](默认,可省略,不可修改)
 * 即:接口只能有静态常量
 * 3.接口可以包含方法,但方法默认是 [public](默认,可省略,不可修改) [abstract](默认,可省略)
 * 因为继承中权限范围不能缩小,即实现接口方法的权限同样只能定义为public0
 * 3.1.[default]可替换[abstract](1.8+独有)
 * default 用于定义带方法体的默认方法(不是抽象方法),若子类重写则执行子类方法,若子类不重写则执行default方法,
 * 即:不要求子类强制实现(回到类继承的感觉)
 * Java 8的接口上的default method最初的设计目的是让已经存在的接口可以演化
 * 添加新方法而不需要原本已经存在的实现该接口的类做任何改变(甚至不需要重新编译)就可以使用该新版本的接口
 * 3.2.[static]可替换[abstract],即:接口可以包含静态方法(1.8+独有),与类方法使用一致,不能被继承
 * 4.接口不能被实例化
 * 5.接口不能定义构造函数(抽象类可以)
 * 6.接口没有最高层(抽象类Object)
 * 7.接口不能定义静态块
 * <p>
 * 抽象类和接口的使用:普通类最多可以继承一个直接父类(普通类或抽象类),但可同时实现多个接口(以此达到多重继承的效果)
 * 实现以下情况的组合:
 * 1.抽象类直接继承(抽象)类
 * 2.抽象类直接实现(多个)接口
 * 3.抽象类直接继承(抽象)类并直接实现(多个)接口
 * 4.接口直接继承(多个)接口 (接口不能继承/实现抽象类)
 * Ps.间接继承和实现自由组合
 * <p>
 * 接口与抽象类作用相同,用来定义规范,定义行为,
 * 若子类不能全部实现自己的抽象方法,该子类必须是抽象类或接口,且不能被实例化
 * (通常用空方法体实现子类不需要的抽象方法)
 * 同样,可以用父类或接口类型指针指向继承或实现了该接口的子类完成多态
 * <p>
 * <p>
 * // TODO 了解注解使用及其原理 E.g.@Interface
 * <p>
 * // TODO Java只有值传递,参数传递分为值传递和引用传递
 * // TODO finalize(); https://blog.csdn.net/a4171175/article/details/90749839
 *
 * @author RABBIT2002
 * @date 2020/12/11
 */
public interface Interface {
}

interface Ia {
    void funcIa();

    default void funIaa() {
    }

    static void funIas() {
    }
}

interface Ib {
    void funcIb();
}

abstract class Aa {
    void funcA() {}

    abstract void funcAa();
}

abstract class Ab {
    void funcB() {}

    abstract void funcAb();
}

class ClassTest {
    public static void main(String[] args) {

    }
}

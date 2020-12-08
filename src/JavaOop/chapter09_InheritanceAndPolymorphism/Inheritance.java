package javaOop.chapter09_InheritanceAndPolymorphism;

/**
 * 面向对象的三大特性：封装、继承、多态
 * <p>
 * 继承
 * 实现代码重用，减少代码冗余，增强扩展性,本质上是为了实现多态
 * Java只支持单继承,即一个类只能有一个直接父类,且所有的类继承自Object类
 * <p>
 * 通过使用extends关键字实现继承
 * [访问限制修饰符] class 子类名 extends 父类名{...}
 * 访问限制修饰符权限控制详见上一节
 * 注意:不能继承父类构造方法!
 * <p>
 * 子类继承父类后,会继承父类除了构造方法的所有的属性和方法,但因为权限可能不能直接访问
 * 父类中的静态属性和静态方法,同样可以继承,但是不能重写,同名只是新创,因为静态部分是属于类所有
 * final关键字修饰的类/属性/方法,根据final作用生效
 * <p>
 * super关键字可以调用父类的构造方法/属性/方法
 * 1.调用父类构造函数:必须写在子类构造函数第一行,且所有构造器只能同时调用一个
 * 通常父类定义的属性由父类负责初始化,子类定义的属性由子类负责初始化
 * 2.调用父类属性/方法
 * 当子类有同名属性/方法时,可以通过super关键字调用父类属性/方法
 * <p>
 * 子类构造时,将通过调用super()调用父类构造函数
 * 留下自己定义的参数,将其余的参数传递给父类构造
 * <p>
 * 构造函数调用顺序是从子类逐层向上,直到Object为止,递归调用结束开始执行返回
 * 执行顺序是从父类到子类,逐层向下
 * 且在实例化子类时所有父类也均被实例化,实例化顺序从父类向子类
 * <p>
 * 1.如果子类构造方法中没有调用除父类无参构造方法外的其它任何构造方法(即:没有调用父类有参构造方法或自身其他构造方法)
 * 将会默认调用父类无参构造方法,即:是否写super();效果一样
 * 2.调用父类有参构造方法,则不会执行父类无参构造方法
 * 3.如果该类定义了有参构造方法,则不会有自动生成的无参构造方法,此时如果子类自动访问父类无参构造方法就会出错
 *
 * @author RABBIT2002
 * @date 2020/12/8
 */
public class Inheritance {
    int a = 10;
    static int staticA = 20;

    public Inheritance() {
        System.out.println("Inheritance");
    }

    public Inheritance(int a) {
        //this();
        this.a = a;
        System.out.println("Inheritance a");
    }

    public int getA() {
        Inheritance.staticA = 10;
        return a;
    }

    public static void staticInheritance() {
        Inheritance.staticA = 20;
    }
}

class Sub extends Inheritance {
    int b = 20;
    static int staticB = 20;

    public Sub() {
        System.out.println("Sub");
    }

    public Sub(int b) {
        this.b = b;
        System.out.println("Sub b");
    }

    public Sub(int a, int b) {
        super(a);
        this.b = b;
        System.out.println("Sub a b");
    }

    @Override
    public int getA() {
        int a = super.a;
        return super.getA();
    }

    public int getB() {
        // int b= super.staticA;
        int b = Inheritance.staticA;
        //super.staticInheritance();
        Inheritance.staticInheritance();
        return b;
    }

    public static void staticSub() {
        staticInheritance();
        Sub.staticB = 40;
    }

    public static void main(String[] args) {
        Sub sub1 = new Sub();
        System.out.println();
        Sub sub2 = new Sub(1);
        System.out.println();
        Sub sub3 = new Sub(1, 2);
    }
}

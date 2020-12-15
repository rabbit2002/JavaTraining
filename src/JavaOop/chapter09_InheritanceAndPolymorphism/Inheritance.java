package javaOop.chapter09_InheritanceAndPolymorphism;

/**
 * 面向对象的三大特性：封装、继承、多态
 * <p>
 * 继承
 * 实现代码重用，减少代码冗余，增强扩展性,本质上是为了实现多态
 * Java只支持单继承,即一个类只能有一个直接父类,且所有的类直接或间接继承自Object类
 * <p>
 * 通过使用extends关键字实现继承
 * [访问限制修饰符] class 子类名 extends 父类名{...}
 * 访问限制修饰符权限控制详见上一节
 * 注意:不能继承父类构造方法!
 * <p>
 * 子类继承父类后,会继承父类除了构造方法和静态方法的所有的属性和方法,但因为权限可能不能直接访问
 * 其中,父类中的静态属性和静态方法,不能继承,因为静态部分是属于类所有
 * final关键字修饰的类/属性/方法,根据final作用生效
 * <p>
 * super关键字可以调用父类的构造方法/属性/方法
 * 1.调用父类构造函数:必须写在子类构造函数第一行,且所有构造器只能同时调用一个
 * 2.调用父类属性/方法
 * 若要调用父类属性或方法,可以通过super关键字调用父类属性/方法
 * <p>
 * 构造函数调用顺序是从子类逐层向上,直到Object的无参构造方法为止,递归调用结束,开始执行
 * 执行顺序是从父类到子类,逐层向下
 * 且在实例化子类时所有父类也均被实例化,顺序从父类向子类
 * <p>
 * 通常父类定义的属性由父类负责初始化,子类定义的属性由子类负责初始化
 * 子类构造时,将通过super()调用父类构造函数
 * 留下自己定义的参数,将其余的参数传递给父类构造
 * <p>
 * 1.如果子类构造方法中没有调用除父类无参构造方法外的其它任何构造方法(即:没有调用父类有参构造方法或自身其他构造方法)
 * 将会默认调用父类无参构造方法,即:是否写super();效果一样
 * 2.调用父类有参构造方法,则不会执行父类无参构造方法
 * 3.如果该父类类定义了有参构造方法,则不会有自动生成的无参构造方法,此时如果子类自动访问父类无参构造方法就会出错
 * <p>
 * 方法重写
 * 子类可以重新在类内定义一遍从父类继承的方法,以满足自己的需要,原来的父类同名方法被覆盖(就近原则),可以使用super.func()来调用
 * 与重载相同的是:
 * 1.重写方法与被重写方法必须方法名相同
 * 与重载不同的是:
 * 1.方法重写必须存在于继承关系中(重载在同一个类中)
 * 2.重写方法与被重写方法必须拥有相同的参数列表(重载要求方法参数不同)
 * 3.重写方法返回值类型必须与被重写方法返回值相同或是子类(重载与返回值无关)
 * 4.不能缩小重写方法的访问权限(重载与访问权限无关),且父类方法不能试private修饰(因为子类不能直接访问)
 * 5.子类抛出的异常不能超过父类相应方法抛出的异常
 * <p>
 * <p>
 * 关于继承类中的属性和方法调用的问题:
 * 子类对象在实例化时会依次实例化父类对象,待构造函数执行完后执行下一语句
 * 首先,在调用对象属性或方法时,默认调用this关键字指代自己的属性或方法
 * 此时,执行子类属性或者方法时,如果子类中有定义或重写,调用时会执行子类的属性或方法,
 * 对于父类属性,存在于实例化的各自的父类对象中,通过逐层使用super调用,
 * 如果子类没有定义或者重写,则子类的该属性或方法就是父类的该属性或方法,this与super指向相同,均指向父类方法
 * 当跳转到父类方法中后,此时this指针动态为父类的实例,this属性也就是父类的属性了
 *
 * @author RABBIT2002
 * @date 2020/12/8
 */
public class Inheritance {
    private int a = 10;
    public static int staticA = 20;

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
    private int b = 20;
    public static int staticB = 20;

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
        int a = getA();
        return super.getA();
    }

    public int getB() {
        // int b= super.staticA;
        int b = Inheritance.staticA;
        // super.staticInheritance();
        Inheritance.staticInheritance();
        return b;
    }

    public static void staticSub() {
        staticInheritance();
        Sub.staticB = 40;
    }

    public static void main(String[] args) {
        Object o;

        Sub sub1 = new Sub();
        System.out.println();
        Sub sub2 = new Sub(1);
        System.out.println();
        Sub sub3 = new Sub(1, 2);
    }
}

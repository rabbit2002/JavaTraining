package chapter08_OOP;

import java.util.Arrays;

/**
 * 面向对象
 * 面向对象程序设计(Object Oriented Programming, OOP)中认为:万事万物皆对象
 * 面向对象的三大特性：封装、继承、多态
 * <p>
 * <p>
 * 类:具有相同的状态和行为的一组对象的集合,是实体对象的概念模型,是对象进行综合抽象的结果
 * 1.用属性描述对象有什么状态
 * 2.用方法定义对象有什么行为
 * <p>
 * 对象:符合这种类定义的一个实例(instances)
 * 类是对象的模板，对象是类的实例
 * 类和对象的关系就是抽象和具体的关系
 * <p>
 * class是类关键字
 * [访问限制修饰符] class 类名{
 * .    // 定义:类的成员变量/属性/状态
 * .    // 成员变量分配在堆中,会在创建时初始化为默认值
 * .    // 作用域:整个类内
 * .    // (局部变量分配在栈内,不会初始化默认值,必须手动初始化,作用域:代码块内)
 * .    [访问限制修饰符] 数据类型 属性名
 * .    // 定义 类的成员方法/行为
 * .    [访问限制修饰符] 返回值类型 方法名称([形式参数类型 形式参数名称, ...]){...}
 * }
 * <p>
 * 创建对象实例
 * 类名 对象名 = new 类名();
 * 类名-对象数据类型 new-实例化 类名()-类构造方法
 * 使用new关键字实例化后,在堆中创建该对象的实例,在栈中创建对象指针,指针指向该内存
 * // TODO 具体分配内存细节
 * // TODO 第一次加载时加载至方法区细节
 * // TODO 对象数组在内存中的分配地址细节
 * <p>
 * 使用 '.' 运算符调用对象的属性和方法
 * <p>
 * <p>
 * 方法重载
 * 在同一类中,方法名相同,方法参数不同(个数/类型/顺序),与返回值无关,与访问限制修饰符无关,与抛出异常类型无关的多个方法称为方法重载
 * 方法调用时,JVM会自动根据主调方法的参数来决定调用哪个重载形势的方法
 * <p>
 * 构造方法(constructor)
 * [访问限制修饰符] 方法名(类名)([形式参数类型 形式参数名称, ...]){...}
 * 没有返回值类型,方法名与类名相同
 * // 如果有任何返回值类型,则都不是构造方法,只是普通[同名]成员方法
 * 1.构造方法在实例化对象时必须调用,目的是成员变量初始化
 * 2.任何类都有构造方法,分为默认无参构造方法和自定义(显式)构造方法,构造方法也可以重载
 * 3.且,当有任意一个自定义构造方法,JVM不会再生成默认构造方法
 * 4.构造方法在实例化对象时自动调用,也可在本类其他构造方法中使用this关键字调用,但不允许对象直接调用
 * 5.且,在构造函数中调用本类构造函数this(),或父类构造函数super(),必须写在第一行,且同时最多只能调用一个
 * e.g.
 * .    public ClassTest(int test) {
 * .        this.test = test;
 * .    }
 * .    public ClassTest() {
 * .        // this.test=1; ERROR
 * .        // Call to 'this()' must be first statement in constructor body
 * .        this(0);
 * .    }
 * <p>
 * <p>
 * this是Java的关键字,表示正在运行的对象/实例,指向当前对象的引用,谁调用指向谁
 * 成员变量和成员方法只有当实例化对象时才分配内存
 * 所以可以用this指向当前对象的成员变量或成员方法,但不能由类名调用
 * // TODO 成员方法调用(分配)时间
 * // TODO 整个类加载,各阶段加载及初始化流程
 * static是Java的关键字,表示静态,可以修饰内部类,成员属性和成员方法,定义静态块
 * 被static修饰的成员属性和成员方法称为静态属性/类属性和静态方法/类方法,属于类成员,不能用this指针
 * e.g.
 * .    // 静态属性/类属性
 * .    public static int a;
 * .    // 静态方法/类方法
 * .    public static void func(){}
 * .    // 静态内部类
 * .    static class ClassName{}
 * .    // 静态块
 * .    static{}
 * 1.静态成员在类首次出现时在方法区中分配内存,进行类初始化,先初始化静态属性和静态方法,之后从上至下调用静态块
 * 2.静态成员只分配一次内存
 * 3.静态成员由类名调用,(不推荐)也可以用对象名调用
 * 4.静态属性可以通过静态块初始化(实例属性可以由构造函数初始化),也可以不手动初始化,会自动初始化
 * <p>
 * 即:this和super都是实例指针
 * 遵循:(成员)静态属性/方法之间可以互相调用,成员属性/方法可以调静态属性/方法,静态属性/方法不能调用成员属性/方法
 * 成员变量和类变量都可以手动初始化或自动初始化,只有局部变量必须手动初始化
 * <p>
 * <p>
 * final用来定义常量,即:值不可以更改的变量
 * 可以修饰类:该类不能被继承,方法:该方法不能被重写,属性:该属性不能修改
 * 1.在定义时初始化
 * 2.在构造函数/静态块中初始化
 * <p>
 * <p>
 * 封装
 * 包
 * 管理类和接口,解决命名冲突
 * 定义:package *.*.*
 * 使用:import *.*.*
 * <p>
 * 访问限制修饰符:权限控制
 * 保护成员变量:将成员变量隐藏在类内部,不允许外部程序直接访问,保护数据的读取写入
 * 即,公有方法封装私有属性:
 * 将成员变量使用private修饰封装,此时类外不能直接访问该属性,
 * 然后为该属性提供公有方法,返回该属性的值,类外通过该公有方法可获得该私有属性
 * 可分为:1.-- 2.R- 3.-W 4.RW (通过组合getter/setter方法实现)
 * 保护成员方法:成员方法是否允许被调用
 * 可分为:1.同类 2.同包 3.子类 4.任何类
 * <p>
 * 适用范围:
 * .        1.public     2.protected     3.(default)     4.private
 * 类           √              ×               √              ×
 * 属性/方法     √              √               √              √
 * <p>
 * 对于类中,使用 public 和 (default) 限制后访问区别如下:
 * .                    public          (default)
 * same package           √                 √
 * different package      √                 ×
 * <p>
 * 对于方法和属性中,使用四种 限制修饰符 限制后访问区别如下:
 * .               1.public     2.protected     3.(default)     4.private
 * same class          √             √                √              √
 * same package        √             √                √              ×
 * subclass            √             √                ×              ×
 * others              √             ×                ×              ×
 * <p>
 * <p>
 * OOP中需要遵循的设计原则:
 * 1.提取行为,形成接口
 * 2.多用组合(比如接口作为属性,实际调用实现类),少用继承
 * 3.针对接口编程,不依赖于具体实现
 * 4.开闭原则
 * <p>
 * <p>
 * 方法可变参数:形参个数可以变换
 * void func(int param1, int param2, int... param){...}
 * <p>
 * 1.一个方法最多只能有一个可变参数,且一定是所有参数的最后一个
 * 2.可变参数本质上是一个数组,可变参数在方法体内作为数组使用
 * 2.1.形参传入null,此时实参为null
 * 2.2.形参不传入任何值(或者没有此项),此时实参为空数组
 * 2.3.形参传入1个或多个值,此时实参为数组
 * 2.4.形参传入1个数组对象,此时实参为该数组对象
 *
 * @author RABBIT2002
 * @date 2020/12/5
 */
public class Person {
    private String name;
    private String gender;
    private int age = a_static;
    private static int a_static;
    private final int A;
    private final static int A_STATIC;

    static {
        // a_static = 10;
        A_STATIC = 20;
    }

    public Person() {
        this("a", "m", 20);
    }

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;

        this.A = 10;
    }

    public void work() {
        this.name = "qwq";
        this.work("玩游戏");
        System.out.println(this.name + ":吃吃睡睡");

        // 同下说明
        // this.a = 20;
        // this.test();
        Person.a_static = 20;
        Person.test();
    }

    public int work(String s) {
        System.out.println(this.name + ":" + s);
        return 1;
    }

    public static void test() {
        Person.a_static = 20;
        System.out.println("static test");
    }

    public static void func(int... param) {
        System.out.println("param pointer: " + param + ", values: " + Arrays.toString(param));
    }

    public static void main(String[] args) {
        System.out.println(Person.a_static);

        Person person1 = new Person();
        person1.work();
        // Non-static method 'work()' cannot be referenced from a static context
        // Person.work();

        // 可以运行,但是不会有代码提示,且会产生提醒
        // Static member 'javaOop.Chapter08_OOP.Person.a' accessed via instance reference
        // person1.a = 10;
        // Static member 'javaOop.Chapter08_OOP.Person.test()' accessed via instance reference
        // person1.test();

        // 推荐写法
        Person.a_static = 10;
        Person.test();

        func(null);
        func();
        func(1);
        func(1, 2);
        int[] temp = new int[2];
        System.out.println("int[] pointer: " + temp);
        func(temp);

    }

}

package javaOop.Chapter08_OOP;

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
 * .    // (局部变量分配在栈内,不会初始化默认值,作用域:代码块内)
 * .    [访问限制修饰符] 数据类型 属性名
 * .    // 定义 类的成员方法/方法/行为
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
 * 方法重载
 * 在同一类中,方法名相同,方法参数不同(个数/类型/顺序),与返回值无关的多个方法称为方法重载
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
 * 5.且,在构造函数中调用本类构造函数this(),或父类构造函数super(),必须写在第一行
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
 * this是Java的关键字,表示正在运行的对象,代指当前对象的引用
 * 成员变量只有当实例化对象时才分配内存,所以用this指向该对象的成员变量,不能由类直接调用
 * 静态成员由类所属,由类调用,不能用实例调用,不能用this指针
 * //TODO 具体细节
 * <p>
 * <p>
 * 封装
 * 访问限制修饰符
 * 保护成员变量:将成员变量隐藏在类内部,不允许外部程序直接访问,保护数据的读取写入
 * 公有方法封装私有属性:
 * 将成员变量使用private修饰封装,此时类外不能访问该属性,
 * 为该属性提供公有方法,返回该属性的值,类外通过该公有方法获得该私有属性
 * 可分为:1.-- 2.R- 3.-W 4.RW (通过组合getter/setter方法实现)
 * 保护成员方法:成员方法是否允许被调用
 * 可分为:1.同类 2.同包 3.子类 4.任何类
 * <p>
 * 通过 访问限制修饰符 来实现权限控制
 * <p>
 * 适用范围:
 * .        1.public     2.protected     3.(default)     4.private
 * 类           √              ×               √              ×
 * 属性/方法     √              √               √              √
 * <p>
 * 对于类:public和(default)区别如下:
 * .            same package        different package
 * public            √                      √
 * (default)         √                      ×
 * <p>
 * 对于方法和属性,四种限制修饰符区别如下:
 * .        1.public     2.protected     3.(default)     4.private
 * 同类         √             √                √              √
 * 同包         √             √                √              ×
 * 子类         √             √                ×              ×
 * 其他         √             ×                ×              ×
 *
 * @author RABBIT2002
 * @date 2020/12/5
 */
public class Person {
    public String name;
    public String gender;
    public int age;

    public void work() {
        System.out.println(this.name + ":吃吃睡睡");
    }

    public int work(String s) {
        System.out.println(this.name + ":" + s);
        return 1;
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "a";
        person1.gender = "m";
        person1.age = 20;
        person1.work();
        person1.work("玩游戏");
    }

}
